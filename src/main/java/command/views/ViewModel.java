package command.views;

import command.Command;
import service.Service;
import service.daoService.DaoModelService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.JSP_VIEW_MODEL;
import static utils.Util.MODELS;

public class ViewModel implements Command {
    private static Service service = new DaoModelService();

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(MODELS, service.findAll());
        return JSP_VIEW_MODEL;
    }
}
