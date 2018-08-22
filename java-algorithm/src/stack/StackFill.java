package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackFill {
    public static void main(String... args) {
        List<Stack<Integer>> stackList = doDo();
        for (Stack<Integer> stack : stackList) {
            for (Integer element : stack) {
                System.out.print(element.toString() + " ");
            }
            System.out.println();
        }
    }

    public static List<Stack<Integer>> doDo() {
        final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);
        List<Stack<Integer>> result = new ArrayList<>();
        Stack<Integer> myStack = new Stack<>();
        int size = elements.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (sum + elements.get(i) <= 20) {
                sum += elements.get(i);
                myStack.push(elements.get(i));
            } else {
                result.add(myStack);
                sum = 0;
                myStack = new Stack<>();
                myStack.push(elements.get(i));
                sum += elements.get(i);
            }
        }
        result.add(myStack);
        return result;
    }
}
