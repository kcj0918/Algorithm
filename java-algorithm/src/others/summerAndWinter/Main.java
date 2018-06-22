package others.summerAndWinter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] T = {5, -2, 3, 8, 6};
//        int[] T = {-5, -5, -5, -42, 6, 12};
//        int[] T = {-5, -5, -5, -42, 6, 6, 6, 12, 11};
//        int[] T = {2, 2, 2, 2, -42};
        System.out.println(solution(T));
    }

    static int solution(int[] T) {
        int result;
        int[] copy = Arrays.copyOf(T, T.length);
        Arrays.sort(copy);
        int minValue = copy[0];
        int maxValue = copy[copy.length - 1];
        if (T[0] == minValue || T[T.length - 1] == minValue) {
            return 1;
        } else {
            int minIndex = 0;
            int maxIndex = 0;
            int pointIndex;
            for (int i = 1; i < T.length; i++) {
                if (T[i] == minValue) {
                    minIndex = i;
                }
                if (T[i] == maxValue) {
                    maxIndex = i;
                }
            }
            if (minIndex < maxIndex) {
                pointIndex = maxIndex;
                while (true) {
                    int[] winterArray = Arrays.copyOfRange(T, 0, pointIndex);
                    int[] summerArray = Arrays.copyOfRange(T, pointIndex, T.length);
                    int winterMax = winterArray[0];
                    int summerMin = summerArray[0];
                    for (int i = 0; i < winterArray.length; i++) {
                        if (winterArray[i] > winterMax) {
                            winterMax = winterArray[i];
                        }
                    }
                    for (int i = 0; i < summerArray.length; i++) {
                        if (summerArray[i] < summerMin) {
                            summerMin = summerArray[i];
                        }
                    }
                    if (winterMax > summerMin) {
                        break;
                    } else {
                        pointIndex--;
                    }
                }
                result = pointIndex + 1;
            } else {
                pointIndex = minIndex;
                result = T.length - pointIndex;
            }
        }
        return result;
    }
}
