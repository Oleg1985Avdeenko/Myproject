package service.mapping;

import entity.cars.Car;
import service.dto.CarDto;

public class MappingCar implements MappingService<Car, CarDto> {
    @Override
    public Car convertToEntity(CarDto dto) {
        Car car =new Car();
        car.setId(dto.getId());
        car.setPrice(dto.getPrice());
        car.setAvailability(dto.getAvailability());
        car.setSelectedCar(dto.getDtoSelectedCar());
        car.setSelectedModels(dto.getSelectedModels());
        car.setSelectedColors(dto.getSelectedColors());
        car.setSelectedEngines(dto.getSelectedEngines());
        car.setSelectedOptions(dto.getSelectedOptions());
        car.setSelectedTransmissions(dto.getSelectedTransmissions());
        return car;
    }

    @Override
    public CarDto convertToDTO(Car entity) {
        CarDto carDto =new CarDto();
        carDto.setId(entity.getId());
        carDto.setPrice(entity.getPrice());
        carDto.setAvailability(entity.getAvailability());
        carDto.setDtoSelectedCar(entity.getSelectedCar());
        carDto.setSelectedModels(entity.getSelectedModels());
        carDto.setSelectedColors(entity.getSelectedColors());
        carDto.setSelectedEngines(entity.getSelectedEngines());
        carDto.setSelectedOptions(entity.getSelectedOptions());
        carDto.setSelectedTransmissions(entity.getSelectedTransmissions());
        return carDto;
    }
}
