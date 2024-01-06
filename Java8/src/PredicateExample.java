import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        System.out.println(isEven.test(101));

        Predicate<Integer> isgreaterthan50 = i -> i > 50;

        System.out.println(isgreaterthan50.and(isEven).test(102));

        List<Integer> list = Arrays.asList(1, 2,2, 3, 4, 5, 6, 7, 8);
        List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> collect1 = list.stream().filter(n -> n % 2 == 0).toList();
        long count = list.stream().filter(n -> n % 2 == 0).count();
        List<Integer> list1 = list.stream().filter(n -> n % 2 == 0).distinct().toList();

        Stream<Integer> skip = list.stream().filter(n -> n % 2 == 0).skip(2);
        System.out.println(skip.toList());
        System.out.println(count);
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(list1);

    }
}
