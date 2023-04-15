package com.app.pmvapp.service;

import com.app.pmvapp.model.User;
import com.app.pmvapp.model.UserDetailsImpl;
import com.app.pmvapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepo.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username + "not found");
		}
		return new UserDetailsImpl(user);
	}



}
