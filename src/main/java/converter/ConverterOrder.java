package converter;

import service.dto.CarDto;
import service.dto.OrderDto;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static utils.Util.*;

public class ConverterOrder {

    public static OrderDto convertOrder(HttpServletRequest req) {
        String id = req.getParameter(ORDER_ID);
        OrderDto orderDto = OrderDto.builder()
                .build();
        if (id != null) {
            orderDto.setId(Integer.parseInt(id));
        }
        return orderDto;
    }
}
