package ubb.movierentals.RentalEntity.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ubb.movierentals.grpc.MovieServiceRPCGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class GrpcClientConfig {
    private static final Logger log = LoggerFactory.getLogger(GrpcClientConfig.class);

    private String movieServiceHost = "movieentity";

    private int movieServicePort = 9092;

    @Bean
    public ManagedChannel managedChannel() {
        log.info("Creating ManagedChannel for {}:{}", movieServiceHost, movieServicePort);
        return ManagedChannelBuilder.forAddress(movieServiceHost, movieServicePort)
                .usePlaintext()
                .build();
    }

    @Bean
    public MovieServiceRPCGrpc.MovieServiceRPCBlockingStub movieServiceStub(ManagedChannel channel) {
        log.info("Creating MovieServiceRPCBlockingStub");
        return MovieServiceRPCGrpc.newBlockingStub(channel);
    }

}
