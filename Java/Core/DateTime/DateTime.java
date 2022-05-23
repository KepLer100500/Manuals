import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;


class DateTime {
    private static void dateFormatTest() {
        System.out.println("===dateFormatTest===");
        Date date = new Date();

        DateFormat df;
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println(df.format(date));
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
        System.out.println(df.format(date));
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        System.out.println(df.format(date));
        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println(df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println(df.format(date));
        df = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.JAPAN);
        System.out.println(df.format(date));
        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
        System.out.println(df.format(date));
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println(df.format(date));

    }

    private static void simpleDateFormatTest() {
        System.out.println("===simpleDateFormatTest===");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        System.out.println(sdf.format(date));
    }

    private static void localDateTimeTest() {
        System.out.println("===localDateTimeTest===");
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        
        LinkedHashMap<String, Object> getMethods = new LinkedHashMap<>();
        getMethods.put("Day", localDateTime.getDayOfMonth());
        getMethods.put("Month", localDateTime.getMonth());
        getMethods.put("Year", localDateTime.getYear());
        getMethods.put("Hour", localDateTime.getHour());
        getMethods.put("Minute", localDateTime.getMinute());
        getMethods.put("Second", localDateTime.getSecond());
        getMethods.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void parseDataTime() {
        System.out.println("===parseDataTime===");
        String someDate = "21.04.2022 15:08:10";
        String pattern = "dd.MM.yyyy HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.parse(someDate, DateTimeFormatter.ofPattern(pattern));
        System.out.println("Given date: " + someDate);
        System.out.println("Parse date: " + localDateTime.format(DateTimeFormatter.ofPattern(pattern)));
    }

    private static void milliseconds() {
        System.out.println("===milliseconds===");
        Date date = new Date();
        System.out.println("Current date: " + date);
        System.out.println("Total millseconds: " + date.getTime());
        System.out.println("Convert milliseconds into date: " + new Date(date.getTime()));
    }

    public static void main(String[] args) {
        System.out.println("===Run===");
        dateFormatTest();
        simpleDateFormatTest();
        localDateTimeTest();
        parseDataTime();
        milliseconds();
    }
}