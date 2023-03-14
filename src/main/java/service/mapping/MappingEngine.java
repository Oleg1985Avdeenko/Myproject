package service.mapping;

import entity.cars.Engine;
import service.dto.EngineDto;

public class MappingEngine implements MappingService<Engine, EngineDto> {
    @Override
    public Engine convertToEntity(EngineDto dto) {
        Engine engine = new Engine();
        engine.setId(dto.getId());
        engine.setVolume(dto.getVolume());
        engine.setType(dto.getType());
        engine.setSelectedEngines(dto.getSelectedEngines());
        return engine;
    }

    @Override
    public EngineDto convertToDTO(Engine entity) {
        EngineDto engineDto = new EngineDto();
        engineDto.setId(entity.getId());
        engineDto.setVolume(entity.getVolume());
        engineDto.setType(entity.getType());
        engineDto.setSelectedEngines(entity.getSelectedEngines());
        return engineDto;
    }
}
