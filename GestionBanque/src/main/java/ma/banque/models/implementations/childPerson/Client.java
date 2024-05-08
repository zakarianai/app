package ma.banque.models.implementations.childPerson;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.models.implementations.Person;

@Entity
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Client extends Person {

}
