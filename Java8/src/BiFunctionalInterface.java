import java.util.function.BinaryOperator;

public class BiFunctionalInterface {

    public static void main(String[] args) {
        BinaryOperator<String> appendAndConvert=(a,b)->(a+b).toUpperCase();
        System.out.println("Asif "+"Basha");
    }
}
