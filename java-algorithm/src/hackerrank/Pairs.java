package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Pairs {
    public static void main(String[] args) {
        /*
            Problem URL : https://www.hackerrank.com/challenges/pairs/problem
         */
        int[] array = {1, 5, 3, 4, 2};
        System.out.println(solution(array, 2));
    }

    static int solution(int[] array, int n) {
        Map<Integer, Integer> myMap = new HashMap<>(); // value, index
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            myMap.put(array[i], i);
        }
        for(int i=0; i<array.length; i++) {
            if(myMap.containsKey(array[i] + 2)) {
                count++;
            }
            if(myMap.containsKey(array[i] - 2)) {
                count++;
            }
        }
        return count/2;
    }
}
