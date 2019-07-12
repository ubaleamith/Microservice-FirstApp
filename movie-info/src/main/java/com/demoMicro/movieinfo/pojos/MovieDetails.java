package com.demoMicro.movieinfo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_details")
public class MovieDetails {

	@Id
	private int id;
	private String name;
	private String moviedesc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoviedesc() {
		return moviedesc;
	}

	public void setMoviedesc(String moviedesc) {
		this.moviedesc = moviedesc;
	}

	@Override
	public String toString() {
		return "MovieDetails [id=" + id + ", name=" + name + ", moviedesc=" + moviedesc + "]";
	}
	
}
