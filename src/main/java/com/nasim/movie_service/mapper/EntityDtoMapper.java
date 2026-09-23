package com.nasim.movie_service.mapper;

import com.nasim.movie_service.dto.MovieDto;
import com.nasim.movie_service.enity.Movie;

public class EntityDtoMapper {
    public static MovieDto mapToDto(Movie movie){
        return  new MovieDto(movie.getId(),movie.getName(),movie.getReleaseYear(),movie.getGenre());
    }
}
