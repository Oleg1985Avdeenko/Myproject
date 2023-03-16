package service.dto;

import entity.cars.*;
import entity.clients.ClientOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class CarDto extends DataDto{

    @Column
    private BigDecimal price;

    @Column
    private Boolean availability;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_dto_id", nullable = false)
    private ClientOrder dtoSelectedCar;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_id", nullable = false)
    private Model carModel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "engine_id", nullable = false)
    private Engine carEngine;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "color_id", nullable = false)
    private Color carColor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transmission_id", nullable = false)
    private Transmission carTransmission;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_option_id", nullable = false)
    private ModelOption carOption;

}
