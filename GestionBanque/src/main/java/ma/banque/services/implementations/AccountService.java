package ma.banque.services.implementations;

import ma.banque.models.implementations.Account;
import ma.banque.repositories.implementations.AccountRepository;
import ma.banque.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService extends GenericService<Account> {
    public AccountService(AccountRepository accountRepository) {
        super(accountRepository);
    }
}
