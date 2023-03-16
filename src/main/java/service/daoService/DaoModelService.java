package service.daoService;


import service.Service;
import service.dto.ModelDto;
import service.mapping.MappingModel;
import service.mapping.MappingService;
import dao.DaoModelImpl;
import dao.interfaces.DAO;
import entity.cars.Model;

import java.util.List;
import java.util.stream.Collectors;

public class DaoModelService implements Service<ModelDto> {
    private final DAO<Model> modelDAO = new DaoModelImpl();

    private final MappingService<Model, ModelDto> mappingModel = new MappingModel();


    @Override
    public ModelDto save(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        model = modelDAO.save(model);
        return mappingModel.convertToDTO(model);
    }

    @Override
    public void update(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        modelDAO.update(model);
    }

    @Override
    public void delete(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        modelDAO.delete(model);
    }

    @Override
    public ModelDto findById(ModelDto modelDto) {
        Model model = mappingModel.convertToEntity(modelDto);
        model = modelDAO.findById(model);
        return mappingModel.convertToDTO(model);
    }

    @Override
    public List<ModelDto> findAll() {
        List<Model> models = modelDAO.findAll(Model.builder().build());
        return models.stream()
                .map(mappingModel::convertToDTO)
                .collect(Collectors.toList());
    }
}
