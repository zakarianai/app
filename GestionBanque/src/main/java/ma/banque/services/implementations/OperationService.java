package ma.banque.services.implementations;

import ma.banque.models.implementations.Operation;
import ma.banque.repositories.implementations.OperationRepository;
import ma.banque.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperationService extends GenericService<Operation> {
    public OperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }
}
