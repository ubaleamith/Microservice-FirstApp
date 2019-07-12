package com.demoMicro.movieinfo.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoMicro.movieinfo.pojos.*;

public interface MovieRepository extends JpaRepository<MovieDetails, Integer> {

}
