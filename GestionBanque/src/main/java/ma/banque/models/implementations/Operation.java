package ma.banque.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.models.GenericModel;
import ma.banque.models.implementations.childPerson.Employee;
import ma.banque.utils.Utils;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Builder(toBuilder = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Operation extends GenericModel {
    @Column(nullable = true, length = 10)
    private String code = Utils.getOperationCode();

    @Temporal(TemporalType.TIMESTAMP)
    private Date confermDate = new Date();

    @Column(nullable = false)
    private Double rising;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Account account;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee employee;
}
