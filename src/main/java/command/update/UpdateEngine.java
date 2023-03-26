package command.update;

import command.Command;
import extractors.EngineExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoEngineService;
import service.dto.EngineDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateEngine implements Command {
    private Service service = new DaoEngineService();
    private Extractor<EngineDto> extractor = new EngineExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(ENGINE_ID));
        if (GET.equals(req.getMethod())) {
            EngineDto engineDto = (EngineDto) service.findById(id);
            req.setAttribute(ENGINES, engineDto);
            return JSP_UPDATE_ENGINE;
        }
        EngineDto engineDto = extractor.extract(req);
        service.update(engineDto);
        return JSP_VIEW_ENGINE;
    }
}
