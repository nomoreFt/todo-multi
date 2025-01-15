package com.nomoreft.todoapp.foundation.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
        // Utility class, no instantiation.
    }

    public static String formatDate(LocalDateTime date, String format) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatDate(LocalDateTime date) {
        return formatDate(date, DEFAULT_DATE_FORMAT);
    }

    public static LocalDateTime parseDate(String date, String format) {
        if (StringUtils.isNullOrEmpty(date)) {
            throw new IllegalArgumentException("Date string cannot be null or empty");
        }
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }
}