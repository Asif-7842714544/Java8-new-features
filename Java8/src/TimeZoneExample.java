import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import static java.time.ZoneId.*;

public class TimeZoneExample {
    public static void main(String[] args) {
//        HijrahDate islamicDate = HijrahDate.now();
//        System.out.println(islamicDate);
//        System.out.println(islamicDate.getEra());

        Set<String> zones = getAvailableZoneIds();
        zones.stream().sorted().forEach(System.out::println);
        System.out.println(zones.stream().count());

        ZoneId zoneId = of("Asia/Kolkata");
        System.out.println(zoneId);
        ZonedDateTime indiaTime = ZonedDateTime.now(zoneId);
        System.out.println(indiaTime);
    }
}
