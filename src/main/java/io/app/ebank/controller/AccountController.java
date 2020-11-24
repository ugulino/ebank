package io.app.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.app.ebank.domain.*;
import io.app.ebank.exceptions.CreateAccountException;
import io.app.ebank.service.account.AccountService;
import io.app.ebank.utils.JsonMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

@RestController
public class AccountController {
	private final static Logger LOGGER = Logger.getLogger(AccountController.class.getName());
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/account/id/{id}", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAccountById(@PathVariable("id") Long id) {
		try {
			Account account = accountService.findAccountById(id);
			if (account == null) {
				LOGGER.setLevel(Level.WARNING);
				LOGGER.info("Account not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new String(JsonMessage.get("Account not Found")));
			}
			return ResponseEntity.ok().body(account);
		} catch (Exception e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe(e.getStackTrace().toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createAccount(@Valid @RequestBody Account account) {
		try {
			accountService.createAccount(account);
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Account id:" + account.getAccountId() + " created");			
			return ResponseEntity.ok(JsonMessage.get("Account created"));
		} catch (CreateAccountException e) {
			LOGGER.setLevel(Level.INFO);
			LOGGER.severe(e.getMessage());			
			return ResponseEntity
					.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(JsonMessage.get(e.getMessage()));
		} catch (Exception e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe(e.getStackTrace().toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
