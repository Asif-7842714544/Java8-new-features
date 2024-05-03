package Practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        String s = "Asifbasha";
        StringBuilder sb = new StringBuilder(s.substring(0, 2));
        sb.reverse().append(s.substring(2));
        System.out.println(sb);
//        return sb.toString();

        String a = "abcd", b = "cdabcdab";
        StringBuilder sb1 = new StringBuilder();
        sb1.repeat(a, 3);
        System.out.println(sb1);
        boolean contains = sb1.toString().contains(b);
        System.out.println(contains);

        int[] array = {1, 8, 9, 0, 2, 11, 0, 0, 3, 12, 4, 5, 6, 7, 0};

        int longest = array[0];
        for (int x : array) {
            longest = Math.max(longest, x);
        }
        System.out.println(longest);

        int[] arrayWithoutDuplicates = Arrays.stream(array)
                .distinct()
                .toArray();
        for (Integer x : arrayWithoutDuplicates) {
            System.out.print(x + ",");
        }

        int[] result = new int[array.length];
        int c = 0, i = 0;
        for (Integer x : array) {
            if (x != 0) {
                result[i] = x;
                i++;
            } else {
                c++;
            }
        }
//        for (int k : result) System.out.println(k);


    }

}
