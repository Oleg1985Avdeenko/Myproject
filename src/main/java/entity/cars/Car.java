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

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL)
    private Set<Model> selectedModels = new HashSet<>();

    @OneToMany(mappedBy = "carEngine", cascade = CascadeType.ALL)
    private Set<Engine> selectedEngines = new HashSet<>();

    @OneToMany(mappedBy = "carColor", cascade = CascadeType.ALL)
    private Set<Color> selectedColors = new HashSet<>();

    @OneToMany(mappedBy = "carTransmission", cascade = CascadeType.ALL)
    private Set<Transmission> selectedTransmissions = new HashSet<>();

    @OneToMany(mappedBy = "carOption", cascade = CascadeType.ALL)
    private Set<ModelOpnion> selectedOptions = new HashSet<>();

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
