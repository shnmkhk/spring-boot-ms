package com.rabbit.ms.moviecatalogueservice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView(MovieCatalogue.class)
public class MovieCatalogue {

	private String name;
	private String year;
	private List<String> movieNames;
	
	public List<String> getMovieNames() {
		return movieNames;
	}
	public void setMovieNames(List<String> movieNames) {
		this.movieNames = movieNames;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
