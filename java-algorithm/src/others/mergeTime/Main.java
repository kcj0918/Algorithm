package others.mergeTime;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //   int[] A = {100, 250, 1000};
        int[] A = {100, 400, 300, 200};
//        int[] A = {100, 200, 300, 4000};
//        int[] A= {100};
//        System.out.println(solution(A));
        System.out.println(solution(A));
    }
    static int solution(int[] A) {
        int result = 0;
        int preResult = 0;
        Arrays.sort(A);
        if(A.length < 2) {
            return 0;
        }
        for(int i = 0; i < A.length; i++) {
            if(i == 0) {
                preResult = A[0] + A[1];
                result = result + preResult;
                i++;
            } else {
                preResult = preResult + A[i];
                result = result + preResult;
            }
        }
        return result;
    }
}
