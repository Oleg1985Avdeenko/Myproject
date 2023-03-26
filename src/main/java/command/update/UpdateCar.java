package command.update;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import service.Service;
import service.daoService.DaoCarService;
import service.dto.CarDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateCar implements Command {
    private Service service = new DaoCarService();
    private Extractor<CarDto> extractor = new CarExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(CAR_ID));
        if (GET.equals(req.getMethod())) {
            CarDto carDto = (CarDto) service.findById(id);
            req.setAttribute(CARS, carDto);
            return JSP_UPDATE_CAR;
        }
        CarDto carDto = extractor.extract(req);
        service.update(carDto);
        return JSP_VIEW_CAR;
    }
}


