package com.card.aggregate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.card.command.IssueCreditCardCommand;
import com.card.event.CreditCardIssuedEvent;

import lombok.Data;

@Aggregate
@Data
public class CreditCardAggregate {
	@AggregateIdentifier
	private String cardId;
	private String issuedBank;
	private String cardHolderId;
	private BigDecimal cardAmount;

	@CommandHandler
	public CreditCardAggregate(IssueCreditCardCommand issueCreditCardCommand) {
		CreditCardIssuedEvent creditCardIssuedEvent = CreditCardIssuedEvent.builder().id(issueCreditCardCommand.getId())
				.cardHolderId(issueCreditCardCommand.getCardHolderId())
				.issuedBank(issueCreditCardCommand.getIssuedBank()).cardAmount(issueCreditCardCommand.getCardAmount())
				.build();
		AggregateLifecycle.apply(creditCardIssuedEvent);
	}

	@EventSourcingHandler
	public void on(CreditCardIssuedEvent creditCardIssuedEvent) {
		setCardId(creditCardIssuedEvent.getId());
		setCardHolderId(creditCardIssuedEvent.getCardHolderId());
		setIssuedBank(creditCardIssuedEvent.getIssuedBank());
		setCardAmount(creditCardIssuedEvent.getCardAmount());
	}

}
