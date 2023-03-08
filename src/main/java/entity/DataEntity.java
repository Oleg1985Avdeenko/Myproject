package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Data
@MappedSuperclass
public class DataEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

}
