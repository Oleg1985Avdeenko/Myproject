package entity.cars;

import entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ModelOption extends DataEntity {

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

    @OneToMany(mappedBy = "carOption", cascade = CascadeType.PERSIST)
    private Set<Car> selectedOptions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelOption opnion = (ModelOption) o;
        return Objects.equals(getId(), opnion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
