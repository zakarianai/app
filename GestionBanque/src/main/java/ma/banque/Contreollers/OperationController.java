package ma.banque.Contreollers;

import lombok.AllArgsConstructor;
import ma.banque.models.implementations.childAccount.Courant;
import ma.banque.services.implementations.AccountService;
import ma.banque.services.implementations.BankApisService;
import ma.banque.services.implementations.OperationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class OperationController {
    private AccountService accountService;
    private OperationService operationService;
    private BankApisService bankApisService;

    @GetMapping(path = "/operations")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String operationPage(Model model) {
        model.addAttribute("operations", operationService.findAll());
        model.addAttribute("accounts", accountService.findAll().stream().filter(a -> a instanceof Courant).toList());
        return "operation";
    }

    @PostMapping(path = "/accounts/retrait/transaction")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String accountCourantRetrait(@RequestParam String accountNumber, @RequestParam Double rising,
                                        @RequestParam String witchAccount, Model model,
                                        RedirectAttributes redirectAttributes) {
        try {
            bankApisService.accountsRetrait(accountNumber, rising, witchAccount);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("Exception", "Your rising invalid");
        }
        return "redirect:/operations";
    }

    @PostMapping(path = "/accounts/payment/transaction")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String accountCourantPayment(@RequestParam String accountNumber, @RequestParam Double rising,
                                        @RequestParam String witchAccount,
                                        RedirectAttributes redirectAttributes) {
        bankApisService.accountsPayment(accountNumber, rising, witchAccount);
        return "redirect:/user/operations";
    }

    @PostMapping(path = "/accounts/versement/transaction")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String accountCourantVersement(@RequestParam String accountNumberIssuer, @RequestParam String accountNumberReceiver,
                                          @RequestParam Double rising,
                                          RedirectAttributes redirectAttributes) {
        bankApisService.accountsCourantVersement(accountNumberIssuer, accountNumberReceiver, rising);
        return "redirect:/operations";
    }
}
