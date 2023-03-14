package service.dto;


import entity.cars.Car;
import entity.cars.Model;
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
public class ModelDto extends DataDto{
    @Column
    private String modelName;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL)
    private Set<Car> selectedModels = new HashSet<>();
}
