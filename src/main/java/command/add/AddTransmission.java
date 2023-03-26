package command.add;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import extractors.TransmissionExtractor;
import service.Service;
import service.daoService.DaoTransmissionService;
import service.dto.CarDto;
import service.dto.TransmissionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class AddTransmission implements Command {

    private Service service = new DaoTransmissionService();

    private Extractor<TransmissionDto> extractor = new TransmissionExtractor();

    @Override
    public String execute(HttpServletRequest req) {
        if (GET.equals(req.getMethod())) {
            return JSP_ADD_TRANSMISSION;
        }
        service.save(extractor.extract(req));
        return JSP_VIEW_TRANSMISSION;
    }
}
