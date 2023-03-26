package command.add;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import extractors.OptionExtractor;
import extractors.OrderExtractor;
import service.Service;
import service.daoService.DaoOrderService;
import service.dto.CarDto;
import service.dto.OrderDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddOrder implements Command {

    private Service service = new DaoOrderService();

    private Extractor<OrderDto> extractor = new OrderExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_ORDER;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_ORDER;
    }
}
