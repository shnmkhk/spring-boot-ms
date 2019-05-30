
package com.rabbit.ms.moviecatalogueservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalogues")
public class MovieCatalogueController {

	@Autowired
    WebClient.Builder webClientBuilder;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/list")
	public List<MovieCatalogue> list() {
		
		MovieInfo mi1 = restTemplate.getForObject("http://movie-info-service/movies/M1", MovieInfo.class);
		MovieInfo mi2 = restTemplate.getForObject("http://movie-info-service/movies/M2", MovieInfo.class);
		
		
		List<MovieCatalogue> mcs = new ArrayList<MovieCatalogue>();
		MovieCatalogue mc = new MovieCatalogue();
		mc.setName("90s Movies");
		mc.setYear("1990");
		mc.setMovieNames(Arrays.asList(new String[] {mi1.getName(), mi2.getName()}));
		mcs.add(mc);
		
		MovieCatalogue mc_two = new MovieCatalogue();
		mc_two.setName("80s Movies");
		mc_two.setYear("1980");
		mcs.add(mc_two);
		
		return mcs;
	}
}