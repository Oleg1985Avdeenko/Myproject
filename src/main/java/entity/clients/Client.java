package entity.clients;

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
public class Client extends DataEntity {

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<ClientOrder> orders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
