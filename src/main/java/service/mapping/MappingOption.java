package service.mapping;

import entity.cars.ModelOpnion;
import service.dto.OptionDto;

public class MappingOption implements MappingService<ModelOpnion, OptionDto> {
    @Override
    public ModelOpnion convertToEntity(OptionDto dto) {
        ModelOpnion modelOpnion = new ModelOpnion();
        modelOpnion.setId(dto.getId());
        modelOpnion.setSalon(dto.getSalon());
        modelOpnion.setHeatedSeat(dto.getHeatedSeat());
        modelOpnion.setSteeringWheelControl(dto.getSteeringWheelControl());
        modelOpnion.setCruiseControl(dto.getCruiseControl());
        modelOpnion.setFogLight(dto.getFogLight());
        modelOpnion.setCarOption(dto.getCarOption());
        return modelOpnion;
    }

    @Override
    public OptionDto convertToDTO(ModelOpnion entity) {
        OptionDto optionDto = new OptionDto();
        optionDto.setId(entity.getId());
        optionDto.setSalon(entity.getSalon());
        optionDto.setHeatedSeat(entity.getHeatedSeat());
        optionDto.setSteeringWheelControl(entity.getSteeringWheelControl());
        optionDto.setCruiseControl(entity.getCruiseControl());
        optionDto.setFogLight(entity.getFogLight());
        optionDto.setCarOption(entity.getCarOption());
        return optionDto;
    }
}
