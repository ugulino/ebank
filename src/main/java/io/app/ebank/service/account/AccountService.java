package io.app.ebank.service.account;

import io.app.ebank.domain.Account;

public interface AccountService {
	public Account findAccountById(Long id);
	public void createAccount(Account account) throws Exception;
}
