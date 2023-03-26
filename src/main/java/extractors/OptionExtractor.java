package extractors;

import service.dto.OptionDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class OptionExtractor implements Extractor<OptionDto> {

    @Override
    public  OptionDto extract(HttpServletRequest req) {
        String id = req.getParameter(OPTION_ID);
        String salon = req.getParameter(SALON);
        String heatedSeat = req.getParameter(HEATED_SEAT);
        String cruiseControl = req.getParameter(CRUISE_CONTROL);
        String wheelControl = req.getParameter(WHEEL_CONTROL);
        String fogLight = req.getParameter(FOG_LIGHT);
        String transmissionType = req.getParameter(TRANSMISSION_TYPE);
        OptionDto optionDto = OptionDto.builder()
                .salon(salon)
                .heatedSeat(Boolean.valueOf(heatedSeat))
                .cruiseControl(Boolean.valueOf(cruiseControl))
                .steeringWheelControl(Boolean.valueOf(wheelControl))
                .fogLight(Boolean.valueOf(fogLight))
                .build();
        if (id != null) {
            optionDto.setId(Integer.parseInt(id));
        }
        if (salon != null) {
            optionDto.setSalon(salon);
        }
        if (heatedSeat != null) {
            optionDto.setHeatedSeat(Boolean.valueOf(heatedSeat));
        }
        if (cruiseControl != null) {
            optionDto.setCruiseControl(Boolean.valueOf(cruiseControl));
        }
        if (wheelControl != null) {
            optionDto.setSteeringWheelControl(Boolean.valueOf(wheelControl));
        }
        if (fogLight != null) {
            optionDto.setFogLight(Boolean.valueOf(fogLight));
        }
        return optionDto;
    }
}
