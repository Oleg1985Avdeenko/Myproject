package command.views;

import command.Command;
import service.Service;
import service.daoService.DaoColorService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.JSP_VIEW_ORDER;
import static utils.Util.ORDERS;

public class ViewOrder implements Command {
    private static Service service = new DaoColorService();

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(ORDERS, service.findAll());
        return JSP_VIEW_ORDER;
    }
}
