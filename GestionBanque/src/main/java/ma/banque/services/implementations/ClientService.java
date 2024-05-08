package ma.banque.services.implementations;

import ma.banque.models.implementations.Person;
import ma.banque.models.implementations.childPerson.Client;
import ma.banque.repositories.implementations.ClientRepository;
import ma.banque.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService extends GenericService<Client> {
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }
}
