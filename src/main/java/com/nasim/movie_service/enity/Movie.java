package com.nasim.movie_service.enity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private Integer id;
    @Column(name="title")
    private String name;
    private Integer releaseYear;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
