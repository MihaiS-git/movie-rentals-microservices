package ubb.movierental.MovieEntity.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ubb.movierental.MovieEntity.service.MovieServiceRPCImpl;

import java.io.IOException;


@Configuration
public class GrpcServerConfiguration {

    // Define the port for the gRPC server
    private static final int GRPC_SERVER_PORT = 9092;

    @Bean
    public Server grpcServer(MovieServiceRPCImpl movieServiceRPC) {
        // Create and configure the gRPC server
        Server server = ServerBuilder.forPort(GRPC_SERVER_PORT)
                .addService(movieServiceRPC)
                .build();

        // Start the server
        try {
            server.start();
            System.out.println("gRPC server started, listening on port " + GRPC_SERVER_PORT);
        } catch (IOException e) {
            System.err.println("Failed to start gRPC server: " + e.getMessage());
        }

        return server;
    }
}

