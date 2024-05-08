package ma.banque.models.implementations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import ma.banque.models.GenericModel;
import ma.banque.models.implementations.childPerson.Employee;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Builder
public class Role extends GenericModel {
    @Column(nullable = false, length = 10)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees;
}
