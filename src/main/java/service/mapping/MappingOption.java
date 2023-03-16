package service.mapping;

import entity.cars.ModelOption;
import service.dto.OptionDto;

public class MappingOption implements MappingService<ModelOption, OptionDto> {
    @Override
    public ModelOption convertToEntity(OptionDto dto) {
        ModelOption modelOpnion = new ModelOption();
        modelOpnion.setId(dto.getId());
        modelOpnion.setSalon(dto.getSalon());
        modelOpnion.setHeatedSeat(dto.getHeatedSeat());
        modelOpnion.setSteeringWheelControl(dto.getSteeringWheelControl());
        modelOpnion.setCruiseControl(dto.getCruiseControl());
        modelOpnion.setFogLight(dto.getFogLight());
        modelOpnion.setSelectedOptions(dto.getSelectedOptions());
        return modelOpnion;
    }

    @Override
    public OptionDto convertToDTO(ModelOption entity) {
        OptionDto optionDto = new OptionDto();
        optionDto.setId(entity.getId());
        optionDto.setSalon(entity.getSalon());
        optionDto.setHeatedSeat(entity.getHeatedSeat());
        optionDto.setSteeringWheelControl(entity.getSteeringWheelControl());
        optionDto.setCruiseControl(entity.getCruiseControl());
        optionDto.setFogLight(entity.getFogLight());
        optionDto.setSelectedOptions(entity.getSelectedOptions());
        return optionDto;
    }
}
