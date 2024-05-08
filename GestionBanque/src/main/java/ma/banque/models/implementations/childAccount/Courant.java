package ma.banque.models.implementations.childAccount;

import jakarta.persistence.Entity;
import lombok.*;
import ma.banque.models.implementations.Account;

@Entity
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Courant extends Account {

}
