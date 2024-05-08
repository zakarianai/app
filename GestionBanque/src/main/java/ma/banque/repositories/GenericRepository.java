package ma.banque.repositories;

import ma.banque.utils.IMother;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<S extends IMother> extends JpaRepository<S, Long> {

}
