package com.acme.authorizer.orchestrator;

import com.acme.authorizer.approver.IssuerIntegrationService;
import com.acme.authorizer.capturer.IncomingMessage;
import com.acme.authorizer.responder.OutcamingMessage;
import com.acme.authorizer.responder.ResponderService;
import com.acme.authorizer.router.RouterService;
import com.acme.authorizer.validator.ValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionAuthorizationService {

    private final ResponderService responderService;
    private final ValidatorService validatorService;
    private final RouterService routerService;
    private final IssuerIntegrationService issuerIntegrationService;

    public OutcamingMessage authorize(IncomingMessage incomingMessage) {
        log.info("route={} for txId={}", routerService.getRoute(incomingMessage), incomingMessage.transactionId());
        Integer score = null;
        if (validatorService.isValid(incomingMessage)) {
            score = validatorService.getScore(incomingMessage);
        }
        log.info("score={} for txId={}", score, incomingMessage.transactionId());

        String status = "NEGADO";
        if (issuerIntegrationService.getAuthorization(incomingMessage, score)) {
            status = "APROVADO";
        }
        log.info("status={} for txId={}", status, incomingMessage.transactionId());
        return responderService.format(incomingMessage, status);
    }

}
