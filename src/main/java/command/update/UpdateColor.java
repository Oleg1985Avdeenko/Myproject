package command.update;

import command.Command;
import extractors.ColorExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoColorService;
import service.dto.ColorDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateColor implements Command {
    private Service service = new DaoColorService();
    private Extractor<ColorDto> extractor = new ColorExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(COLOR_ID));
        if (GET.equals(req.getMethod())) {
            ColorDto colorDto = (ColorDto) service.findById(id);
            req.setAttribute(COLORS, colorDto);
            return JSP_UPDATE_COLOR;
        }
        ColorDto colorDto = extractor.extract(req);
        service.update(colorDto);
        return JSP_VIEW_COLOR;
    }
}
