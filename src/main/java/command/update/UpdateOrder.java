package command.update;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import extractors.OrderExtractor;
import service.Service;
import service.daoService.DaoCarService;
import service.daoService.DaoOrderService;
import service.dto.CarDto;
import service.dto.OrderDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateOrder implements Command {
    private Service service = new DaoOrderService();
    private Extractor<OrderDto> extractor = new OrderExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(ORDER_ID));
        if (GET.equals(req.getMethod())) {
            OrderDto orderDto = (OrderDto) service.findById(id);
            req.setAttribute(ORDERS, orderDto);
            return JSP_UPDATE_ORDER;
        }
        OrderDto orderDto = extractor.extract(req);
        service.update(orderDto);
        return JSP_VIEW_ORDER;
    }
}
