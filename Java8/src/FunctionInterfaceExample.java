import java.util.function.Function;

public class FunctionInterfaceExample {
    public static void main(String[] args) {
        Function<String,String> convertStr=i->i.toUpperCase();
        System.out.println(convertStr.apply("hello"));

        Function<String,String> sameValue=Function.identity();
        System.out.println(sameValue.apply("hello"));
    }

}
