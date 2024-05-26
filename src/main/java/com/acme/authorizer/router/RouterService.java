package com.acme.authorizer.router;

import com.acme.authorizer.capturer.IncomingMessage;
import org.springframework.stereotype.Service;

@Service
public class RouterService {

    public String getRoute(IncomingMessage data) {
        return "some_fake_service_route";
    }

}
