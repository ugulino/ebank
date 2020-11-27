package io.app.ebank.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.app.ebank.domain.customer.Customer;

@Entity
@Table(name="Accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="account_id")
	@NotNull
	// @NotNull(message = "Account id is required")
	private Long accountId;	
	
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentNumber")	
	private Customer customer;
    
    // TODO: Impedir limite menor que zero
    private Float limiteCredito = 0.00f;
	
	public Account() {
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
}
