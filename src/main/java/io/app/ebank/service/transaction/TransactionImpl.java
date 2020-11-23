package io.app.ebank.service.transaction;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.app.ebank.domain.Transaction;
import io.app.ebank.exceptions.RegisterTransactionException;
import io.app.ebank.repository.*;
import io.app.ebank.service.account.AccountService;

@Service
public class TransactionImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountService accountService;

	private void setDebit(Transaction transaction) {
		transaction.setAmount(transaction.getAmount()*-1);
	}
	
	@Override
	public Transaction registerTransaction(Transaction transaction) throws RegisterTransactionException {
		boolean isAccountExists = accountService.findAccountById(transaction.getAccountId()) != null;
		
		if (!isAccountExists) {	
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
		
		Calendar eventDate = Calendar.getInstance();
		transaction.setEventDate(eventDate.getTime());
		Transaction transactionRegistered = transactionRepository.save(transaction);
		return transactionRegistered;
	}
}
