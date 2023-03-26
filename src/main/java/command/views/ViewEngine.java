package command.views;

import command.Command;
import service.Service;
import service.daoService.DaoColorService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.ENGINES;
import static utils.Util.JSP_VIEW_ENGINE;

public class ViewEngine implements Command {
    private static Service service = new DaoColorService();

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(ENGINES, service.findAll());
        return JSP_VIEW_ENGINE;
    }
}