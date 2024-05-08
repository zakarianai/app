package ma.banque.models.implementations.childPerson;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.models.implementations.Operation;
import ma.banque.models.implementations.Person;
import ma.banque.models.implementations.Role;
import ma.banque.utils.Utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Employee extends Person {
    @Column(nullable = false, length = 20)
    private String code = Utils.getEmployeeCode();

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled;
    private boolean tokenExpired;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Set<Operation> operations;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
}
