package io.app.ebank.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="account_id")
	private Long accountId;	
	@Column(name="document_number")
	private Long documentNumber;	
	private String name;
	private String email;
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
