package service.dto;

import entity.cars.*;
import entity.clients.ClientOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_dto_id", nullable = false)
    private ClientOrder dtoSelectedCar;

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

}
