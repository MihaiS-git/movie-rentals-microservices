package ubb.movierental.MovieEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.movierental.MovieEntity.converter.MovieConverter;
import ubb.movierental.MovieEntity.dto.MovieDto;
import ubb.movierental.MovieEntity.exception.DataBaseOperationException;
import ubb.movierental.MovieEntity.exception.ResourceNotFoundException;
import ubb.movierental.MovieEntity.model.Movie;
import ubb.movierental.MovieEntity.service.IMovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private MovieConverter movieConverter;


    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDto>> getMovies() {
        try {
            List<Movie> movies = movieService.getAllMovies();
            List<MovieDto> moviesDto = movies.stream()
                    .map(m -> movieConverter.convertModelToDto(m))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(moviesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long movieId) {
        try {
            Movie movie = movieService.getMovieById(movieId);
            MovieDto movieDto = movieConverter.convertModelToDto(movie);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(movieDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto dto) {
        try {
            Movie movie = movieConverter.convertDtoToModel(dto);
            Movie savedMovie = movieService.addMovie(movie);
            MovieDto movieDto = movieConverter.convertModelToDto(savedMovie);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(movieDto);
        } catch (DataBaseOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<MovieDto> updateMovie(
            @PathVariable final Long movieId,
            @RequestBody final MovieDto dto) {

        try{
            Movie movie = movieService.updateMovie(movieId, movieConverter.convertDtoToModel(dto));
            MovieDto updatedMovieDto = movieConverter.convertModelToDto(movie);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedMovieDto);
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        try {
            movieService.deleteMovieById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
