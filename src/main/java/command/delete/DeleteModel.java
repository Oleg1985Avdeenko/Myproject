package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoModelService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.JSP_VIEW_MODEL;
import static utils.Util.MODEL_ID;

public class DeleteModel implements Command {

    private Service service = new DaoModelService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(MODEL_ID)));
        return JSP_VIEW_MODEL;
    }
}
