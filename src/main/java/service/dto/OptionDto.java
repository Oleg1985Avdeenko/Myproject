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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_dto_id", nullable = false)
    private Car carOption;
}
