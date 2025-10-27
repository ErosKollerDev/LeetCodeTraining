package com.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // Modern Date/Time API (Java 8+)
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // Parsing
        LocalDateTime parsedDateTime = LocalDateTime.parse("2023-01-01 15:30:00", formatter);

        // Calculations
        LocalDateTime futureDateTime = dateTime.plusDays(1).plusHours(2);
        LocalDateTime pastDateTime = dateTime.minusMonths(1);
        long daysBetween = ChronoUnit.DAYS.between(pastDateTime, futureDateTime);

        // Legacy Date API
        Date legacyDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        // Output
        System.out.println("Current date: " + date);
        System.out.println("Current time: " + time);
        System.out.println("Current date-time: " + dateTime);
        System.out.println("Formatted date-time: " + formattedDateTime);
        System.out.println("Future date-time: " + futureDateTime);
        System.out.println("Days between dates: " + daysBetween);
        System.out.println("Legacy date: " + legacyDate);
        System.out.println("Calendar date: " + calendar.getTime());


        LocalDateTime birth = LocalDateTime.parse("1976-10-14 15:30:00", formatter);
        System.out.printf("Age: %d years%n", ChronoUnit.YEARS.between(birth, LocalDateTime.now()));
        System.out.printf("Days %d%n", ChronoUnit.DAYS.between(birth, LocalDateTime.now()) );
        LocalDateTime rightNowInBrazil = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.printf("Right now in Brazil: %s%n", rightNowInBrazil.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
