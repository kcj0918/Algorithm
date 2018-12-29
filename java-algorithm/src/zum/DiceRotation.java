package zum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceRotation {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3}; // return 2
        int[] A2 = {1, 1, 6}; // return 2 {2,2,4}
        int[] A3 = {1, 6, 2, 3}; // return 3

        int result = solution(A2);
        System.out.println(result);
    }

    static int solution(int[] A) {
        List<Integer> result = new ArrayList<>();
        int length = A.length;
        int makeIndex = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(1, 6);
        myMap.put(2, 5);
        myMap.put(3, 4);
        myMap.put(4, 3);
        myMap.put(5, 2);
        myMap.put(6, 1);

        for (int i = 0; i < length; i++) {
            int sumMoveCount = 0;
            for (int j = 0; j < length; j++) {
                int moveCount = 0;
                if (j != makeIndex) {
                    if (A[j] == A[makeIndex]) {
                        continue;
                    } else if (myMap.get(A[j]) == A[makeIndex]) {
                        moveCount += 2;
                    } else {
                        moveCount += 1;
                    }
                    sumMoveCount += moveCount;
                }
            }
            result.add(sumMoveCount);
            makeIndex += 1;
        }
        int minValue = result.get(0);
        for (int value : result) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }
}
