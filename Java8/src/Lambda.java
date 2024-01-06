public class Lambda {
    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        voidMethodWithOneParam m1 = (input) -> System.out.println("hello" + input);
        m1.printInput("Asif");

    }

    private static void method2() {
        voidMethodWithTwoParam m1 = (a, b) -> a + b;
        System.out.println(m1.printInput(1, 2));

    }

}

interface voidMethodWithOneParam {
    public void printInput(String input);
}

interface voidMethodWithTwoParam {
    public int printInput(int a, int b);
}

//@FunctionalInterface
//interface ArthimaticOperations {
//
//    //only one abstract method
//    public int performOperation(int a, int b);
//
//    //private methods
//    private int addtwoNumbers(int a, int b) {
//        return a + b;
//    }
//
//    //default method
//    public default int addthreeNumbers(int a, int b, int c) {
//        return a + b + c;
//    }
//
//    //static method
//    public static int addTwoNumbers(int a, int b) {
//        return a + b ;
//    }
//}