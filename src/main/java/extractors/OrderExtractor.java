package extractors;

import service.dto.OrderDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.ORDER_ID;

public class OrderExtractor implements Extractor<OrderDto> {

    @Override
    public OrderDto extract(HttpServletRequest req) {
        String id = req.getParameter(ORDER_ID);
        OrderDto orderDto = OrderDto.builder()
                .build();
        if (id != null) {
            orderDto.setId(Integer.parseInt(id));
        }
        return orderDto;
    }
}
