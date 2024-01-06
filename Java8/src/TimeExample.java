import java.time.LocalTime;

public class TimeExample {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(12, 30, 10);
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        LocalTime parse = LocalTime.parse("12:30:10");
        System.out.println(parse);

        LocalTime now = LocalTime.now();
        System.out.println(now);

    }
}
