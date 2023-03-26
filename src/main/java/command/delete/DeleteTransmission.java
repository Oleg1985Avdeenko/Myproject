package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoTransmissionService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.JSP_VIEW_TRANSMISSION;
import static utils.Util.TRANSMISSION_ID;

public class DeleteTransmission implements Command {

    private Service service = new DaoTransmissionService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(TRANSMISSION_ID)));
        return JSP_VIEW_TRANSMISSION;
    }
}
