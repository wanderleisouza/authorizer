package com.acme.authorizer.approver;

import com.acme.authorizer.capturer.IncomingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssuerIntegrationService {

    private final ApplicationEventPublisher events;

    public boolean getAuthorization(IncomingMessage data, Integer score) {
        boolean responseStatus = true;
        events.publishEvent(new IssuerResponseEvent(this, data, score, responseStatus));
        return responseStatus;
    }

}
