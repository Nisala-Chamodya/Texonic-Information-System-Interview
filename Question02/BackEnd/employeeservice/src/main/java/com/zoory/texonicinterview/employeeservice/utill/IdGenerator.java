package com.zoory.texonicinterview.employeeservice.utill;

import java.util.UUID;

public class IdGenerator {
    private String generateRandomStringID(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1");
        }
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString().replace("-", "");

        return "Emp-"+randomUUIDString.substring(0, length);
    }
    public String generateID(){
        int desiredLength = 6;
        return generateRandomStringID(desiredLength);
    }
}
