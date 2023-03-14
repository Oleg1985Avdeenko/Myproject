package service.mapping;

import entity.cars.Color;
import service.dto.ColorDto;

public class MappingColor implements MappingService<Color, ColorDto> {
    @Override
    public Color convertToEntity(ColorDto dto) {
        Color color = new Color();
        color.setId(dto.getId());
        color.setColorName(dto.getColorName());
        color.setSelectedColors(dto.getSelectedColors());
        return color;
    }

    @Override
    public ColorDto convertToDTO(Color entity) {
        ColorDto colorDto = new ColorDto();
        colorDto.setId(entity.getId());
        colorDto.setColorName(entity.getColorName());
        colorDto.setSelectedColors(entity.getSelectedColors());
        return colorDto;
    }
}
