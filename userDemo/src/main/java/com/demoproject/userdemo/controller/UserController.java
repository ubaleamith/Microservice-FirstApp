package com.demoproject.userdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.userdemo.ApiSuccess;
import com.demoproject.userdemo.pojos.UserDetails;
import com.demoproject.userdemo.service.UserService;

@RestController
@RequestMapping("/userData")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/UserDetails")
	public ResponseEntity<Object> saveUserDetails(@RequestBody UserDetails userData) {
		userService.saveUserDetails(userData);
		return buildResponseEntity(new ApiSuccess(HttpStatus.CREATED));
	}

	@GetMapping("/UserDetails")
	public ResponseEntity<Object> getUserDetails() {
		List<UserDetails> listOfUsers = userService.getUsersDetails();
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK, listOfUsers));
	}

	@GetMapping("/UserDetails/{id}")
	public ResponseEntity<Object> getUserDetailsById(@PathVariable Integer id) {
		UserDetails userDetails = userService.getUserDetailsById(id);
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK, userDetails));
	}

	@PutMapping("/UserDetails/{id}")
	public ResponseEntity<Object> updateUserDetails(@RequestBody UserDetails userData, @PathVariable Integer id) {
		UserDetails userDetails = userService.getUserDetailsById(id);
		System.out.println("inside update=====" + userDetails);
		if (userDetails == null) {
			return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
		}
		userDetails.setName(userData.getName());
		userDetails.setEmail(userData.getEmail());
		userService.saveUserDetails(userDetails);
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK));
	}

	@DeleteMapping("/UserDetails/{id}")
	public ResponseEntity<Object> deleteUserDetailsById(@PathVariable Integer id) {
		UserDetails userDetails = userService.getUserDetailsById(id);
		System.out.println("inside update=====" + userDetails);
		if (userDetails == null) {
			return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
		}
		userService.deleteUserDetailsById(id);
		return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
	}

	// formatting of the success response
	public static ResponseEntity<Object> buildResponseEntity(ApiSuccess apiSuccess) {
		return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
	}

}
