package com.nasim.movie_service.dto;


import com.nasim.movie_service.enity.Genre;

public record MovieDto(Integer id, String name , Integer releaseYear, Genre genre) {
}
