package com.card.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.command.IssueCreditCardCommand;

@RestController
public class CreditCardController {
	@Autowired
	private CommandGateway commandGateway;

	@PostMapping("/creditcard/issue")
	void issueCreditCard(@RequestBody IssueCreditCardCommand issueCreditCardCommand) {
		issueCreditCardCommand.setId(UUID.randomUUID().toString());
		commandGateway.send(issueCreditCardCommand);
	}

}
