package command.add;

import command.Command;
import extractors.EngineExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoEngineService;
import service.dto.EngineDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddEngine implements Command {

    private Service service = new DaoEngineService();
    private Extractor<EngineDto> extractor = new EngineExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_ENGINE;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_ENGINE;
    }
}
