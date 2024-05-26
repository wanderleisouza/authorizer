package com.acme.authorizer;

import java.time.Instant;
import java.util.UUID;

public record IncomingMessage(
    String csrf,
    String acquirerId,
    UUID transactionId,
    String cardHolder,
    String cardPAN,
    Integer score,
    Long createdAt
) {
    public IncomingMessage {
        createdAt = Instant.now().getEpochSecond();
    }
}