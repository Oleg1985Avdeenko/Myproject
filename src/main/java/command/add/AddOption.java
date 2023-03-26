package command.add;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import extractors.OptionExtractor;
import service.Service;
import service.daoService.DaoModelOptionService;
import service.dto.CarDto;
import service.dto.OptionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddOption implements Command {

    private Service service = new DaoModelOptionService();

    private Extractor<OptionDto> extractor = new OptionExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_OPTION;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_OPTION;
    }
}
