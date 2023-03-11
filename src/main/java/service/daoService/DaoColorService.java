package service.daoService;

import entity.cars.Color;
import service.Service;
import service.dto.ColorDto;
import service.mapping.MappingColor;
import service.mapping.MappingService;
import dao.DaoColorImpl;
import dao.interfaces.DAO;


import java.util.List;
import java.util.stream.Collectors;

public class DaoColorService  implements Service<ColorDto> {

    private final DAO<Color> clientDAO = new DaoColorImpl();

    private final MappingService<Color, ColorDto> mappingColor = new MappingColor();


    @Override
    public ColorDto save(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        clientDAO.save(color);
        colorDto.setId(color.getId());
        return mappingColor.convertToDTO(color);
    }

    @Override
    public ColorDto update(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        clientDAO.update(color);
        return mappingColor.convertToDTO(color);
    }

    @Override
    public ColorDto findById(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        color = clientDAO.findById(color);
        return mappingColor.convertToDTO(color);
    }

    @Override
    public void delete(ColorDto colorDto) {
        clientDAO.findById(mappingColor.convertToEntity(colorDto));
    }

    @Override
    public List<ColorDto> findAll(ColorDto colorDto) {
        List<Color> colors = clientDAO.findAll(Color.builder().build());
        return colors.stream()
                .map(mappingColor::convertToDTO)
                .collect(Collectors.toList());
    }
}
