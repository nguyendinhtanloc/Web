package murach.service;

import murach.model.Account;
import murach.data.AccountRepository;
import murach.util.PasswordUtil;

public class AuthService {
    private final AccountRepository accountRepository = new AccountRepository();

    public Account login(String email, String password) {
        Account account = accountRepository.findByEmail(email);
        if (account != null && PasswordUtil.checkPassword(password, account.getPassword())) {
            return account;
        }
        return null;
    }
}
