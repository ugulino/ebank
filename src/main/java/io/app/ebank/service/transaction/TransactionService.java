package io.app.ebank.service.transaction;

import io.app.ebank.domain.transaction.Transaction;

public interface TransactionService {
	public Transaction registerTransaction(Transaction transaction) throws Exception;;
}
