package ma.banque.models.implementations.childOperation;

import jakarta.persistence.Entity;
import lombok.*;
import ma.banque.models.implementations.Operation;

@Entity
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Payment extends Operation {

}
