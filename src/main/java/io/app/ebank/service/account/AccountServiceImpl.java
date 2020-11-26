package io.app.ebank.service.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.app.ebank.domain.account.Account;
import io.app.ebank.domain.account.AccountBody;
import io.app.ebank.domain.account.AccountDTO;
import io.app.ebank.domain.customer.Customer;
import io.app.ebank.exceptions.CreateAccountException;
import io.app.ebank.repository.AccountRepository;
import io.app.ebank.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;	
	
	@Override
	public AccountDTO findAccountById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		if (account.isPresent()) {			
			return new AccountDTO(account.get());
		}
		return null;
	}

	@Override
	public void createAccount(AccountBody body) throws Exception {
		boolean isAccountExists = findAccountById(body.getAccountId()) != null;
		if (isAccountExists) {	
			throw new CreateAccountException("Account already registered");
		}
		
		Customer customer = new Customer();
		customer.setName(body.getName());
		customer.setDocumentNumber(body.getDocumentNumber());
		customer.setTelephone(body.getTelephone());
		customerRepository.save(customer);
		
		Account account = new Account();
		account.setAccountId(body.getAccountId());
		account.setCustomer(customer);
		accountRepository.save(account);
	}

	@Override
	public void atualizaLimiteCredito(Long idAccount, Float amount) throws Exception {
		Account account = accountRepository.findById(idAccount).get();
		if (account != null) {
			Float limiteAtualizado = account.getLimiteCredito();
			limiteAtualizado = limiteAtualizado + amount;
			if (limiteAtualizado < 0) {
				throw new Exception("Account already registered");
			}
			account.setLimiteCredito(limiteAtualizado);
			accountRepository.save(account);
		}
	}
}
