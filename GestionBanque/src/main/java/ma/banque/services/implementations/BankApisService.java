package ma.banque.services.implementations;

import lombok.AllArgsConstructor;
import ma.banque.metier.IBankApis;
import ma.banque.models.implementations.Account;
import ma.banque.models.implementations.childAccount.Courant;
import ma.banque.models.implementations.childAccount.Epargne;
import ma.banque.models.implementations.childOperation.Payment;
import ma.banque.models.implementations.childOperation.Retrait;
import ma.banque.models.implementations.childPerson.Employee;
import ma.banque.models.implementations.Operation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class BankApisService implements IBankApis {
    private AccountService accountService;
    private OperationService operationService;

    @Override
    public void accountsRetrait(String accountNumber, Double rising, String witchAccount) throws Exception {
        Account account = this.getAccount(accountNumber);
        Account accountEpargne = this.hasEpargneAccount(accountNumber);

        Employee employee = new Employee();
        employee.setId(1L);

        if (witchAccount.equals("courant")) {
            assert account != null;
            if (account.getBalance() >= rising) {
                account.setBalance(account.getBalance() - rising);
                this.saveRetraitOperation(account, rising, employee);
            } else {
                throw new Exception();
            }
        } else if (witchAccount.equals("epargne")) {
            assert accountEpargne != null;
            if (accountEpargne.getBalance() >= rising) {
                accountEpargne.setBalance(accountEpargne.getBalance() - rising);
                account.setBalance(account.getBalance() + rising);

                this.saveRetraitOperation(account, rising, employee);
                this.savePaymentOperation(accountEpargne, rising, employee);
            }
        }
    }

    @Override
    public void accountsPayment(String accountNumber, Double rising, String witchAccount) {
        Account account = this.getAccount(accountNumber);
        Account accountEpargne = this.hasEpargneAccount(accountNumber);

        Employee employee = new Employee();
        employee.setId(1L);

        if (witchAccount.equals("courant")) {
            assert account != null;
            account.setBalance(account.getBalance() + rising);
            this.savePaymentOperation(account, rising, employee);
        } else if (witchAccount.equals("epargne")) {
            assert accountEpargne != null;
            if (account.getBalance() >= rising) {
                accountEpargne.setBalance(accountEpargne.getBalance() + rising);
                account.setBalance(account.getBalance() - rising);

                this.saveRetraitOperation(accountEpargne, rising, employee);
                this.savePaymentOperation(account, rising, employee);
            }
        }
    }

    @Override
    public void accountsCourantVersement(String accountNumberIssuer, String accountNumberReceiver, Double rising) {
        Account accountIssuer = this.getAccount(accountNumberIssuer);
        Account accountReceiver = this.getAccount(accountNumberReceiver);

        assert accountIssuer != null;
        assert accountReceiver != null;

        if (accountIssuer instanceof Courant && accountReceiver instanceof Courant) {

            if (accountIssuer.getBalance() >= rising) {
                accountIssuer.setBalance(accountIssuer.getBalance() - rising);
                accountReceiver.setBalance(accountReceiver.getBalance() + rising);
            }

            Employee employee = new Employee();
            employee.setId(1L);

            this.saveRetraitOperation(accountIssuer, rising, employee);
            this.savePaymentOperation(accountReceiver, rising, employee);
        }

    }

    private Account getAccount(String accountNumber) {
        return accountService.findAll().stream().filter(a ->
                Objects.equals(a.getAccountNumber(), accountNumber)
        ).findFirst().orElse(null);
    }

    private Account hasEpargneAccount(String accountNumber) {
        return this.getAccount(accountNumber).getClient().getAccounts().stream().filter(a ->
                a instanceof Epargne
        ).findFirst().orElse(null);
    }

    private void saveRetraitOperation(Account account, Double rising, Employee employee) {
        operationService.save(Retrait.builder()
                .account(account)
                .rising(rising)
                .employee(employee)
                .confermDate(new Date())
                .build()
        );
    }

    private void savePaymentOperation(Account account, Double rising, Employee employee) {
        operationService.save(Payment.builder()
                .account(account)
                .rising(rising)
                .employee(employee)
                .confermDate(new Date())
                .build()
        );
    }

}
