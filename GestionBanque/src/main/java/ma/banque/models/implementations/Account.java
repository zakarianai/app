package ma.banque.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.models.GenericModel;
import ma.banque.models.implementations.childPerson.Client;
import ma.banque.utils.Utils;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends GenericModel {
    @Column(nullable = false, length = 16)
    private String accountNumber = Utils.getAccountNumber();

    @Column(nullable = false)
    private Double balance = 0.0;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<Operation> operations;
}
