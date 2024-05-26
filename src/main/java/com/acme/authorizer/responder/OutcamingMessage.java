package com.acme.authorizer.responder;

import java.util.UUID;

public record OutcamingMessage(
    String acquirerId,
    UUID transactionId,
    String cardHolder,
    String cardPAN,
    String status,
    Long createdAt
) {}