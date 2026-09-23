package com.nasim.movie_service.service.impl;

import com.nasim.movie_service.dto.MovieDto;
import com.nasim.movie_service.enity.Genre;
import com.nasim.movie_service.mapper.EntityDtoMapper;
import com.nasim.movie_service.repository.MovieRepository;
import com.nasim.movie_service.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<MovieDto> getAll(){
        return movieRepository.findAll()
                .stream().map(EntityDtoMapper::mapToDto).toList();
    }
    @Override
    @Transactional(readOnly = true)
    public List<MovieDto> getAll(Genre selectedGenre){
        return movieRepository.findAllByGenre(selectedGenre)
                .stream().map(EntityDtoMapper::mapToDto).toList();
    }
}
