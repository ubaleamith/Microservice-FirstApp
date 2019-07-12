package com.demoMicro.ratinginfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoMicro.ratinginfo.dao.user.RatingRepository;
import com.demoMicro.ratinginfo.pojos.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRatingById(Integer userId) {
		System.out.println("before execute ");
		Rating rating = null;
		try {
			rating = ratingRepository.findById(userId).get();
		} catch (Exception e) {
			System.out.println("after execute " + e);
		}
		return rating;
	}

	@Override
	public void deleteRatingById(Integer id) {
		ratingRepository.deleteById(id);
	}
}
