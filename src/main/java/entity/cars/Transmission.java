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
public class Transmission extends DataEntity {

    @Column
    private String type;

    @OneToMany(mappedBy = "carTransmission", cascade = CascadeType.PERSIST)
    private Set<Car> selectedTransmissions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmission transmission = (Transmission) o;
        return Objects.equals(getId(), transmission.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
