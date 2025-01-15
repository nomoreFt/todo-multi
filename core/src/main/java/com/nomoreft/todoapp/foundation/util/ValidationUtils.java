package com.nomoreft.todoapp.foundation.util;

import java.util.Collection;

public class ValidationUtils {

    private ValidationUtils() {
        // Utility class, no instantiation.
    }

    public static void validateNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }
}