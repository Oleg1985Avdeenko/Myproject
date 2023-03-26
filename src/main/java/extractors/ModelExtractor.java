package extractors;

import service.dto.ModelDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.MODEL;
import static utils.Util.MODEL_ID;

public class ModelExtractor implements Extractor<ModelDto> {

    @Override
    public ModelDto extract(HttpServletRequest req) {
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
