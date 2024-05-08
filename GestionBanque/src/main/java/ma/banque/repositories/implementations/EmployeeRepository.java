package ma.banque.repositories.implementations;

import ma.banque.models.implementations.childPerson.Employee;
import ma.banque.repositories.GenericRepository;

public interface EmployeeRepository extends GenericRepository<Employee> {
    Employee findByUsername(String username);
}
