package io.app.ebank.domain.account;

import javax.validation.constraints.NotNull;

public class AccountDTO {
	@NotNull(message = "Account id is required")
	private Long accountId;	
	private Long documentNumber;	
	private String name;	
	
	public Long getDocumentNumber() {
		return documentNumber;
	}
	
	public AccountDTO() {
	}
	
	public AccountDTO(Account account) {
		this.accountId = account.getAccountId();
		this.documentNumber = account.getCustomer().getDocumentNumber();
		this.name = account.getCustomer().getName();
	}
	
	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
