package io.app.ebank.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name="Accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="account_id")
	@NotNull(message = "Account id is required")
	private Long accountId;	
	
	@Column(name="document_number")
	@NotNull(message = "Document number is required")
	private Long documentNumber;	

	@NotEmpty(message = "Customer name is required")
	private String name;
	private String email;
	
	@NotEmpty(message = "Telephone number is required")
	private String telephone;	
	
	public Account() {
	}
	public Account(Long accountId, Long documentNumber, String name, String telephone) {
		super();
		this.accountId = accountId;
		this.documentNumber = documentNumber;
		this.name = name;
		this.telephone = telephone;
	}
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", documentNumber=" + documentNumber + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + "]";
	}
}