package ma.banque.services;

import lombok.AllArgsConstructor;
import ma.banque.metier.IMetier;
import ma.banque.repositories.GenericRepository;
import ma.banque.utils.IMother;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Transactional
@AllArgsConstructor
public class GenericService<S extends IMother> implements IMetier<S> {
    private GenericRepository<S> genericRepository;

    @Override
    public S save(S object) {
        return !Objects.isNull(object) ? genericRepository.save(object) : null;
    }

    @Override
    public S update(S object) {
        if (!Objects.isNull(object)) {
            S result = genericRepository.save(object);
            result.setUpdateDate(new Date());
            return result;
        }
        return null;
    }

    @Override
    public void delete(S object) {
        if (!Objects.isNull(object)) {
            S result = this.findById(object.getId());
            assert result != null;
            result.setDeleteDate(new Date());
        }
    }

    @Override
    public List<S> findAll() {
        return genericRepository.findAll().stream().filter(s -> Objects.isNull(s.getDeleteDate())).distinct().toList();
    }

    @Override
    public S findById(Long id) {
        return genericRepository.findById(id).stream().filter(s -> Objects.isNull(s.getDeleteDate())).findFirst().orElse(null);
    }
}
