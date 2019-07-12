package com.demoMicro.ratinginfo.controller;

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

import com.demoMicro.ratinginfo.ApiSuccess;
import com.demoMicro.ratinginfo.pojos.Rating;
import com.demoMicro.ratinginfo.service.RatingService;

@RestController
@RequestMapping("/ratingData")
public class RatingContoller {

	@Autowired
	RatingService ratingService;

	@PostMapping("/rating")
	public ResponseEntity<Object> saveRating(@RequestBody Rating rating) {
		System.out.println("inisde saveeeee");
		ratingService.saveRating(rating);
		System.out.println("after saveeeee");
		return buildResponseEntity(new ApiSuccess(HttpStatus.CREATED, rating.getId()));
	}

	@GetMapping("/rating")
	public ResponseEntity<Object> getRating() {
		List<Rating> listOfUsers = ratingService.getAllRating();
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK, listOfUsers));
	}

	@GetMapping("/rating/{id}")
	public ResponseEntity<Object> getRatingById(@PathVariable Integer id) {
		Rating Rating = ratingService.getRatingById(id);
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK, Rating));
	}

	@PutMapping("/rating/{id}")
	public ResponseEntity<Object> updateRating(@RequestBody Rating userData, @PathVariable Integer id) {
		Rating rating = ratingService.getRatingById(id);
		System.out.println("inside update=====" + rating);
		if (rating == null) {
			return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
		}
		rating.setMovie(userData.getMovie());
		rating.setRating(userData.getRating());
		ratingService.saveRating(rating);
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK));
	}

	@DeleteMapping("/rating/{id}")
	public ResponseEntity<Object> deleteRatingById(@PathVariable Integer id) {
		Rating rating = ratingService.getRatingById(id);
		System.out.println("inside update=====" + rating);
		if (rating == null) {
			return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
		}
		ratingService.deleteRatingById(id);
		return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
	}

	// formatting of the success response
	public static ResponseEntity<Object> buildResponseEntity(ApiSuccess apiSuccess) {
		return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
	}

}
