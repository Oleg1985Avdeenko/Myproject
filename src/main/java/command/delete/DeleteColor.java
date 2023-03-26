package command.delete;

import command.Command;
import service.Service;
import service.daoService.DaoCarService;
import service.daoService.DaoColorService;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class DeleteColor implements Command {

    private Service service = new DaoColorService();

    @Override
    public String execute(final HttpServletRequest request) {
        service.delete(Integer.parseInt(request.getParameter(COLOR_ID)));
        return JSP_VIEW_COLOR;
    }
}
