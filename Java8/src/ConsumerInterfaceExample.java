import java.util.function.Consumer;

public class ConsumerInterfaceExample {

    public static void main(String[] args) {
        Consumer<String> convertAndDisplay=i-> System.out.println(i.toUpperCase());
        convertAndDisplay.accept("hello");
    }

}
