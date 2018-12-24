package nteck;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CorrectBracket {
    public static void main(String[] args) {
        String S1 = "3+[(5+1)-1]";
        String S2 = "3+([5+1])";
        String S3 = "3+{(5+1}";
        String S4 = "3+[{(5+1)-1}+3]";
        System.out.println(solution(S1));
        System.out.println(solution(S2));
        System.out.println(solution(S3));
        System.out.println(solution(S4));
    }

    static boolean solution(String S) {
        Map<String, Integer> gravity = new HashMap<>();
        gravity.put("[", 3);
        gravity.put("{", 2);
        gravity.put("(", 1);
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            String slice = S.substring(i, i + 1);
            if (slice.equals("[") || slice.equals("{") || slice.equals("(")) {
                if (stack.empty()) {
                    stack.push(slice);
                } else {
                    String preWord = stack.peek();
                    if (gravity.get(slice) >= gravity.get(preWord)) {
                        return false;
                    } else {
                        stack.push(slice);
                    }
                }
            } else if (slice.equals(")") || slice.equals("}") || slice.equals(")")) {
                if (stack.empty()) {
                    return false;
                }
                if (slice.equals("]")) {
                    if (!stack.pop().equals("[")) {
                        return false;
                    }
                } else if (slice.equals("}")) {
                    if (!stack.pop().equals("{")) {
                        return false;
                    }
                } else {
                    if (!stack.pop().equals("(")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
