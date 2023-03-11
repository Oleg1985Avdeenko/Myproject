package converter;

import service.dto.ModelDto;

import javax.servlet.http.HttpServletRequest;


import static utils.Util.*;

public class ConverterModel {

    public static ModelDto convertModel(HttpServletRequest req) {
        String id = req.getParameter(MODEL_ID);
        String model = req.getParameter(MODEL);
        ModelDto modelDto = ModelDto.builder()
                .modelName(model)
                .build();
        if (id != null) {
            modelDto.setId(Integer.parseInt(id));
        }
        if (model != null) {
            modelDto.setModelName(model);
        }
        return modelDto;
    }
}
