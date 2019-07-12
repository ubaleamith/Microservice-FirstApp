package com.demoMicro.ratinginfo.service;

import java.util.List;

import javax.validation.Valid;

import com.demoMicro.ratinginfo.pojos.Rating;

public interface RatingService {

	Rating saveRating(@Valid Rating userData);

	List<Rating> getAllRating();

	Rating getRatingById(Integer userId);

	void deleteRatingById(Integer userId);

}
