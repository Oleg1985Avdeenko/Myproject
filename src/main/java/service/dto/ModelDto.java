package service.dto;


import entity.cars.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class ModelDto extends DataDto{
    @Column
    private String modelName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car-dto_id", nullable = false)
    private Car carModel;
}
