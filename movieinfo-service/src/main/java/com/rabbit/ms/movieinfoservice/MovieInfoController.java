package com.rabbit.ms.movieinfoservice;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@GetMapping("/list")
	public List<MovieInfo> list() {
		MovieInfo mi1 = new MovieInfo();
		mi1.setId("M1");
		mi1.setGenre("Drama");
		mi1.setName("Forest Gump");
		mi1.setReleaseYear(1994);
		
		MovieInfo mi2 = new MovieInfo();
		mi2.setId("M2");
		mi2.setGenre("Action");
		mi2.setName("Pulp Fiction");
		mi2.setReleaseYear(1992);
		
		List<MovieInfo> movieInfoList = new ArrayList<MovieInfo>();
		movieInfoList.add(mi1);
		movieInfoList.add(mi2);
		
		return movieInfoList;
	}
	
	@GetMapping("/{movieid}")
	public MovieInfo get(@PathVariable("movieid") final String movieid) {
		List<MovieInfo> movieInfoList = list();
		for (MovieInfo mi : movieInfoList) {
			if (mi.getId().equals(movieid)) {
				return mi;
			}
		}
		return null;
	}
}
