package command.add;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;

import service.Service;
import service.daoService.DaoCarService;
import service.dto.CarDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddCar implements Command {

    private Service service = new DaoCarService();
    private Extractor<CarDto> extractor = new CarExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_CAR;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_CAR;
    }
}
