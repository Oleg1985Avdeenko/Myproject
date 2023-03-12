package command;

import service.Service;
import service.daoService.DaoCarService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.CARS;

public class ViewCar implements Command{
    private static Service service = new DaoCarService();

    @Override
    public void execute(HttpServletRequest req) {
        req.setAttribute(CARS, service.findAll());
    }
}
