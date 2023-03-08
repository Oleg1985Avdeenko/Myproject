package service.mapping;

import entity.clients.Client;
import service.dto.ClientDto;

public class MappingClient implements MappingService<Client, ClientDto> {

    @Override
    public Client convertToEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setLogin(dto.getLogin());
        client.setPassword(dto.getPassword());
        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.setCellPhone(dto.getCellPhone());
        client.setEmail(dto.getEmail());
        client.setOrders(dto.getDtoOrders());
        return client;
    }

    @Override
    public ClientDto convertToDTO(Client entity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(entity.getId());
        clientDto.setLogin(entity.getLogin());
        clientDto.setPassword(entity.getPassword());
        clientDto.setName(entity.getName());
        clientDto.setSurname(entity.getSurname());
        clientDto.setCellPhone(entity.getCellPhone());
        clientDto.setEmail(entity.getEmail());
        clientDto.setDtoOrders(entity.getOrders());
        return null;
    }
}
