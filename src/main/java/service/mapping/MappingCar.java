package service.mapping;

import entity.cars.Car;
import service.MappingService;
import service.dto.CarDto;

public class MappingCar implements MappingService<Car, CarDto> {
    @Override
    public Car convertToEntity(CarDto dto) {
        Car car =new Car();
        car.setId(dto.getId());
        car.setPrice(dto.getPrice());
        car.setAvailability(dto.getAvailability());
        car.setSelectedCar(dto.getDtoSelectedCar());
        car.setCarModel(dto.getCarModel());
        car.setCarColor(dto.getCarColor());
        car.setCarEngine(dto.getCarEngine());
        car.setCarOption(dto.getCarOption());
        car.setCarTransmission(dto.getCarTransmission());
        return car;
    }

    @Override
    public CarDto convertToDTO(Car entity) {
        CarDto carDto =new CarDto();
        carDto.setId(entity.getId());
        carDto.setPrice(entity.getPrice());
        carDto.setAvailability(entity.getAvailability());
        carDto.setDtoSelectedCar(entity.getSelectedCar());
        carDto.setCarModel(entity.getCarModel());
        carDto.setCarColor(entity.getCarColor());
        carDto.setCarEngine(entity.getCarEngine());
        carDto.setCarOption(entity.getCarOption());
        carDto.setCarTransmission(entity.getCarTransmission());
        return carDto;
    }
}
