package com.acme.authorizer.approver;

import com.acme.authorizer.capturer.IncomingMessage;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class IssuerResponseEvent extends ApplicationEvent {

    private IncomingMessage incomingMessage;
    private Integer score;
    private Boolean response;

    public IssuerResponseEvent(Object source, IncomingMessage incomingMessage, Integer score, Boolean response) {
        super(source);
        this.incomingMessage = incomingMessage;
        this.score = score;
        this.response = response;
    }

}
