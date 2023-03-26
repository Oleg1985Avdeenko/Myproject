package extractors;

import service.dto.TransmissionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.TRANSMISSION_ID;
import static utils.Util.TRANSMISSION_TYPE;

public class TransmissionExtractor implements Extractor<TransmissionDto> {

    @Override
    public TransmissionDto extract(HttpServletRequest req) {
        String id = req.getParameter(TRANSMISSION_ID);
        String transmissionType = req.getParameter(TRANSMISSION_TYPE);
        TransmissionDto transmissionDto = TransmissionDto.builder()
                .type(transmissionType)
                .build();
        if (id != null) {
            transmissionDto.setId(Integer.parseInt(id));
        }
        if (transmissionType != null) {
            transmissionDto.setType(transmissionType);
        }
        return transmissionDto;
    }
}
