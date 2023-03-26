package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoClientService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.CLIENT_ID;
import static utils.Util.JSP_VIEW_CLIENT;

public class DeleteClient implements Command {

    private Service service = new DaoClientService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(CLIENT_ID)));
        return JSP_VIEW_CLIENT;
    }
}
