package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoEngineService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.ENGINE_ID;
import static utils.Util.JSP_VIEW_ENGINE;

public class DeleteEngine implements Command {

    private Service service = new DaoEngineService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(ENGINE_ID)));
        return JSP_VIEW_ENGINE;
    }
}
