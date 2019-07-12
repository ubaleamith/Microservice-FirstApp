package com.demoMicro.movieinfo.controller;

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
import com.demoMicro.movieinfo.pojos.MovieDetails;
import com.demoMicro.movieinfo.service.MovieService;
import com.demoMicro.movieinfo.ApiSuccess;

@RestController
@RequestMapping("/moviedata")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/moviedetails")
	public ResponseEntity<Object> saveMovieDetails(@RequestBody MovieDetails movieData) {
		movieService.saveMovieDetails(movieData);
		return buildResponseEntity(new ApiSuccess(HttpStatus.CREATED));
	}

	@GetMapping("/moviedetails")
	public ResponseEntity<Object> getMovieDetails() {
		List<MovieDetails> listOfMovies = movieService.getMoviesDetails();
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK, listOfMovies));
	}

	@GetMapping("/moviedetails/{id}")
	public ResponseEntity<Object> getMovieDetailsById(@PathVariable Integer id) {
		MovieDetails MovieDetails = movieService.getMovieDetailsById(id);
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK, MovieDetails));
	}	

	@PutMapping("/moviedetails/{id}")
	public ResponseEntity<Object> updateMovieDetails(@RequestBody MovieDetails movieData, @PathVariable Integer id) {
		MovieDetails MovieDetails = movieService.getMovieDetailsById(id);
		System.out.println("inside update=====" + MovieDetails);
		if (MovieDetails == null) {
			return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
		}
		MovieDetails.setName(movieData.getName());
		MovieDetails.setMoviedesc(movieData.getMoviedesc());
		movieService.saveMovieDetails(MovieDetails);
		return buildResponseEntity(new ApiSuccess(HttpStatus.OK));
	}

	@DeleteMapping("/moviedetails/{id}")
	public ResponseEntity<Object> deleteMovieDetailsById(@PathVariable Integer id) {
		MovieDetails MovieDetails = movieService.getMovieDetailsById(id);
		System.out.println("inside update=====" + MovieDetails);
		if (MovieDetails == null) {
			return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
		}
		movieService.deleteMovieDetailsById(id);
		return buildResponseEntity(new ApiSuccess(HttpStatus.NO_CONTENT));
	}

	// formatting of the success response
	public static ResponseEntity<Object> buildResponseEntity(ApiSuccess apiSuccess) {
		return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
	}

}
