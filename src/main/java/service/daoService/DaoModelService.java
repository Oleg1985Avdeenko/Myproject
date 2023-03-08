package service.daoService;


import service.Service;
import service.dto.ModelDto;
import service.mapping.MappingModel;
import service.mapping.MappingService;
import user.DaoModelImpl;
import user.interfaces.DAO;
import entity.cars.Model;

import java.util.List;
import java.util.stream.Collectors;

public class DaoModelService implements Service<ModelDto> {
    private final DAO<Model> clientDAO = new DaoModelImpl();

    private final MappingService<Model, ModelDto> mappingModel = new MappingModel();


    @Override
    public ModelDto save(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        clientDAO.save(model);
        modelDto.setId(model.getId());
        return mappingModel.convertToDTO(model);
    }

    @Override
    public ModelDto update(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        clientDAO.update(model);
        return mappingModel.convertToDTO(model);
    }

    @Override
    public ModelDto findById(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        model = clientDAO.findById(model);
        return mappingModel.convertToDTO(model);
    }

    @Override
    public void delete(ModelDto modelDto) {
        clientDAO.findById(mappingModel.convertToEntity(modelDto));
    }

    @Override
    public List<ModelDto> findAll(ModelDto modelDto) {
        List<Model> models = clientDAO.findAll(Model.builder().build());
        return models.stream()
                .map(mappingModel::convertToDTO)
                .collect(Collectors.toList());
    }
}
