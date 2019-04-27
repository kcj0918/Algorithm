package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Pangrams {
    public static void main(String[] args) {
        String input1 = "We promptly judged antique ivory buckles for the next prize";
        String input2 = "We promptly judged antique ivory buckles for the prize";
        System.out.println(solution(input1));
        System.out.println(solution(input2));
    }

    static String solution(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        s = s.toLowerCase();
        s = s.trim();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            myMap.put(arr[i], 0);
        }
        for (int i = 97; i < 123; i++) {
            if (!myMap.containsKey((char) i)) {
                return "not pangram";
            }
        }
        return "pangram";
    }
}
