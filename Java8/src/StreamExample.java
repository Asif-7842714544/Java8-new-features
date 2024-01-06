import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hii");
        list.add("Hello");
        list.add("Asif");
        list.add("Asif");
        list.add("ABC");
        list.add("Arshad");

        list.stream().forEach(System.out::println);
        System.out.println("==========");
        list.parallelStream().forEach(System.out::println);
        System.out.println("==========");
        System.out.println(list.stream().count());
        System.out.println("============");
        Stream.of(list).forEach(System.out::println);
        System.out.println("============");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Asif", 25));
        employeeList.add(new Employee(2, "Arshad", 30));
        employeeList.add(new Employee(3, "kalam", 40));

        employeeList.stream().map(i -> i.getName().toUpperCase()).forEach(System.out::println);
        System.out.println("==========");
        employeeList.stream().filter(i -> i.getAge() > 30).forEach(System.out::println);
        System.out.println("==========");


        //Flatmap Example


        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " +
                listOfListofInts);

        // Using flatMap for transformating and flattening.
        List<Integer> listofInts = listOfListofInts.stream()
                .flatMap(i -> i.stream())
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening is : " +
                listofInts);


        //Limit Example
        System.out.println("===========Skip and Limit Example===========");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13);

        numbers.stream().skip(5).limit(5).forEach(System.out::println);
        System.out.println("=================");
        numbers.stream().skip(5).forEach(System.out::println);

        //Reduce Example

        System.out.println("===========Reduce Example===========");
        System.out.println(numbers.stream().reduce(0, (a, b) -> a + b));

        //collect Example
        System.out.println("===========Collect Example===========");
        Long count = list.stream().filter(i -> i.startsWith("A")).collect(Collectors.counting());
        System.out.println(count);
        list.stream().filter(i -> i.startsWith("A")).collect(Collectors.toSet()).forEach(System.out::println);

        //collectingAndThen example
        System.out.println("===========Collecting And Then Example===========");
        Employee collect = employeeList
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Employee::getAge)), Optional::get));
        System.out.println(collect.getName());

        //GroupingBy example
        System.out.println("===========Grouping By Example===========");
        List<Product> productList = Arrays.asList(
                new Product(10, "Apple"),
                new Product(10, "Banana"),
                new Product(30, "Orange"),
                new Product(30, "Grapes"),
                new Product(50, "Pineapple"),
                new Product(50, "Strawberry"));

        Map<Integer, List<Product>> collect1 = productList
                .stream()
                .collect(Collectors.groupingBy(p -> p.getPrice()));
        System.out.println(collect1);

        //partitioningBy  example
        System.out.println("===========Partitioning By Example===========");
        Map<Boolean, List<Product>> collect2 = productList.stream().collect(Collectors.partitioningBy(p -> p.getPrice() >= 30));
        System.out.println(collect2);


        //Practice
        System.out.println("===========Practice===========");
        List<Integer> list1 = Arrays.asList(14, 18, 19, 20, 55, 77, 87, 98, 99, 55, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13);
        list1.stream().filter(i -> i % 2 == 0).map(i -> i * i).sorted().forEach(System.out::println);
    }

}

class Employee {
    int id;
    String name;
    int age;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class Product {
    int price;
    String productName;

    public Product(int price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}