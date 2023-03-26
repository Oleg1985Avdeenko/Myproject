package service.daoService;

import service.Service;
import service.dto.EngineDto;
import service.mapping.MappingEngine;
import service.MappingService;
import dao.impl.DaoEngineImpl;
import dao.DAO;
import entity.cars.Engine;

import java.util.List;
import java.util.stream.Collectors;

public class DaoEngineService implements Service<EngineDto> {
    private final DAO<Engine> engineDAO = new DaoEngineImpl();

    private final MappingService<Engine, EngineDto> mappingEngine = new MappingEngine();


    @Override
    public EngineDto save(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engine = engineDAO.save(engine);
        return mappingEngine.convertToDTO(engine);
    }

    @Override
    public void update(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engineDAO.update(engine);
    }

    @Override
    public void delete(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engineDAO.delete(engine);
    }

    @Override
    public EngineDto findById(EngineDto engineDto) {
        Engine engine = mappingEngine.convertToEntity(engineDto);
        engine = engineDAO.findById(engine);
        return mappingEngine.convertToDTO(engine);
    }

    @Override
    public List<EngineDto> findAll() {
        List<Engine> engines = engineDAO.findAll(Engine.builder().build());
        return engines.stream()
                .map(mappingEngine::convertToDTO)
                .collect(Collectors.toList());
    }
}
