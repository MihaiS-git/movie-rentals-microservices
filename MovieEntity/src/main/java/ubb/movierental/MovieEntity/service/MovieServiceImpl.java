package ubb.movierental.MovieEntity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubb.movierental.MovieEntity.exception.DataBaseOperationException;
import ubb.movierental.MovieEntity.exception.ResourceNotFoundException;
import ubb.movierental.MovieEntity.model.Movie;
import ubb.movierental.MovieEntity.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService {
    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    

    @Override
    public List<Movie> getAllMovies() {
        log.trace("getAllMovies --- method entered");
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            log.error("getAllMovies --- movie list is empty");
            throw new ResourceNotFoundException("No Clients found");
        }
        log.trace("getAllMovies: movies={}", movies);
        return movies;
    }

    @Override
    public Movie addMovie(Movie movie) {
        log.trace("addMovie --- method entered");
        try {
            Movie result = movieRepository.save(movie);
            log.trace("addMovie: result={}", result);
            rabbitMQSender.send("Movie saved.");
            return result;
        } catch (DataIntegrityViolationException e) {
            rabbitMQSender.send("Failed saving new Movie.");
            log.error("Error while saving movie: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving movie: " + e.getMessage());
        }
    }

    @Override
    public Movie getMovieById(Long id) {
        log.trace("getMovieById --- method entered");
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            log.error("getMovieById --- movie is empty");
            throw new ResourceNotFoundException("Movie not found");
        }
        Movie result = optionalMovie.get();
        log.trace("getMovieById: movie={}", result);
        return result;
    }

    @Transactional
    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        log.trace("updateClient --- method entered");
        Optional<Movie> result = movieRepository.findById(movieId);
        if (result.isPresent()) {
            Movie updatedMovie = result.get();
            updatedMovie.setTitle(movie.getTitle());
            updatedMovie.setYear(movie.getYear());
            updatedMovie.setGenre(movie.getGenre());
            updatedMovie.setAgeRestrictions(movie.getAgeRestrictions());
            updatedMovie.setRentalPrice(movie.getRentalPrice());
            updatedMovie.setAvailable(movie.isAvailable());
            log.trace("updateMovie: result={}", result.get());
            rabbitMQSender.send("Movie updated.");
            return movieRepository.save(updatedMovie);
        } else {
            log.error("updateMovie: movie is empty");
            rabbitMQSender.send("No Movie found with the given ID.");
            throw new ResourceNotFoundException("Movie not found");
        }
    }

    @Override
    public void deleteMovieById(Long id) {
        log.trace("deleteMovieById --- method entered");
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(id);
            log.trace("deleteMovieById: movie deleted successfully");
            rabbitMQSender.send("Movie deleted");

        } else {
            log.error("deleteMovieById: movie is empty");
            rabbitMQSender.send("deleteMovieById --- no Movie found");
            throw new ResourceNotFoundException("Movie not found");
        }
    }
}
