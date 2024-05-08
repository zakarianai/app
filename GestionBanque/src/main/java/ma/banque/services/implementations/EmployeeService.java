package ma.banque.services.implementations;

import ma.banque.models.implementations.childPerson.Employee;
import ma.banque.repositories.implementations.EmployeeRepository;
import ma.banque.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService extends GenericService<Employee> {
    public EmployeeService(EmployeeRepository employeeRepository) {
        super(employeeRepository);
    }
}
