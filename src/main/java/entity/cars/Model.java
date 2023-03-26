package entity.cars;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String modelName;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.PERSIST)
    private Set<Car> selectedModels = new HashSet<>();

}
