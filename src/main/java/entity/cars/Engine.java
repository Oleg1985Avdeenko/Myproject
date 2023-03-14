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
public class Engine extends DataEntity {

    @Column
    private Double volume;

    @Column
    private String type;

    @OneToMany(mappedBy = "carEngine", cascade = CascadeType.PERSIST)
    private Set<Car> selectedEngines = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(getId(), engine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
