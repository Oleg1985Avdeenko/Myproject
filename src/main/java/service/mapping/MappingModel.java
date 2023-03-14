package service.mapping;

import entity.cars.Model;
import service.dto.ModelDto;

public class MappingModel implements MappingService<Model, ModelDto> {
    @Override
    public Model convertToEntity(ModelDto dto) {
        Model model = new Model();
        model.setId(dto.getId());
        model.setModelName(dto.getModelName());
        model.setSelectedModels(dto.getSelectedModels());
        return model;
    }

    @Override
    public ModelDto convertToDTO(Model entity) {
        ModelDto modelDto = new ModelDto();
        modelDto.setId(entity.getId());
        modelDto.setModelName(entity.getModelName());
        modelDto.setSelectedModels(entity.getSelectedModels());
        return modelDto;
    }
}
