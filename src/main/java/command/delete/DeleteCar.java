package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoCarService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.CAR_ID;
import static utils.Util.JSP_VIEW_CAR;


public class DeleteCar implements Command {

    private Service service = new DaoCarService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(CAR_ID)));
        return JSP_VIEW_CAR;
    }
}
