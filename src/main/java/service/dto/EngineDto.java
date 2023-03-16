package service.dto;

import entity.cars.Car;
import entity.cars.Engine;
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
public class EngineDto extends DataDto{

    @Column
    private Double volume;

    @Column
    private String type;

    @OneToMany(mappedBy = "carEngine", cascade = CascadeType.PERSIST)
    private Set<Car> selectedEngines = new HashSet<>();
}
