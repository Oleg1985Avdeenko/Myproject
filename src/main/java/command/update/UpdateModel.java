package command.update;

import command.Command;
import extractors.Extractor;
import extractors.ModelExtractor;
import service.Service;
import service.daoService.DaoModelService;
import service.dto.ModelDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateModel implements Command {
    private Service service = new DaoModelService();
    private Extractor<ModelDto> extractor = new ModelExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(MODEL_ID));
        if (GET.equals(req.getMethod())) {
            ModelDto modelDto = (ModelDto) service.findById(id);
            req.setAttribute(MODELS, modelDto);
            return JSP_UPDATE_MODEL;
        }
        ModelDto modelDto = extractor.extract(req);
        service.update(modelDto);
        return JSP_VIEW_MODEL;
    }
}
