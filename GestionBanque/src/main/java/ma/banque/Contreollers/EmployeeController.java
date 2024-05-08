package ma.banque.Contreollers;

import lombok.AllArgsConstructor;
import ma.banque.models.implementations.childPerson.Employee;
import ma.banque.services.implementations.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String employeesPage(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employeeService.findAll());
        return "employee";
    }

    @PostMapping(path = "/employee/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String employeeSave(@ModelAttribute("employee") Employee employee, @RequestParam("confirmPassword") String confirmPassword,
                               RedirectAttributes redirectAttributes) {
        if(!confirmPassword.equals(employee.getPassword())) throw new RuntimeException("Password not match !!");
        employeeService.save(employee);
        return "redirect:/employees";
    }
}
