package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoOrderService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.JSP_VIEW_ORDER;
import static utils.Util.ORDER_ID;

public class DeleteOrder implements Command {

    private Service service = new DaoOrderService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(ORDER_ID)));
        return JSP_VIEW_ORDER;
    }
}
