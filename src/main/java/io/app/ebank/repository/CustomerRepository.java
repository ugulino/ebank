package io.app.ebank.repository;

import org.springframework.data.repository.CrudRepository;

import io.app.ebank.domain.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
