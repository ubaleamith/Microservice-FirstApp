package com.demoproject.userdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.userdemo.dao.user.UserRepository;
import com.demoproject.userdemo.pojos.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails saveUserDetails(UserDetails userDetails) {
		return userRepository.save(userDetails);
	}

	@Override
	public List<UserDetails> getUsersDetails() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails getUserDetailsById(Integer userId) {
		System.out.println("before execute ");
		UserDetails userDetails = null;
		try {
			userDetails = userRepository.findById(userId).get();
		} catch (Exception e) {
			System.out.println("after execute " + e);
		}
		return userDetails;
	}

	@Override
	public void deleteUserDetailsById(Integer id) {
		userRepository.deleteById(id);
	}
}
