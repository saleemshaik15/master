package com.app.pmvapp.security;

import com.app.pmvapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {

	@Autowired
	UserRepository userRepo;

	public boolean hasUserId(Authentication authentication, Integer driver_id) {

		int userID=userRepo.findByUserName(authentication.getName()).getUserId();
//		System.out.println(userId+"  "+userID);
		if(userID==driver_id)
			return true;

		return false;

	}
}
