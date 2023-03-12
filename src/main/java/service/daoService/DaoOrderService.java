package service.daoService;

import service.Service;
import service.dto.OrderDto;
import service.mapping.MappingOrder;
import service.mapping.MappingService;
import dao.DaoClientOrderImpl;
import dao.interfaces.DAO;
import entity.clients.ClientOrder;

import java.util.List;
import java.util.stream.Collectors;

public class DaoOrderService implements Service<OrderDto> {
    private final DAO<ClientOrder> daoClientOrder = new DaoClientOrderImpl();

    private final MappingService<ClientOrder, OrderDto> mappingOrder = new MappingOrder();


    @Override
    public OrderDto save(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        daoClientOrder.save(clientOrder);
        orderDto.setId(clientOrder.getId());
        return mappingOrder.convertToDTO(clientOrder);
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        daoClientOrder.update(clientOrder);
        return mappingOrder.convertToDTO(clientOrder);
    }

    @Override
    public OrderDto findById(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        clientOrder = daoClientOrder.findById(clientOrder);
        return mappingOrder.convertToDTO(clientOrder);
    }

    @Override
    public void delete(OrderDto orderDto) {
        daoClientOrder.findById(mappingOrder.convertToEntity(orderDto));
    }

    @Override
    public List<OrderDto> findAll() {
        List<ClientOrder> orders = daoClientOrder.findAll(ClientOrder.builder().build());
        return orders.stream()
                .map(mappingOrder::convertToDTO)
                .collect(Collectors.toList());
    }
}
