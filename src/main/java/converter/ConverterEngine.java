package converter;

import service.dto.EngineDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class ConverterEngine {

    public static EngineDto convertEngine(HttpServletRequest req) {
        String id = req.getParameter(ENGINE_ID);
        String engineVolume = req.getParameter(ENGINE_VOLUME);
        String engineType = req.getParameter(ENGINE_TYPE);
        EngineDto engineDto = EngineDto.builder()
                .volume(Double.valueOf(engineVolume))
                .type(engineType)
                .build();
        if (id != null) {
            engineDto.setId(Integer.parseInt(id));
        }
        if (engineVolume != null) {
            engineDto.setVolume(Double.valueOf(engineVolume));
        }
        if (engineType != null) {
            engineDto.setType(engineType);
        }
        return engineDto;
    }
}
