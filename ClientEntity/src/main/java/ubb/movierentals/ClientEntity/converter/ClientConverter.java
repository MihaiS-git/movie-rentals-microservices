package ubb.movierentals.ClientEntity.converter;

import org.springframework.stereotype.Component;
import ubb.movierentals.ClientEntity.dto.ClientDto;
import ubb.movierentals.ClientEntity.model.Client;

@Component
public class ClientConverter {

    public Client convertDtoToModel(ClientDto dto) {
        Client client = Client.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .email(dto.getEmail())
                .subscribe(dto.isSubscribe())
                .build();
        return client;
    }

    public ClientDto convertModelToDto(Client client) {
        ClientDto dto = ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .dateOfBirth(client.getDateOfBirth())
                .email(client.getEmail())
                .subscribe(client.isSubscribe())
                .build();
        return dto;
    }
}
