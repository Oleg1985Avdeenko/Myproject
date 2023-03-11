package service.daoService;

import service.Service;
import service.dto.ClientDto;
import service.mapping.MappingClient;
import service.mapping.MappingService;
import dao.DaoClientImpl;
import dao.interfaces.DAO;
import entity.clients.Client;

import java.util.List;
import java.util.stream.Collectors;

public class DaoClientService  implements Service<ClientDto> {

    private final DAO<Client> clientDAO = new DaoClientImpl();

    private final MappingService<Client, ClientDto> mappingClient = new MappingClient();


    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = mappingClient.convertToEntity(clientDto);
        clientDAO.save(client);
        clientDto.setId(client.getId());
        return mappingClient.convertToDTO(client);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        Client client = mappingClient.convertToEntity(clientDto);
        clientDAO.update(client);
        return mappingClient.convertToDTO(client);
    }

    @Override
    public ClientDto findById(ClientDto clientDto) {
        Client client = mappingClient.convertToEntity(clientDto);
        client = clientDAO.findById(client);
        return mappingClient.convertToDTO(client);
    }

    @Override
    public void delete(ClientDto clientDto) {
        clientDAO.findById(mappingClient.convertToEntity(clientDto));
    }

    @Override
    public List<ClientDto> findAll(ClientDto clientDto) {
        List<Client> clients = clientDAO.findAll(Client.builder().build());
        return clients.stream()
                .map(mappingClient::convertToDTO)
                .collect(Collectors.toList());
    }
}
