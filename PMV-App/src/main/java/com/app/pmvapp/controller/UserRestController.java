package com.app.pmvapp.controller;

import com.app.pmvapp.model.User;
import com.app.pmvapp.repository.UserRepository;
import com.app.pmvapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserRestController {
	
	@Autowired
	UserService userService;
	@Autowired
	private UserRepository userRepository;

	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
	@GetMapping("/all")
	public List<User> getAllUsers(Authentication authentication) {
		return userService.findAllUsers();
		
	}
		
	@PostMapping("/create")
	public ResponseEntity<User> saveUsers(@RequestBody User newUser) {
		//System.out.println(newUser.getUserName()+"  "+auth.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body((userService.saveUser(newUser)));
		
	}
	
	//@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId, Authentication authentication) {
		System.out.println("Inside getuserbyid method");
		return ResponseEntity.ok().body(userService.findUserById(userId).get());
		
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int UserId,@RequestBody User newUser) {
		return ResponseEntity.ok().body(userService.updateUser(UserId,newUser));
		
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userId") int UserId) {
		 userService.deleteUser(UserId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@GetMapping("/search")
	//@PostAuthorize("returnObject.body.userName==authenticated.user")
	public ResponseEntity<User> userDetails(Authentication authentication, @RequestParam("cname") String cName) throws Exception {
		System.out.println(authentication.getName().toString());
		User User=userService.findByUserName(cName);
		if(User==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.ok().body(User);
		
	}

	@GetMapping("/login")
	public String login(Authentication authentication) {
		System.out.println(authentication.getName());
		Optional<? extends GrantedAuthority> optionalGrantedAuthority = authentication.getAuthorities().stream().findFirst();
		if (optionalGrantedAuthority.isPresent()){
			Integer userId = userRepository.findByUserName(authentication.getName()).getUserId();
			return authentication.getName()+"-"+ optionalGrantedAuthority.get().getAuthority()+"-"+ userId;
		}
		return "wrong credentials";
	}

}
