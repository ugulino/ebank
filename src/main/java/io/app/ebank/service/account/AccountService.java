package io.app.ebank.service.account;

import io.app.ebank.domain.account.AccountBody;
import io.app.ebank.domain.account.AccountDTO;

public interface AccountService {
	public AccountDTO findAccountById(Long id);
	public void createAccount(AccountBody account) throws Exception;
	public void atualizaLimiteCredito(Long accountId, Float amount) throws Exception;
}
