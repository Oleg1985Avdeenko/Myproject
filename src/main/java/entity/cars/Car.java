package entity.cars;

import entity.clients.ClientOrder;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private BigDecimal price;

    @Column
    private Boolean availability;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id", nullable = false)
    private ClientOrder selectedCar;

}
