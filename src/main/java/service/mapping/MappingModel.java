package service.mapping;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entity.cars.Model;
import service.dto.ModelDto;

public class MappingModel implements MappingService<Model, ModelDto> {
    @Override
    public Model convertToEntity(ModelDto dto) {
        Model model = new Model();
        model.setId(dto.getId());
        model.setModelName(dto.getModelName());
        model.setCarModel(dto.getCarModel());
        return model;
    }

    @Override
    public ModelDto convertToDTO(Model entity) {
        ModelDto modelDto = new ModelDto();
        modelDto.setId(entity.getId());
        modelDto.setModelName(entity.getModelName());
        modelDto.setCarModel(entity.getCarModel());
        return modelDto;
    }
}
