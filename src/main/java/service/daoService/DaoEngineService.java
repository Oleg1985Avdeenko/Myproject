package service.daoService;

import service.Service;
import service.dto.EngineDto;
import service.mapping.MappingEngine;
import service.mapping.MappingService;
import user.DaoEngineImpl;
import user.interfaces.DAO;
import entity.cars.Engine;

import java.util.List;
import java.util.stream.Collectors;

public class DaoEngineService implements Service<EngineDto> {
    private final DAO<Engine> engineDAO = new DaoEngineImpl();

    private final MappingService<Engine, EngineDto> mappingEngine = new MappingEngine();


    @Override
    public EngineDto save(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engineDAO.save(engine);
        engineDto.setId(engine.getId());
        return mappingEngine.convertToDTO(engine);
    }

    @Override
    public EngineDto update(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engineDAO.update(engine);
        return mappingEngine.convertToDTO(engine);
    }

    @Override
    public EngineDto findById(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engine = engineDAO.findById(engine);
        return mappingEngine.convertToDTO(engine);
    }

    @Override
    public void delete(EngineDto engineDto) {
        engineDAO.findById(mappingEngine.convertToEntity(engineDto));
    }

    @Override
    public List<EngineDto> findAll(EngineDto engineDto) {
        List<Engine> engines = engineDAO.findAll(Engine.builder().build());
        return engines.stream()
                .map(mappingEngine::convertToDTO)
                .collect(Collectors.toList());
    }
}
