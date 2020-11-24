package io.app.ebank.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.app.ebank.enums.OperationTypeEnum;

@Table(name="Transactions")
@Entity
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="transaction_id")
	private Long transactionId;
	
	@Column(name="account_id")
	@NotNull(message = "Account id is required")
	private Long accountId; 
	
	@Column(name="operation_type_id")
	@NotNull(message = "Operation type is required")
	private OperationTypeEnum operationTypeId; 
	
	@NotNull(message = "Amount is required")
	private Float amount;	
	private Date eventDate;
	
	public Transaction() {
		Calendar calendar = Calendar.getInstance();
		this.eventDate = calendar.getTime();
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
	
	public OperationTypeEnum getOperationTypeId() {
		return operationTypeId;
	}
	
	public void setOperationTypeId(OperationTypeEnum operationTypeId) {
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

	@Override
	public String toString() {
		return transactionId + " " + 
		accountId + "" +
	    operationTypeId.getOperationTypeValue() + " " + 
		amount + " " + 
	    eventDate.toString();
	}	
}
