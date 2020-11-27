package io.app.ebank.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.app.ebank.domain.transaction.Transaction;
import io.app.ebank.domain.transaction.TransactionResponse;
import io.app.ebank.exceptions.LimiteAccountException;
import io.app.ebank.exceptions.RegisterTransactionException;
import io.app.ebank.service.transaction.TransactionService;
import io.app.ebank.utils.JsonMessage;

@RestController
public class TransactionController {
	private final static Logger LOGGER = Logger.getLogger(TransactionController.class.getCanonicalName());
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/v1/transactions", method = RequestMethod.POST,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerTransaction(@Valid @RequestBody Transaction transaction) {
		try {
			Transaction transactionCreated = transactionService.registerTransaction(transaction);			
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Transaction Id:" + transactionCreated.getTransactionId() + " created");
			TransactionResponse response = new TransactionResponse(transaction);
			return ResponseEntity.ok().body(response);
		} catch (LimiteAccountException e) {
			LOGGER.setLevel(Level.INFO);
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(JsonMessage.get(e.getMessage()));					
		} catch (RegisterTransactionException e) {
			LOGGER.setLevel(Level.WARNING);
			LOGGER.info(e.getMessage());
			return ResponseEntity
					.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(JsonMessage.get(e.getMessage()));			
		} catch (Exception e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.info(e.getMessage());			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
