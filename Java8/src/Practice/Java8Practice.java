package Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Java8Practice {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ank");
        stringList.add("sam");
        stringList.add("az");
        stringList.add("neh");
        stringList.add("ad");

        System.out.println("\n1. Use stream for filtering and display");
        stringList.stream().filter(a -> a.contains("a")).forEach(System.out::println);

        System.out.println("\n2. Use stream for filtering, sorting and display (in sorted manner - ASCENDING order )");
        stringList.stream().filter(a -> a.contains("a")).sorted().forEach(System.out::println);

        System.out.println("\n3. Use stream for filtering, sorting and display(in sorted manner - DESCENDING order)");
        stringList
                .stream()
                .filter(a -> a.contains("a"))
//                .sorted(Comparator.reverseOrder())
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        System.out.println("\n4. Use stream for filtering, UPPERCASE conevrsion, sorting and display");

        stringList.stream().filter(a -> a.contains("a")).sorted().forEach(a -> System.out.println(a.toUpperCase()));

        System.out.println("\n4. Counting number of string contains a");
        long count = stringList.stream().filter(a -> a.contains("a")).count();
        System.out.println(count);
    }
}
