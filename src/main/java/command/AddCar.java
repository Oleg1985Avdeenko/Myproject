package command;

import converter.ConverterCar;
import service.Service;
import service.daoService.DaoCarService;
import service.dto.CarDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static utils.Util.CARS;

public class AddCar implements Command{

    private static Service service = new DaoCarService();

    @Override
    public void execute(HttpServletRequest req) {
        CarDto carDto = ConverterCar.convertCar(req);
        service.save(carDto);
        List<CarDto> list = service.findAll();
        req.setAttribute(CARS, list);
    }
}
