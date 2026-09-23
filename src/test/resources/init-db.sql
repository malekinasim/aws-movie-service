CREATE TABLE Movie (
    id SERIAL PRIMARY KEY ,
    name varchar(255) not null,
    release_year INTEGER not null ,
    genre varchar(100)
);

insert into movie (name,release_year,genre)
    values
            ('inception',2010,'ACTION'),
            ('The Godfather',1972,'CRIME'),
            ('Mad max: fury road',2015,'ACTION'),
            ('die hard ',1988,'ACTION'),
            ('pulp fiction',1994,'CRIME'),
            ('superbad',2007,'COMEDY');