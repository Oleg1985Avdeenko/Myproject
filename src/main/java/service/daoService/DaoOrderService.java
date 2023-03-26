package service.daoService;

import service.Service;
import service.dto.OrderDto;
import service.mapping.MappingOrder;
import service.MappingService;
import dao.impl.DaoClientOrderImpl;
import dao.DAO;
import entity.clients.ClientOrder;

import java.util.List;
import java.util.stream.Collectors;

public class DaoOrderService implements Service<OrderDto> {
    private final DAO<ClientOrder> clientOrderDAO = new DaoClientOrderImpl();

    private final MappingService<ClientOrder, OrderDto> mappingOrder = new MappingOrder();


    @Override
    public OrderDto save(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        clientOrder = clientOrderDAO.save(clientOrder);
        return mappingOrder.convertToDTO(clientOrder);
    }

    @Override
    public void update(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        clientOrderDAO.update(clientOrder);
    }

    @Override
    public void delete(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        clientOrderDAO.delete(clientOrder);
    }

    @Override
    public OrderDto findById(OrderDto orderDto) {
        ClientOrder clientOrder = mappingOrder.convertToEntity(orderDto);
        clientOrder = clientOrderDAO.findById(clientOrder);
        return mappingOrder.convertToDTO(clientOrder);
    }

    @Override
    public List<OrderDto> findAll() {
        List<ClientOrder> orders = clientOrderDAO.findAll(ClientOrder.builder().build());
        return orders.stream()
                .map(mappingOrder::convertToDTO)
                .collect(Collectors.toList());
    }
}
