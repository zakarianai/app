package ma.banque;

import ma.banque.models.implementations.Role;
import ma.banque.models.implementations.childPerson.Employee;
import ma.banque.services.implementations.EmployeeService;
import ma.banque.services.implementations.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@SpringBootApplication
public class GestionBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBanqueApplication.class, args);
    }

}
