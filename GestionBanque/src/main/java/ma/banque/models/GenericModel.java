package ma.banque.models;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.utils.IMother;

import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class GenericModel implements IMother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date addDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate = null;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate = null;
}
