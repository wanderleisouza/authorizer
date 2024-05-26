package com.acme.authorizer.approver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IssuerResponseListener {

    @EventListener
    public void onApplicationEvent(IssuerResponseEvent event) {
       log.info("Received authorization response custom event, incomingMessage={}, score={}, authorized={}",
               event.getIncomingMessage(), event.getScore(), event.getResponse());
    }

}
