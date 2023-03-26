package command.add;

import command.Command;
import extractors.ColorExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoColorService;
import service.dto.ColorDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddColor implements Command {

    private Service service = new DaoColorService();
    private Extractor<ColorDto> extractor = new ColorExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_COLOR;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_COLOR;
    }
}
