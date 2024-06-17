package ubb.movierental.MovieEntity.service;


import ubb.movierental.MovieEntity.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAllMovies();

    Movie addMovie(Movie movie);

    Movie getMovieById(Long id);

    Movie updateMovie(Long movieId, Movie movie);

    void deleteMovieById(Long id);

}
