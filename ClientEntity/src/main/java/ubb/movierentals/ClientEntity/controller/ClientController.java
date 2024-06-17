package ubb.movierentals.ClientEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.movierentals.ClientEntity.converter.ClientConverter;
import ubb.movierentals.ClientEntity.dto.ClientDto;
import ubb.movierentals.ClientEntity.exception.DataBaseOperationException;
import ubb.movierentals.ClientEntity.exception.ResourceNotFoundException;
import ubb.movierentals.ClientEntity.model.Client;
import ubb.movierentals.ClientEntity.service.IClientService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private ClientConverter clientConverter;


    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity<List<ClientDto>> getClients() {
        try {
            List<Client> clients = clientService.getAllClients();
            List<ClientDto> result = clients.stream()
                    .map(c -> clientConverter.convertModelToDto(c))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(result);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());
        }
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long clientId) {
        try {
            Client client = clientService.getClientById(clientId);
            ClientDto clientDto = clientConverter.convertModelToDto(client);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(clientDto);
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ClientDto());
        }
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto dto) {
        try {
            Client client = clientConverter.convertDtoToModel(dto);
            Client savedClient = clientService.addClient(client);
            ClientDto clientDto = clientConverter.convertModelToDto(savedClient);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(clientDto);
        } catch (DataBaseOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ClientDto());
        }
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<ClientDto> updateClient(
            @PathVariable final Long clientId,
            @RequestBody final ClientDto dto) {
        try {
            Client updatedClient = clientService.updateClient(clientId, clientConverter.convertDtoToModel(dto));
            ClientDto updatedClientDto = clientConverter.convertModelToDto(updatedClient);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedClientDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ClientDto());
        }
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClientById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ClientDto());
        }
    }
}
