package others.numberOneSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[] numberList = {31, 15, 7, 3, 2};
        int[] numberList = {2, 3, 4, 7, 15, 31};
//        int[] numberList = {1, 2, 3, 4, 5};
        List<Integer> result = solution(numberList);
        for (Integer num : result) {
            System.out.println(num);
        }
    }

    static List<Integer> solution(int[] num) {
        List<Integer> result = new ArrayList<>();
        for (int number : num) {
            result.add(number);
        }
        result.sort(Comparator.comparing(Integer::bitCount));
        return result;
    }
}
