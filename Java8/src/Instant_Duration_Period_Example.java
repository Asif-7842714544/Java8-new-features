import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class Instant_Duration_Period_Example {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(6);
        System.out.println(instant);
        System.out.println(Instant.ofEpochSecond(4,1_000));
        System.out.println(Instant.now());

        System.out.println(Duration.between(instant,Instant.now()));

        LocalDate localDate = LocalDate.of(2020, 1, 1);
        LocalDate localDate1 = LocalDate.of(2024, 11, 22);
        Period between = Period.between(localDate, localDate1);
        System.out.println(between);
    }
}
