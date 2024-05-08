package ma.banque.Contreollers;

import lombok.AllArgsConstructor;
import ma.banque.models.implementations.Account;
import ma.banque.models.implementations.childPerson.Client;
import ma.banque.services.implementations.ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping(path = "/clients")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String clientPage(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("clients", clientService.findAll());
        return "client";
    }

    @GetMapping(path = "/clients/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String clientDelete(RedirectAttributes redirectAttributes, @PathVariable Long id) {
        Client clt = clientService.findById(id);
        clientService.delete(clt);

        Account accountSaved = new Account();

        redirectAttributes.addFlashAttribute("success", "");
        redirectAttributes.addFlashAttribute("clientSuccess", clt);
        redirectAttributes.addFlashAttribute("accountSuccess", accountSaved);
        return "redirect:/clients";
    }

    @PostMapping(path = "/clients/save")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String clientSave(@ModelAttribute("client") Client client, RedirectAttributes redirectAttributes) {
        Client clt = clientService.save(client);

        redirectAttributes.addFlashAttribute("success", "");
        redirectAttributes.addFlashAttribute("clientSuccess", clt);
        return "redirect:/clients";
    }
}
