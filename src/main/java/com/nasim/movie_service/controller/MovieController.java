package com.nasim.movie_service.controller;

import com.nasim.movie_service.dto.MovieDto;
import com.nasim.movie_service.enity.Genre;
import com.nasim.movie_service.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<MovieDto> getAll(){
        return  movieService.getAll();
    }
    @GetMapping("/{genre}")
    public List<MovieDto> getAllByGenre(@PathVariable(name = "genre")  Genre genre){
        return  movieService.getAll(genre);
    }

}
