package ma.banque.metier;

import ma.banque.utils.IMother;

import java.util.List;

public interface IMetier<S extends IMother> {
    S save(S object);

    S update(S object);

    void delete(S object);

    List<S> findAll();

    S findById(Long id);
}
