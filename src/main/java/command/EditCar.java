package command;

import converter.ConverterCar;
import service.Service;
import service.daoService.DaoCarService;
import service.dto.CarDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.CARS;

public class EditCar implements Command{
    private static Service service = new DaoCarService();

    @Override
    public void execute(HttpServletRequest req) {
        CarDto carDto = ConverterCar.convertCar(req);
        service.update(carDto);
        req.setAttribute(CARS, service.findAll());

    }
}
