package com.card.event;

import java.math.BigDecimal;

import org.axonframework.modelling.command.AggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardIssuedEvent {
	@AggregateIdentifier
	private String id;
	private String issuedBank;
	private String cardHolderId;
	private BigDecimal cardAmount;
}
