package org.pc.util.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateTimeEx {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("H:m:s");
        LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Kolkata"));

        System.out.println("Indian Time: " + localTime.format(dateTimeFormat));

        System.out.println("LocalTime plus 2 hours: " + localTime.plusHours(2));
        System.out.println("Localtime plus 20 minutes: " + localTime.plusMinutes(20));

        LocalDate birthday = LocalDate.of(1986, 8, 27);
        System.out.println("Custom Date - Example Birthday: " + birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Zoned date time: " + zonedDateTime);
        System.out.println("Zone " + zonedDateTime.getZone());
        System.out.println(zonedDateTime.getDayOfWeek());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        System.out.println(zonedDateTime.plusHours(4).plusMinutes(30).format(dateTimeFormatter));


//      Parsing (String → Date/Time)
        String text = "25-11-2025 15:30";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(text, fmt);
        System.out.println("Date after parsing from String: "+localDateTime);


        //Difference between two dates
        Period period = Period.between(LocalDate.of(1986,8,27),LocalDate.now());
        System.out.println("Age: "+period.getYears());

        //Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

    //  Find next Monday from Today
        LocalDate nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Next Monday from Today: "+nextMonday);

        // TimeZone + Daylight saving time
        var z = ZonedDateTime.of(
                2025, 3, 30, 1, 30, 0, 0,
                ZoneId.of("Europe/Stockholm")); // DST jump forward

        var r = z.plusHours(2);
        System.out.println(r.getHour());

        var d = LocalDate.of(2021, 1, 1);
        var f = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println(d.format(f));

        var formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        var formattedDate = LocalDate.parse("11-25-25", formatter);
        System.out.println(formattedDate);

        var date = LocalDate.now().plus(Period.of(1, 6, 3));
        System.out.println("Period(1 year,6 months,3 days): "+date);

        System.out.println(Period.ofYears(2).plusMonths(3));

        // To-do: Investiigate about Instant class


    }
}
