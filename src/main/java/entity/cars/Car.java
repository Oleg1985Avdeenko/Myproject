package entity.cars;

import entity.DataEntity;
import entity.clients.ClientOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Car extends DataEntity {

    @Column
    private BigDecimal price;

    @Column
    private Boolean availability;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_id", nullable = false)
    private Model carModel ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "engine_id", nullable = false)
    private Engine carEngine;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "color_id", nullable = false)
    private Color  carColor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transmission_id", nullable = false)
    private Transmission carTransmission;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_option_id", nullable = false)
    private ModelOpnion carOption;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private ClientOrder selectedCar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
