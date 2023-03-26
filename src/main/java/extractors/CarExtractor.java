package extractors;

import service.dto.CarDto;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;

import static utils.Util.*;

public class CarExtractor implements Extractor<CarDto> {

    @Override
    public  CarDto extract(HttpServletRequest req) {
        String id = req.getParameter(CAR_ID);
        String price = req.getParameter(PRICE);
        String availability = req.getParameter(AVAILABILITY);
        CarDto carDto = CarDto.builder()
                .price(new BigDecimal(price))
                .availability(Boolean.valueOf(availability))
                .build();
        if (id != null) {
            carDto.setId(Integer.parseInt(id));
        }
        if (price != null) {
            carDto.setPrice(new BigDecimal(price));
        }
        if (availability != null) {
            carDto.setAvailability(Boolean.valueOf(availability));
        }
        return carDto;
    }
}
