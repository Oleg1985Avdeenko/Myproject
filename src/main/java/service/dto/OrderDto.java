package service.dto;

import entity.cars.Car;
import entity.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class OrderDto extends DataDto{
    @OneToMany(mappedBy = "dtoSelectedCar", cascade = CascadeType.ALL)
    private Set<Car> dtoSelectedCars = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_dto_id", nullable = false)
    private Client clientDto;
}
