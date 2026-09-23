package com.nasim.movie_service.service;

import com.nasim.movie_service.dto.MovieDto;
import com.nasim.movie_service.enity.Genre;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAll();

    List<MovieDto> getAll(Genre selectedGenre);
}
