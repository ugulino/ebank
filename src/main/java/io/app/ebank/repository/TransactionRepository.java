package io.app.ebank.repository;

import org.springframework.data.repository.CrudRepository;

import io.app.ebank.domain.transaction.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
