package com.demoMicro.ratinginfo.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoMicro.ratinginfo.pojos.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
