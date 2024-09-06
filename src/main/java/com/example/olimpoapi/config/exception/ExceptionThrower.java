package com.example.olimpoapi.config.exception;

import com.example.olimpoapi.exception.CustomBadRequestException;
import com.example.olimpoapi.exception.CustomGenericException;
import com.example.olimpoapi.exception.CustomNotFoundException;
import com.example.olimpoapi.exception.CustomUnauthorizedException;
import com.example.olimpoapi.exception.CustomNullPointerException;
public class ExceptionThrower {
    private ExceptionThrower() {
    }
    public static void throwNotFoundException(String message) {
        throw new CustomNotFoundException(message);
    }

    public static void throwBadRequestException(String message) {
        throw new CustomBadRequestException(message);
    }

    public static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void throwUnauthorizedException(String message) {
        throw new CustomUnauthorizedException(message);
    }

    public static void throwNullPointerException(String message) {
        throw new CustomNullPointerException(message);
    }

    public static void throwGenericException(String message) {
        throw new CustomGenericException(message);
    }
}
