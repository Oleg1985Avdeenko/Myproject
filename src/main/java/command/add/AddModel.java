package command.add;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import extractors.ModelExtractor;
import service.Service;
import service.daoService.DaoModelService;
import service.dto.CarDto;
import service.dto.ModelDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddModel implements Command {

    private Service service = new DaoModelService();

    private Extractor<ModelDto> extractor = new ModelExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_MODEL;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_MODEL;
    }
}
