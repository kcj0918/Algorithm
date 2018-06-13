package stack.stringCalculation;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int n = solution("13 DUP 4 POP 5 DUP + DUP + -");
        System.out.println(n);
    }

    static int solution(String S) {
        int result = 0;
        String[] exam;
        Stack<Integer> stack = new Stack();
        exam = S.split(" ");
        for (String s : exam) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else if (s.equals("DUP")) {
                int tmp = stack.peek();
                stack.push(tmp);
            } else if (s.equals("POP")) {
                if (stack.empty()) {
                    result = -1;
                    break;
                } else {
                    stack.pop();
                }
            } else if (s.equals("+")) {
                int tmp1;
                int tmp2;
                if (stack.empty()) {
                    result = -1;
                    break;
                } else {
                    tmp1 = stack.pop();
                    if (stack.empty()) {
                        result = -1;
                        break;
                    } else {
                        tmp2 = stack.pop();
                        stack.push(tmp1 + tmp2);
                    }
                }
            } else if (s.equals("-")) {
                int tmp1;
                int tmp2;
                if (stack.empty()) {
                    result = -1;
                    break;
                } else {
                    tmp1 = stack.pop();
                    if (stack.empty()) {
                        result = -1;
                        break;
                    } else {
                        tmp2 = stack.pop();
                        stack.push(tmp1 - tmp2);
                    }
                }
            }
        }
        if (!stack.empty()) {
            result = stack.peek();
        }
        return result;
    }

    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
