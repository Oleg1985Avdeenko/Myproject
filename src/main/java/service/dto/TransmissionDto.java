package service.dto;

import entity.cars.Car;
import entity.cars.Transmission;
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
public class TransmissionDto extends DataDto{
    @Column
    private String type;

    @OneToMany(mappedBy = "carTransmission", cascade = CascadeType.PERSIST)
    private Set<Car> selectedTransmissions = new HashSet<>();
}
