package io.app.ebank.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.app.ebank.domain.account.AccountDTO;
import io.app.ebank.domain.transaction.Transaction;
import io.app.ebank.exceptions.RegisterTransactionException;
import io.app.ebank.repository.*;
import io.app.ebank.service.account.AccountService;
import io.app.ebank.utils.DateUtils;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountService accountService;
	
	private void setDebit(Transaction transaction) {
		transaction.setAmount(transaction.getAmount()*-1);
	}
	
	@Override
	public Transaction registerTransaction(Transaction transaction) throws Exception {		
		AccountDTO account = accountService.findAccountById(transaction.getAccountId()); 
		if (account == null) {	
			throw new RegisterTransactionException("Account not found");
		}
			
		switch (transaction.getOperationTypeId()) {
		case COMPRA_A_VISTA:
			setDebit(transaction);
			break;
		case COMPRA_PARCELADA:
			setDebit(transaction);
			break;
		case SAQUE:
			setDebit(transaction);
			break;
			
		default:
			break;
		}
		
		transaction.setEventDate(DateUtils.getToday());
		Transaction transactionRegistered = transactionRepository.save(transaction);
		
		//Atualiza limite crédito
		Float amount = transaction.getAmount();
		accountService.atualizaLimiteCredito(account.getAccountId(), amount);
		
		return transactionRegistered;
	}
}
