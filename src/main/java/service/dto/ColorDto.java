package service.dto;

import entity.cars.Car;
import entity.cars.Color;
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
public class ColorDto extends DataDto{
    @Column
    private String colorName;

    @OneToMany(mappedBy = "carColor", cascade = CascadeType.PERSIST)
    private Set<Car> selectedColors = new HashSet<>();
}
