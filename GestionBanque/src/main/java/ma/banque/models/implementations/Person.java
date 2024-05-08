package ma.banque.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.models.GenericModel;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends GenericModel {
    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, length = 1)
    private Character gender;

    @Column(nullable = false, length = 10)
    private String numberCN;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 100)
    private String address;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Account> Accounts;
}
