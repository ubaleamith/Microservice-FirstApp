package com.demoMicro.moviecatalog.pojos;


public class MovieDetails {

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
