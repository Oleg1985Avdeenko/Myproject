package service.mapping;

import entity.clients.ClientOrder;
import service.dto.OrderDto;

public class MappingOrder implements MappingService<ClientOrder, OrderDto> {
    @Override
    public ClientOrder convertToEntity(OrderDto dto) {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setId(dto.getId());
        clientOrder.setSelectedCars(dto.getDtoSelectedCars());
        clientOrder.setClient(dto.getClientDto());
        return clientOrder;
    }

    @Override
    public OrderDto convertToDTO(ClientOrder entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setDtoSelectedCars(entity.getSelectedCars());
        orderDto.setClientDto(entity.getClient());
        return orderDto;
    }
}
