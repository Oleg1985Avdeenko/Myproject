package service.daoService;

import service.Service;
import service.dto.CarDto;
import service.mapping.MappingCar;
import service.mapping.MappingService;
import dao.DaoCarImpl;
import dao.interfaces.DAO;
import entity.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DaoCarService implements Service<CarDto> {
    private final DAO<Car> carDAO = new DaoCarImpl();

    private final MappingService<Car, CarDto> mappingCar = new MappingCar();


    @Override
    public CarDto save(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        carDAO.save(car);
        carDto.setId(car.getId());
        return mappingCar.convertToDTO(car);
    }

    @Override
    public CarDto update(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        carDAO.update(car);
        return mappingCar.convertToDTO(car);
    }

    @Override
    public CarDto findById(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        car = carDAO.findById(car);
        return mappingCar.convertToDTO(car);
    }

    @Override
    public void delete(CarDto carDto) {
        carDAO.findById(mappingCar.convertToEntity(carDto));
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> clients = carDAO.findAll(Car.builder().build());
        return clients.stream()
                .map(mappingCar::convertToDTO)
                .collect(Collectors.toList());
    }
}
