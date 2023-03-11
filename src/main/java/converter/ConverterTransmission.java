package converter;

import service.dto.TransmissionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class ConverterTransmission {

    public static TransmissionDto convertTransmission(HttpServletRequest req) {
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
