package ubb.movierentals.ClientEntity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubb.movierentals.ClientEntity.exception.DataBaseOperationException;
import ubb.movierentals.ClientEntity.exception.ResourceNotFoundException;
import ubb.movierentals.ClientEntity.model.Client;
import ubb.movierentals.ClientEntity.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public List<Client> getAllClients() {
        log.trace("getAllClients --- method entered");
        List<Client> result = clientRepository.findAll();
        if (result.isEmpty()) {
            log.error("getAllClients --- client list is empty");
            throw new ResourceNotFoundException("No Clients found");
        }
        log.trace("getAllClients: result={}", result);
        return result;
    }

    @Override
    public Client getClientById(Long id) {
        log.trace("getClientById --- method entered");
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            log.error("getClientById --- null");
            throw new ResourceNotFoundException("Client not found");
        }
        Client result = optionalClient.get();
        log.trace("getClientById: client={}", result);
        return result;
    }

    @Override
    public Client addClient(Client client) {
        log.trace("addClient --- method entered");
        try {
            Client savedClient = clientRepository.save(client);
            log.trace("addClient: client={}", savedClient);
            rabbitMQSender.send("Client saved.");
            return savedClient;
        } catch (DataIntegrityViolationException e) {
            rabbitMQSender.send("Failed saving new Client.");
            log.error("Error while saving client: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving client: " + e.getMessage());
        }
    }

    @Transactional
    @Override
    public Client updateClient(Long clientId, Client client) {
        log.trace("updateClient --- method entered");
        Optional<Client> result = clientRepository.findById(clientId);
        if (result.isPresent()) {
            Client updatedClient = result.get();
            updatedClient.setFirstName(client.getFirstName());
            updatedClient.setLastName(client.getLastName());
            updatedClient.setDateOfBirth(client.getDateOfBirth());
            updatedClient.setEmail(client.getEmail());
            updatedClient.setSubscribe(client.isSubscribe());
            log.trace("updatedClient: result={}", result.get());
            Client savedClient = clientRepository.save(updatedClient);
            rabbitMQSender.send("Client updated.");
            log.trace("updatedClient: savedClient={}", savedClient);
            return savedClient;
        } else {
            rabbitMQSender.send("No Client found with the given ID.");
            throw new ResourceNotFoundException("No Client found with the given ID.");
        }
    }

    @Override
    public void deleteClientById(Long id) {
        log.trace("deleteClientById --- method entered");
        Optional<Client> result = clientRepository.findById(id);
        if (result.isPresent()) {
            clientRepository.deleteById(id);
            rabbitMQSender.send("Client deleted");
            log.trace("deleteClientById: result={}", result.get());
        } else {
            rabbitMQSender.send("Failed to delete Client.");
            log.error("deleteClient --- no Client found");
            throw new ResourceNotFoundException("No Client found.");
        }
    }
}
