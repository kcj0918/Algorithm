package sk;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    public static void main(String[] args) {
        String S1 = "We test coders.     Give us a try?";
        String S2 = "Forget  CVs..Save time . x x";
        int result = solution(S1);
        System.out.println(result);
        result = solution(S2);
        System.out.println(result);
    }

    static int solution(String s) {
        String[] arr = s.split("[.?!]");
        List<Integer> result = new ArrayList<>();
        for (String v : arr) {
            int count = 0;
            String[] word = v.split(" ");
            for (String v1 : word) {
                if (v1.length() != 0) {
                    count++;
                }
            }
            result.add(count);
        }
        int max = result.get(0);
        if (result.size() == 0) {
            return 0;
        }
        for (int v : result) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}
