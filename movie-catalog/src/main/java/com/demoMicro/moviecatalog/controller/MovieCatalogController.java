package com.demoMicro.moviecatalog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demoMicro.moviecatalog.ApiSuccess;
import com.demoMicro.moviecatalog.pojos.MovieDetails;

@RestController
@RequestMapping("/moviecatalog")
public class MovieCatalogController {
	
 

@GetMapping("/moviecatalogdetails/{id}")
public ResponseEntity<Object> getAllMovieInfo(@PathVariable Integer id) {
	 RestTemplate restTemplate=new RestTemplate();
	System.out.println("inside getAllMovieInfo===================");
	MovieDetails movieDetails=restTemplate.getForObject("http://192.168.1.9:8082/moviedata/moviedetails/"+id,MovieDetails.class);
	System.out.println("after getAllMovieInfo==================="+movieDetails);
    return buildResponseEntity(new ApiSuccess(HttpStatus.OK ,movieDetails));
}

public static ResponseEntity<Object> buildResponseEntity(ApiSuccess apiSuccess) {
	return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
}



}
