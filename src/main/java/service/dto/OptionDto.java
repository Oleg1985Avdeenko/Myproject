package service.dto;

import entity.cars.Car;
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
public class OptionDto extends DataDto{
    @Column
    private String salon;

    @Column
    private Boolean heatedSeat;

    @Column
    private Boolean cruiseControl;

    @Column
    private Boolean steeringWheelControl;

    @Column
    private Boolean fogLight;

    @OneToMany(mappedBy = "carOption", cascade = CascadeType.PERSIST)
    private Set<Car> selectedOptions = new HashSet<>();
}
