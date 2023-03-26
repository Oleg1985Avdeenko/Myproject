package command.views;

import command.Command;
import service.Service;
import service.daoService.DaoColorService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.CLIENTS;
import static utils.Util.JSP_VIEW_CLIENT;

public class ViewClient implements Command {
    private static Service service = new DaoColorService();

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(CLIENTS, service.findAll());
        return JSP_VIEW_CLIENT;
    }
}
