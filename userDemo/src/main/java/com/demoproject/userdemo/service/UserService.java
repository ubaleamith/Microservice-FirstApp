package com.demoproject.userdemo.service;

import java.util.List;

import javax.validation.Valid;

import com.demoproject.userdemo.pojos.UserDetails;

public interface UserService {

	UserDetails saveUserDetails(@Valid UserDetails userData);

	List<UserDetails> getUsersDetails();

	UserDetails getUserDetailsById(Integer userId);

	void deleteUserDetailsById(Integer userId);

}
