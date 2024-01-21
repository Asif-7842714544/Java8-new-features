package Practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98),
                new Student(11, "Asif", "Basha", 28, "male", "Computer Engineering", 2016, "Delhi", 7)
        );

        System.out.println("List of students whose name starts with letter A : ");
        List<Student> listStudentNames = list.stream().filter(i -> i.getFirstName().startsWith("A")).collect(Collectors.toList());
        listStudentNames.stream().forEach(i -> System.out.println(i.getFirstName()));
        System.out.println("============================================================ ");
        System.out.println("Students grouped by the department names : ");
        Map<String, List<Student>> collect =
                list.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
        System.out.println(collect);
        System.out.println("Max age of student : ");
        Optional<Student> maxAgeStudent = list.stream().max(Comparator.comparing(Student::getAge));
        if (maxAgeStudent.isPresent()) System.out.println(maxAgeStudent.get().getFirstName());

        Student max = Collections.max(list, Comparator.comparing(Student::getAge));

        System.out.println(max.getFirstName());
        System.out.println("================================================================");
        System.out.println("All distinct department names : ");
        list.stream().map(x -> x.getDepartmentName()).distinct().forEach(x -> System.out.println(x));
        System.out.println("================================================================");
        System.out.println("Student count in each department : ");
        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        System.out.println(collect1);
        System.out.println("================================================================");
        System.out.println("List of students whose age is greater than 30 : ");
        list.stream().filter(x -> x.getAge() >= 30).forEach(x -> System.out.println(x.getFirstName()));
        System.out.println("================================================================");
        System.out.println("List of students whose rank is between 50 and 100 : ");
        list.stream().filter(x -> x.getRank() >= 50 && x.getRank() <= 100).forEach(x -> System.out.println(x.getFirstName()));
        System.out.println("================================================================");
        System.out.println("Average age of male and female students : ");
        Map<String, Double> collect2 = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(collect2);
        System.out.println("================================================================");
        System.out.println("Department having maximum number of students : ");
        Map<String, Long> collect3 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        Optional<Map.Entry<String, Long>> max1 = collect3.entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(max1.get());
        System.out.println("================================================================");
        System.out.println("List of students who stays in Delhi and sort them by their names : ");
        list.stream().filter(x -> x.getCity().equalsIgnoreCase("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).forEach(x -> System.out.println(x.getFirstName()));
        System.out.println("================================================================");
        System.out.println("Average rank in all departments  : ");
        Map<String, Double> collect4 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
        System.out.println(collect4);
        System.out.println("================================================================");
        System.out.println("Highest rank in each department  : ");
        Map<String, Optional<Student>> collect5 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(collect5);
        System.out.println("================================================================");
        System.out.println("Second highest rank student  : ");
        Student student = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        System.out.println(student.getFirstName());

    }
}
