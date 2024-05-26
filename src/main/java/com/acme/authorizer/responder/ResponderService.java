package com.acme.authorizer.responder;

import com.acme.authorizer.capturer.IncomingMessage;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ResponderService {

    public OutcamingMessage format(IncomingMessage incomingMessage, String status) {
        return new OutcamingMessage(incomingMessage.acquirerId(), incomingMessage.transactionId(),
                incomingMessage.cardHolder(), incomingMessage.cardPAN(), status, Instant.now().getEpochSecond());
    }

}
