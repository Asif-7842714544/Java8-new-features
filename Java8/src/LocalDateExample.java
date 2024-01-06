import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateExample {

    public static void main(String[] args) {
        System.out.println("hiiii");
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate date = LocalDate.of(2024, 01, 03);
        System.out.println(date);
        int year = date.getYear();
        System.out.println(year);
        Month month = date.getMonth();
        System.out.println(month);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
        int lengthOfMonth = date.lengthOfMonth();
        System.out.println(lengthOfMonth);
        int lengthOfYear = date.lengthOfYear();
        System.out.println(lengthOfYear);
        boolean leapYear = date.isLeapYear();
        System.out.println(leapYear);

        int year1 = date.get(ChronoField.YEAR);
        System.out.println(year1);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month1);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day1);
        LocalDate parse = LocalDate.parse("2024-01-03");
        System.out.println(parse);

    }


}
