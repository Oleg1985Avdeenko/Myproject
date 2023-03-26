package command.views;

import command.Command;
import service.Service;
import service.daoService.DaoColorService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class ViewOption implements Command {
    private static Service service = new DaoColorService();

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(OPTIONS, service.findAll());
        return JSP_VIEW_OPTION;
    }
}
