package com.ase.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ase.model.User;
import com.ase.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User entity = userRepository.findByEmail(username);
		
		if(entity == null) {
			throw new UsernameNotFoundException("User not found!!");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(entity);
		return customUserDetails;
	}

}
