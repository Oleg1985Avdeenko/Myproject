package service.daoService;

import service.Service;
import service.dto.OptionDto;
import service.mapping.MappingOption;
import service.MappingService;
import dao.impl.DaoModelOptionImpl;
import dao.DAO;
import entity.cars.ModelOption;

import java.util.List;
import java.util.stream.Collectors;

public class DaoModelOptionService implements Service<OptionDto> {
    private final DAO<ModelOption> optionDAO = new DaoModelOptionImpl();

    private final MappingService<ModelOption, OptionDto> mappingOption = new MappingOption();


    @Override
    public OptionDto save(OptionDto optionDto) {
        ModelOption modelOpnion = mappingOption.convertToEntity(optionDto);
        modelOpnion = optionDAO.save(modelOpnion);
        return mappingOption.convertToDTO(modelOpnion);
    }

    @Override
    public void update(OptionDto optionDto) {
        ModelOption modelOpnion = mappingOption.convertToEntity(optionDto);
        optionDAO.update(modelOpnion);
    }

    @Override
    public void delete(OptionDto optionDto) {
        ModelOption modelOpnion = mappingOption.convertToEntity(optionDto);
        optionDAO.delete(modelOpnion);
    }

    @Override
    public OptionDto findById(OptionDto optionDto) {
        ModelOption modelOpnion = mappingOption.convertToEntity(optionDto);
        modelOpnion = optionDAO.findById(modelOpnion);
        return mappingOption.convertToDTO(modelOpnion);
    }

    @Override
    public List<OptionDto> findAll() {
        List<ModelOption> modelOptions = optionDAO.findAll(ModelOption.builder().build());
        return modelOptions.stream()
                .map(mappingOption::convertToDTO)
                .collect(Collectors.toList());
    }
}
