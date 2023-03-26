package command.update;

import command.Command;
import extractors.Extractor;
import extractors.OptionExtractor;
import service.Service;
import service.daoService.DaoModelOptionService;
import service.dto.OptionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateOption implements Command {
    private Service service = new DaoModelOptionService();
    private Extractor<OptionDto> extractor = new OptionExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(OPTION_ID));
        if (GET.equals(req.getMethod())) {
            OptionDto optionDto = (OptionDto) service.findById(id);
            req.setAttribute(OPTIONS, optionDto);
            return JSP_UPDATE_OPTION;
        }
        OptionDto optionDto = extractor.extract(req);
        service.update(optionDto);
        return JSP_VIEW_OPTION;
    }
}
