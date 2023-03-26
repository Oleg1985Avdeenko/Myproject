package command.add;

import command.Command;
import extractors.ClientExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoClientService;
import service.dto.ClientDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddClient implements Command {

    private Service service = new DaoClientService();
    private Extractor<ClientDto> extractor = new ClientExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_CLIENT;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_CLIENT;
    }
}
