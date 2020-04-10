package com.card.command;

import java.math.BigDecimal;

import org.axonframework.commandhandling.RoutingKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueCreditCardCommand {
	@RoutingKey
	private String id;
	private String issuedBank;
	private String cardHolderId;
	private BigDecimal cardAmount;
}
