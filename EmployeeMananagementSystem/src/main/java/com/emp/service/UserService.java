package com.emp.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.emp.dto.UserRegistrationDto;

import com.emp.model.User;
public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
