package service.dto;

import entity.clients.ClientOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class ClientDto extends DataDto{

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String cellPhone;

    @Column
    private String email;

    @OneToMany(mappedBy = "clientDto", cascade = CascadeType.PERSIST)
    private Set<ClientOrder> dtoOrders = new HashSet<>();
}
