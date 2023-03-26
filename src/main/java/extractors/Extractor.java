package extractors;

import service.dto.CarDto;

import javax.servlet.http.HttpServletRequest;

public interface Extractor<T> {

     T extract(HttpServletRequest req);
}
