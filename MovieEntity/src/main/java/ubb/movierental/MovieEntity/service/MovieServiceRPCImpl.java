package ubb.movierental.MovieEntity.service;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import ubb.movierental.MovieEntity.exception.ResourceNotFoundException;
import ubb.movierental.MovieEntity.model.AgeRestrictions;
import ubb.movierental.MovieEntity.model.Movie;
import ubb.movierental.MovieEntity.model.MovieGenres;
import ubb.movierental.MovieEntity.repository.MovieRepository;
import ubb.movierentals.grpc.MovieOuterClass;
import ubb.movierentals.grpc.MovieServiceRPCGrpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@GRpcService
public class MovieServiceRPCImpl extends MovieServiceRPCGrpc.MovieServiceRPCImplBase {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void getAllMovies(
            MovieOuterClass.GetMoviesRequest request,
            StreamObserver<MovieOuterClass.GetMoviesResponse> responseObserver
    ) {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            responseObserver.onError(new ResourceNotFoundException("No Movies found"));
            return;
        }
        List<MovieOuterClass.Movie> grpcMovies = new ArrayList<>();
        for (Movie movie : movies) {
            grpcMovies.add(MovieOuterClass.Movie.newBuilder()
                    .setId(movie.getId())
                    .setTitle(movie.getTitle())
                    .setYear(movie.getYear())
                    .setGenre(MovieOuterClass.MovieGenres.valueOf(movie.getGenre().name()))
                    .setAgeRestrictions(MovieOuterClass.AgeRestrictions.valueOf(movie.getAgeRestrictions().name()))
                    .setRentalPrice(movie.getRentalPrice())
                    .setAvailable(movie.isAvailable())
                    .build());
        }

        MovieOuterClass.GetMoviesResponse response = MovieOuterClass.GetMoviesResponse.newBuilder()
                .addAllMovies(grpcMovies)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMovieById(
            MovieOuterClass.GetMovieRequest request,
            StreamObserver<MovieOuterClass.GetMovieResponse> responseObserver
    ) {
        Long movieId = request.getMovieId();
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            MovieOuterClass.GetMovieResponse response = MovieOuterClass.GetMovieResponse.newBuilder()
                    .setMovie(MovieOuterClass.Movie.newBuilder()
                            .setId(movie.getId())
                            .setTitle(movie.getTitle())
                            .setYear(movie.getYear())
                            .setGenre(MovieOuterClass.MovieGenres.valueOf(movie.getGenre().name()))
                            .setAgeRestrictions(MovieOuterClass.AgeRestrictions.valueOf(movie.getAgeRestrictions().name()))
                            .setRentalPrice(movie.getRentalPrice())
                            .setAvailable(movie.isAvailable())
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND.withDescription("Movie not found")));
        }
    }

    @Override
    public void addMovie(
            MovieOuterClass.AddMovieRequest request,
            StreamObserver<MovieOuterClass.AddMovieResponse> responseObserver
    ) {
        String title = request.getMovie().getTitle();
        int year = request.getMovie().getYear();
        MovieGenres genre = MovieGenres.valueOf(request.getMovie().getGenre().name());
        AgeRestrictions ageRestrictions = AgeRestrictions.valueOf(request.getMovie().getAgeRestrictions().name());
        double rentalPrice = request.getMovie().getRentalPrice();
        boolean available = request.getMovie().getAvailable();

        Movie movie = new Movie(title, year, genre, ageRestrictions, rentalPrice, available);

        Movie savedMovie = movieRepository.save(movie);

        MovieOuterClass.AddMovieResponse response = MovieOuterClass.AddMovieResponse.newBuilder()
                .setMovie(MovieOuterClass.Movie.newBuilder()
                        .setId(savedMovie.getId())
                        .setTitle(savedMovie.getTitle())
                        .setGenre(MovieOuterClass.MovieGenres.valueOf(savedMovie.getGenre().name()))
                        .setAgeRestrictions(MovieOuterClass.AgeRestrictions.valueOf(savedMovie.getAgeRestrictions().name()))
                        .setRentalPrice(savedMovie.getRentalPrice())
                        .setAvailable(savedMovie.isAvailable())
                        .build()
                )
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateMovie(
            MovieOuterClass.UpdateMovieRequest request,
            StreamObserver<MovieOuterClass.UpdateMovieResponse> responseObserver
    ) {
        MovieOuterClass.Movie updatedMovieProto = request.getMovie();
        Long movieId = request.getMovieId();
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(updatedMovieProto.getTitle());
            movie.setYear(updatedMovieProto.getYear());
            movie.setGenre(MovieGenres.valueOf(updatedMovieProto.getGenre().name()));
            movie.setAgeRestrictions(AgeRestrictions.valueOf(updatedMovieProto.getAgeRestrictions().name()));
            movie.setRentalPrice(updatedMovieProto.getRentalPrice());
            movie.setAvailable(updatedMovieProto.getAvailable());
            Movie updatedMovie = movieRepository.save(movie);

            MovieOuterClass.UpdateMovieResponse response = MovieOuterClass.UpdateMovieResponse.newBuilder()
                    .setMovie(MovieOuterClass.Movie.newBuilder()
                            .setId(updatedMovie.getId())
                            .setTitle(updatedMovie.getTitle())
                            .setYear(updatedMovie.getYear())
                            .setGenre(MovieOuterClass.MovieGenres.valueOf(updatedMovie.getGenre().name()))
                            .setAgeRestrictions(MovieOuterClass.AgeRestrictions.valueOf(updatedMovie.getAgeRestrictions().name()))
                            .setRentalPrice(updatedMovie.getRentalPrice())
                            .setAvailable(updatedMovie.isAvailable())
                    )
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND.withDescription("Movie not found")));
        }
    }


    @Override
    public void deleteMovieById(
            MovieOuterClass.DeleteMovieRequest request,
            StreamObserver<MovieOuterClass.DeleteMovieResponse> responseObserver
    ){
        Long movieId = request.getId();

        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(movieId);
            MovieOuterClass.DeleteMovieResponse response = MovieOuterClass.DeleteMovieResponse.newBuilder()
                    .setMessage("Movie deleted successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND.withDescription("Movie not found")));
        }
    }
}
