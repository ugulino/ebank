package io.app.ebank.repository;

import org.springframework.data.repository.CrudRepository;

import io.app.ebank.domain.account.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
