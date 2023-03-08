package service.mapping;

public interface MappingService<T, V>{
    T convertToEntity(V dto);

    V convertToDTO(T entity);
}
