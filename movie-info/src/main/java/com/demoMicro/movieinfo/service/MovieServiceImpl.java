package com.demoMicro.movieinfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demoMicro.movieinfo.dao.user.MovieRepository;
import com.demoMicro.movieinfo.pojos.MovieDetails;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public MovieDetails saveMovieDetails(MovieDetails userDetails) {
		return movieRepository.save(userDetails);
	}

	@Override
	public List<MovieDetails> getMoviesDetails() {
		return movieRepository.findAll();
	}

	@Override
	public MovieDetails getMovieDetailsById(Integer MovieId) {
		System.out.println("before execute ");
		MovieDetails MovieDetails = null;
		try {
			MovieDetails = movieRepository.findById(MovieId).get();
		} catch (Exception e) {
			System.out.println("after execute " + e);
		}
		System.out.println("MovieDetails-----"+MovieDetails);
		return MovieDetails;
	}

	@Override
	public void deleteMovieDetailsById(Integer id) {
		movieRepository.deleteById(id);
	}

}
