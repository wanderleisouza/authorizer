package com.acme.authorizer.capturer;

import com.acme.authorizer.IncomingMessage;
import com.acme.authorizer.capturer.internal.IdGeneretorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CaptureService {

    private final IdGeneretorService idGeneretorService;

    public IncomingMessage initializeTransaction(IncomingMessage data) {
        var txId = idGeneretorService.generate();
        return new IncomingMessage(data.csrf(), data.acquirerId(), txId, data.cardHolder(), data.cardPAN(), data.score(), Instant.now().getEpochSecond());
    }

}
