import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        exclusiveTime(2, new ArrayList<String>(Arrays.asList("0:start:0", "1:start:3","1:end:6","0:end:10")));
    }

    public static List<Integer> exclusiveTime(int n, List<String> logs) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int prevTimestamp = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int funcId = Integer.parseInt(parts[0]);
            String op = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (op.equals("start")) {
                if (!stack.isEmpty()) {
                    result.set(stack.peek(), result.get(stack.peek()) + timestamp - prevTimestamp);
                }
                stack.push(funcId);
                prevTimestamp = timestamp;
            } else {
                int endedFunction = stack.pop();
                int executionTime = timestamp - prevTimestamp + 1;
                result.set(endedFunction, result.get(endedFunction) + executionTime);
                prevTimestamp = timestamp + 1;
            }
        }

        return result;
    }
}