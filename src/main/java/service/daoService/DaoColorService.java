package service.daoService;

import entity.cars.Color;
import service.Service;
import service.dto.ColorDto;
import service.mapping.MappingColor;
import service.MappingService;
import dao.impl.DaoColorImpl;
import dao.DAO;


import java.util.List;
import java.util.stream.Collectors;

public class DaoColorService  implements Service<ColorDto> {

    private final DAO<Color> colorDAO = new DaoColorImpl();

    private final MappingService<Color, ColorDto> mappingColor = new MappingColor();


    @Override
    public ColorDto save(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        color = colorDAO.save(color);
        return mappingColor.convertToDTO(color);
    }

    @Override
    public void update(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        colorDAO.update(color);
    }

    @Override
    public void delete(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        colorDAO.delete(color);
    }

    @Override
    public ColorDto findById(ColorDto colorDto) {
        Color color = mappingColor.convertToEntity(colorDto);
        color = colorDAO.findById(color);
        return mappingColor.convertToDTO(color);
    }

    @Override
    public List<ColorDto> findAll() {
        List<Color> colors = colorDAO.findAll(Color.builder().build());
        return colors.stream()
                .map(mappingColor::convertToDTO)
                .collect(Collectors.toList());
    }
}
