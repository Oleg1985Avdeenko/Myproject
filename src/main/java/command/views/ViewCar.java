package command.views;

import command.Command;
import service.Service;
import service.daoService.DaoCarService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.CARS;
import static utils.Util.JSP_VIEW_CAR;

public class ViewCar implements Command {
    private Service service = new DaoCarService();


    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(CARS, service.findAll());
        return JSP_VIEW_CAR;
    }
}
