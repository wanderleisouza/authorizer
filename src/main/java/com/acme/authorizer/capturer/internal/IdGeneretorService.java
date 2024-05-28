
package com.acme.authorizer.capturer.internal;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGeneretorService {

    public UUID generate() {
        return java.util.UUID.randomUUID();
    }

}
