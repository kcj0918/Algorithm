package zigzag;

import java.util.HashSet;
import java.util.Set;

public class BeautifulYear {
    public static void main(String[] args) {
        String P1 = "1987";
        String P2 = "2015";
        String result = solution(P1);
        System.out.println(result);
    }

    static String solution(String p) {
        String result = "";
        String currentNum = plusNum(p);
        while (result.equals("")) {
            Set<String> mySet = new HashSet<>();
            for (int i = 0; i < currentNum.length(); i++) {
                mySet.add(String.valueOf(currentNum.charAt(i)));
            }
            if (mySet.size() == currentNum.length()) {
                result = currentNum;
                break;
            }
            currentNum = plusNum(currentNum);
        }
        return result;
    }

    static String plusNum(String p) {
        int num = Integer.parseInt(p) + 1;
        return String.valueOf(num);
    }
}
