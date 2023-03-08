package service.daoService;

import service.Service;
import service.dto.OptionDto;
import service.mapping.MappingOption;
import service.mapping.MappingService;
import user.DaoModelOptionImpl;
import user.interfaces.DAO;
import entity.cars.ModelOpnion;

import java.util.List;
import java.util.stream.Collectors;

public class DaoModelOptionService implements Service<OptionDto> {
    private final DAO<ModelOpnion> opnionDAO = new DaoModelOptionImpl();

    private final MappingService<ModelOpnion, OptionDto> mappingOption = new MappingOption();


    @Override
    public OptionDto save(OptionDto optionDto) {
        ModelOpnion modelOpnion = mappingOption.convertToEntity(optionDto);
        opnionDAO.save(modelOpnion);
        optionDto.setId(modelOpnion.getId());
        return mappingOption.convertToDTO(modelOpnion);
    }

    @Override
    public OptionDto update(OptionDto optionDto) {
        ModelOpnion modelOpnion = mappingOption.convertToEntity(optionDto);
        opnionDAO.update(modelOpnion);
        return mappingOption.convertToDTO(modelOpnion);
    }

    @Override
    public OptionDto findById(OptionDto optionDto) {
        ModelOpnion modelOpnion = mappingOption.convertToEntity(optionDto);
        modelOpnion = opnionDAO.findById(modelOpnion);
        return mappingOption.convertToDTO(modelOpnion);
    }

    @Override
    public void delete(OptionDto optionDto) {
        opnionDAO.findById(mappingOption.convertToEntity(optionDto));
    }

    @Override
    public List<OptionDto> findAll(OptionDto optionDto) {
        List<ModelOpnion> modelOpnions = opnionDAO.findAll(ModelOpnion.builder().build());
        return modelOpnions.stream()
                .map(mappingOption::convertToDTO)
                .collect(Collectors.toList());
    }
}
