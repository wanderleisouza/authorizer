package com.acme.authorizer.capturer;

import com.acme.authorizer.orchestrator.TransactionAuthorizationService;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CaptureSocketController {

    private final CaptureService captureService;
    private final TransactionAuthorizationService transactionAuthorizationService;

    public CaptureSocketController(SocketIOServer server,
                                   CaptureService captureService, TransactionAuthorizationService transactionAuthorizationService) {
        this.captureService = captureService;
        this.transactionAuthorizationService = transactionAuthorizationService;
        server.addEventListener("post_data", IncomingMessage.class, onData());
    }

    private DataListener<IncomingMessage> onData() {
        return (senderClient, receivedData, ackSender) -> {
            log.info("server received payload={}", receivedData);
            var initializedData = captureService.initializeTransaction(receivedData);
            var response = transactionAuthorizationService.authorize(initializedData);
            senderClient.getNamespace().getBroadcastOperations().sendEvent("get_data", response);
            log.info("client received payload={}", response);
        };
    }
    
}