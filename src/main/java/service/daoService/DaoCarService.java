package service.daoService;

import service.Service;
import service.dto.CarDto;
import service.mapping.MappingCar;
import service.MappingService;
import dao.impl.DaoCarImpl;
import dao.DAO;
import entity.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DaoCarService implements Service<CarDto> {
    private final DAO<Car> carDAO = new DaoCarImpl();

    private final MappingService<Car, CarDto> mappingCar = new MappingCar();


    @Override
    public CarDto save(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        car = carDAO.save(car);
        carDto.setId(car.getId());
        return mappingCar.convertToDTO(car);
    }

    @Override
    public void update(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        carDAO.update(car);
    }

    @Override
    public void delete(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        carDAO.delete(car);
    }

    @Override
    public CarDto findById(CarDto carDto) {
        Car car = mappingCar.convertToEntity(carDto);
        car = carDAO.findById(car);
        return mappingCar.convertToDTO(car);
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carDAO.findAll(Car.builder().build());
        return cars.stream()
                .map(mappingCar::convertToDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public Integer getNumberOfRows() {
//        return carDAO.getNumberOfRows();
//    }
}
