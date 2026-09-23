package com.nasim.movie_service.repository;

import com.nasim.movie_service.enity.Genre;
import com.nasim.movie_service.enity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    List<Movie>  findAllByGenre(Genre selectedGenre);
}
