package com.demoMicro.movieinfo.service;

import java.util.List;

import javax.validation.Valid;

import com.demoMicro.movieinfo.pojos.MovieDetails;

public interface MovieService {

	MovieDetails saveMovieDetails(@Valid MovieDetails movieData);

	List<MovieDetails> getMoviesDetails();

	MovieDetails getMovieDetailsById(Integer movieId);

	void deleteMovieDetailsById(Integer movieId);

}
