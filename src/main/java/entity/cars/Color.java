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
public class Color extends DataEntity {

    @Column
    private String colorName;

    @OneToMany(mappedBy = "carColor", cascade = CascadeType.PERSIST)
    private Set<Car> selectedColors = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(getId(), color.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
