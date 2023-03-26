package command.update;

import command.Command;
import extractors.ClientExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoClientService;
import service.dto.ClientDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateClient implements Command {
    private Service service = new DaoClientService();
    private Extractor<ClientDto> extractor = new ClientExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(CLIENT_ID));
        if (GET.equals(req.getMethod())) {
            ClientDto clientDto = (ClientDto) service.findById(id);
            req.setAttribute(CLIENTS, clientDto);
            return JSP_UPDATE_CLIENT;
        }
        ClientDto clientDto = extractor.extract(req);
        service.update(clientDto);
        return JSP_VIEW_CLIENT;
    }
}
