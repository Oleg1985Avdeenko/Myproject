package command;

import converter.ConverterColor;
import service.Service;
import service.daoService.DaoColorService;
import service.dto.ColorDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static utils.Util.COLORS;

public class AddColor implements Command{

    private static Service service = new DaoColorService();

    @Override
    public void execute(HttpServletRequest req) {
        ColorDto colorDto = ConverterColor.convertColor(req);
        service.save(colorDto);
        List<ColorDto> list = service.findAll();
        req.setAttribute(COLORS, list);
    }
}
