package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoModelOptionService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.JSP_VIEW_OPTION;
import static utils.Util.OPTION_ID;

public class DeleteOption implements Command {

    private Service service = new DaoModelOptionService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(OPTION_ID)));
        return JSP_VIEW_OPTION;
    }
}
