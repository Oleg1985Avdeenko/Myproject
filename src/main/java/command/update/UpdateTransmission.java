package command.update;

import command.Command;
import extractors.CarExtractor;
import extractors.Extractor;
import extractors.TransmissionExtractor;
import service.Service;
import service.daoService.DaoCarService;
import service.daoService.DaoTransmissionService;
import service.dto.CarDto;
import service.dto.TransmissionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class UpdateTransmission implements Command {
    private Service service = new DaoTransmissionService();
    private Extractor<TransmissionDto> extractor = new TransmissionExtractor();

    @Override
    public String execute(final HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter(TRANSMISSION_ID));
        if (GET.equals(req.getMethod())) {
            TransmissionDto transmissionDto = (TransmissionDto) service.findById(id);
            req.setAttribute(TRANSMISSIONS, transmissionDto);
            return JSP_UPDATE_TRANSMISSION;
        }
        TransmissionDto transmissionDto = extractor.extract(req);
        service.update(transmissionDto);
        return JSP_VIEW_TRANSMISSION;
    }
}
