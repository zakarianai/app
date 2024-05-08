package ma.banque.services.implementations;

import ma.banque.models.implementations.Role;
import ma.banque.repositories.implementations.RoleRepository;
import ma.banque.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService extends GenericService<Role> {
    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
    }
}
