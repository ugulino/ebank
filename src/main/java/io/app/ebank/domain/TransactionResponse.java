package io.app.ebank.domain;

import java.util.Date;

public class TransactionResponse {
	private Long transactionId;
	private Long accountId; 
	private Integer operationTypeId; 
	private Float amount;	
	private Date eventDate;
	
	public TransactionResponse() {
	}
	
	public TransactionResponse parseToTransactionResponse(Transaction transaction) {
		this.transactionId = transaction.getTransactionId();
		this.accountId = transaction.getAccountId();
		this.operationTypeId = transaction.getOperationTypeId().ordinal();
		this.amount = transaction.getAmount();
		this.eventDate = transaction.getEventDate();
		
		return this;
	}
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(Integer operationTypeId) {
		this.operationTypeId = operationTypeId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
