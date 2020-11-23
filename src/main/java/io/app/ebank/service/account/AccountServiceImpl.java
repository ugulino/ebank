package io.app.ebank.service.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.app.ebank.domain.Account;
import io.app.ebank.exceptions.CreateAccountException;
import io.app.ebank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account findAccountById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		if (account.isPresent()) {
			return account.get();
		}
		return null;
	}

	@Override
	public void createAccount(Account account) throws Exception {
		boolean isAccountExists = findAccountById(account.getAccountId()) != null;
		if (isAccountExists) {	
			throw new CreateAccountException("Account already registered");
		}
		
		accountRepository.save(account);
	}

}
