package com.example.olimpoapi.utils;

import java.util.Random;

public class IdGenerator {

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextInt() + 1);
    }
}
