package com.app.pmvapp.service;


import com.app.pmvapp.model.User;
import com.app.pmvapp.model.UserDetailsImpl;
import com.app.pmvapp.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsServiceImpl userDetails;

//    UserDetailsService userDetailsService;
//
//    @Autowired
//    public UserService(@Lazy UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }


    public List<User> findAllUsers() {
        return userRepo.findAll();
    }


    public Optional<User> findUserById(int id) {
        return userRepo.findById(id);
    }

    public User findByUserName(String userName) {

        User user=userRepo.findByUserName(userName);
        return user;

    }

    public User saveUser(User newUser) {
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        User user=userRepo.save(newUser);
        return user;

    }

    public User updateUser(int id,User user) {

        Optional<User> retrievedUser=userRepo.findById(id);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepo.save(user);
        return userRepo.findById(id).get();

    }

    public User deleteUser(int userId) {

        Optional<User> retrievedUser=userRepo.findById(userId);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepo.deleteById(userId);
        return retrievedUser.get();



    }

    public String getUsersByIdAndPassword(String id,String pass) {
        //userDetailsService.loadUserByUsername()
        //User user = userDetails.loadUserByUsername(id);
        //String userWithRole = user.getUserName() + "," + user.getRole();
        return "";
    }











//	public void autoLogin(String userName, String password) {
//
//		UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
//		UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
//
//		authenticationManager.authenticate(token);
//
//		if(token.isAuthenticated()) {
//			SecurityContextHolder.getContext().setAuthentication(token);
//		}
//
//	}


//	@Autowired
//	private AuthenticationManager authenticationManager;

//	@Autowired
//	private UserDetailsService userDetailsService;




}
