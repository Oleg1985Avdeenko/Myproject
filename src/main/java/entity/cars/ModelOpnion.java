package entity.cars;

import entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ModelOpnion extends DataEntity {

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
    @JoinColumn(name = "car_id", nullable = false)
    private Car carOption;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelOpnion opnion = (ModelOpnion) o;
        return Objects.equals(getId(), opnion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
