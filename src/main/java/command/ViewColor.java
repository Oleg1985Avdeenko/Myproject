package command;

import service.Service;
import service.daoService.DaoColorService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.COLORS;

public class ViewColor implements Command{
    private static Service service = new DaoColorService();

    @Override
    public void execute(HttpServletRequest req) {
        req.setAttribute(COLORS, service.findAll());
    }
}
