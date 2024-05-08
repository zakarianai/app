package ma.banque.Contreollers;

import lombok.AllArgsConstructor;
import ma.banque.models.implementations.Account;
import ma.banque.models.implementations.childAccount.Courant;
import ma.banque.models.implementations.childPerson.Client;
import ma.banque.models.implementations.childAccount.Epargne;
import ma.banque.services.implementations.AccountService;
import ma.banque.services.implementations.ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class AccountController {
    private ClientService clientService;
    private AccountService accountService;

    @GetMapping(path = "/accounts/{id}/epargne")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String accountEpargneSave(RedirectAttributes redirectAttributes, @PathVariable Long id) {
        Client clt = clientService.findById(id);

        Account account = new Epargne();
        account.setClient(clt);
        Account accountSaved = accountService.save(account);

        redirectAttributes.addFlashAttribute("success", "");
        redirectAttributes.addFlashAttribute("clientSuccess", clt);
        redirectAttributes.addFlashAttribute("accountSuccess", accountSaved);

        return "redirect:/clients";
    }

    @GetMapping(path = "/accounts/{id}/courant")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String accountCourantSave(RedirectAttributes redirectAttributes, @PathVariable Long id) {
        Client clt = clientService.findById(id);

        Account account = new Courant();
        account.setClient(clt);
        Account accountSaved = accountService.save(account);

        redirectAttributes.addFlashAttribute("success", "");
        redirectAttributes.addFlashAttribute("clientSuccess", clt);
        redirectAttributes.addFlashAttribute("accountSuccess", accountSaved);

        return "redirect:/clients";
    }
}
