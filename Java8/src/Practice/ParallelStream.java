package Practice;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello ",
                "A", "S", "I", "F", " ", "B", "A", "S", "H", "A");

        System.out.println("without parallel stream");
        long startTime = System.currentTimeMillis();
        list.stream().forEach(System.out::print);
        long endTime = System.currentTimeMillis();
        System.out.println("without parallel stream Execution time: " + (endTime - startTime) + " milliseconds");

        System.out.println(" ");
        System.out.println("with parallel stream");
        long starttime = System.currentTimeMillis();
        list.parallelStream().forEach(System.out::print);
        long endtime = System.currentTimeMillis();
        System.out.println("with parallel stream Execution time: " + (endtime - starttime) + " milliseconds");

        list.stream().distinct().forEach(System.out::print);
        System.out.println();
        System.out.println("============================================================ ");

    }
}
