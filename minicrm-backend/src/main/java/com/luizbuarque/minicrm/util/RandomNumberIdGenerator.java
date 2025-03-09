package com.luizbuarque.minicrm.util;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import java.io.Serializable;
import java.util.Random;

public class RandomNumberIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Generate a random 5-digit number (from 10000 to 99999)
        Random random = new Random();
        int randomId = 10000 + random.nextInt(90000);
        // Optionally, add collision checking logic here
        return (long) randomId; // Cast to Long if your id field is Long
    }
}