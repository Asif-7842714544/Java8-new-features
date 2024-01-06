@FunctionalInterface
public interface ArthematicOperations {
    //only one abstract method
    public int performOperation(int a, int b);

    //private methods
    private int addtwoNumbers(int a, int b) {
        return a + b;
    }

    //default method
    public default int addthreeNumbers(int a, int b, int c) {
        return a + b + c;
    }

    //static method
    public static int addTwoNumbers(int a, int b) {
        return a + b ;
    }
}
