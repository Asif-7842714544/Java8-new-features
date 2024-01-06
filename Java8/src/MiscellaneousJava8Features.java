import java.util.*;

public class MiscellaneousJava8Features {
    public static void main(String[] args) {
        replaceall();
        listsort();
        splititerator();
        forEachRemaining();
        stringjoint();
        arraymethods();
        Objectnullcheck();
    }

    //String replaceall
    private static void replaceall() {
        System.out.println("===========String Replace All Example===========");
        List<String> list = new ArrayList<>();
        list.add("Hii");
        list.add("Hello");
        list.add("Asif");
        list.add("Arshad");
        list.add("kalam");
        System.out.println("Before list :: " + list);
        list.replaceAll(i -> i.toUpperCase());
        System.out.println("After replaceall ::" + list);
    }

    //listsort
    private static void listsort() {
        System.out.println("===========List Sort Example===========");
        List<String> list = new ArrayList<>();
        list.add("Hii");
        list.add("Hello");
        list.add("Asif");
        list.add("Arshad");
        list.add("kalam");
        System.out.println("Before list :: " + list);
        list.sort(String::compareTo);
        System.out.println("After sort ::" + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("List reverse ::" + list);
    }

    //SplitIterator
    private static void splititerator() {
        System.out.println("===========Split Iterator Example===========");
        List<String> list = new ArrayList<>();
        list.add("Hii");
        list.add("Hello");
        list.add("Asif");
        list.add("Arshad");
        list.add("kalam");
        ArrayList<String> list2 = new ArrayList<>();
        Spliterator<String> splitr = list.spliterator();
        while (splitr.tryAdvance((i) -> list2.add(i.toUpperCase()))) ;
        Spliterator<String> spliterator = list2.spliterator();
        while (spliterator.tryAdvance(i -> System.out.println(i))) ;
    }

    //forEachRemaining
    private static void forEachRemaining() {
        System.out.println("===========ForEach Remaining Example===========");
        List<String> list = new ArrayList<String>();
        list.add("Hii");
        list.add("Hello");
        list.add("Asif");
        list.add("Arshad");
        list.iterator().forEachRemaining(i-> System.out.println(i));
    }
    //StringJoint Example
    private static void stringjoint() {
        System.out.println("===========String Joint Example===========");
        String join = String.join(",", "hi", "hello", "asif", "arshad", "kalam");
        System.out.println(join);
    }

    //Arraymethods
    private static void arraymethods() {
        System.out.println("===========Array Methods Example===========");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.setAll(arr, i -> arr[i] * arr[i]);
        System.out.println(Arrays.toString(arr));
        System.out.println("===============");
        int[] unsortedarr={7,9,3,22,1,10,4};
        Arrays.parallelSort(unsortedarr);
        System.out.println(Arrays.toString(unsortedarr));
        System.out.println("=============");
        Arrays.parallelPrefix(arr, (a, b) -> a + b);
        System.out.println(Arrays.toString(arr));
    }

    //Objectnullcheck

    private static void Objectnullcheck(){
        System.out.println("===========Object Null Check Example===========");
        List<Employee> employeeList=Arrays.asList(new Employee(1, "John", 30),new Employee(2, "Mike", 25),null,null,new Employee(3, "Jane", 35));
        long nullcount = employeeList.stream().filter(Objects::isNull).count();
        System.out.println(nullcount);
        long Nonnullcount = employeeList.stream().filter(Objects::nonNull).count();
        System.out.println(Nonnullcount);
    }



}
