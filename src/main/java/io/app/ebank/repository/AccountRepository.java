package io.app.ebank.repository;

import org.springframework.data.repository.CrudRepository;

import io.app.ebank.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
