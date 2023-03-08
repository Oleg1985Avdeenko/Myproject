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
public class EngineDto extends DataDto{

    @Column
    private Double volume;

    @Column
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_dto_id", nullable = false)
    private Car carEngine;
}
