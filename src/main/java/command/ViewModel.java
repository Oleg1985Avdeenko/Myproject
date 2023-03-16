package command;

import service.Service;
import service.daoService.DaoModelService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.MODELS;

public class ViewModel implements Command{
    private static Service service = new DaoModelService();

    @Override
    public void execute(HttpServletRequest req) {
        req.setAttribute(MODELS, service.findAll());
    }
}
