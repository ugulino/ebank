package io.app.ebank.domain.customer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.app.ebank.domain.account.Account;

@Table(name="Customers")
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="document_number")
	@NotNull(message = "Document number is required")
	private Long documentNumber;	

	@NotEmpty(message = "Customer name is required")
	private String name;

	private String email;
	
	@NotEmpty(message = "Telephone number is required")
	private String telephone;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date birthDay;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Account> accounts;
	
	public Customer() {
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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@Override
	public String toString() {
		return "Customer [documentNumber=" + documentNumber + ", name=" + name + ", email=" + email
				+ ", telephone=" + telephone + ", birthDay=" + birthDay + "]";
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
