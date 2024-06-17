package ubb.movierentals.RentalEntity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.movierentals.grpc.MovieOuterClass;
import ubb.movierentals.grpc.MovieServiceRPCGrpc;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MovieClientService {
    private static final Logger log = LoggerFactory.getLogger(MovieClientService.class);

    @Autowired
    private MovieServiceRPCGrpc.MovieServiceRPCBlockingStub movieServiceStub;

    public MovieOuterClass.Movie getMovieById(Long id) {
        MovieOuterClass.GetMovieRequest request = MovieOuterClass.GetMovieRequest.newBuilder()
                .setMovieId(id)
                .build();

        try {
            log.info("Requesting movie with id {}", id);
            MovieOuterClass.GetMovieResponse response = movieServiceStub.getMovieById(request);
            return response.getMovie();
        } catch (StatusRuntimeException e) {
            log.error("Failed to get movie by id {}: {}", id, e.getStatus());
            throw new RuntimeException("Failed to get movie by id " + id, e);
        }
    }
}
