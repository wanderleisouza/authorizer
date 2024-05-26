package com.acme.authorizer.validator;

import com.acme.authorizer.IncomingMessage;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ValidatorService {

    private static final int UPPER_BOUND = 500;
    private static final int LOWER_BOUND = 200;

    public Integer getScore(IncomingMessage data) {
        var random = new Random();
        return random.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
    }

    public boolean isValid(IncomingMessage data) {
        return true;
    }

}
