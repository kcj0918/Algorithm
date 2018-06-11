package others.oneChangeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 7, 5, 5, 9}; // result : true
        int[] B = {1, 2, 6, 2, 3}; // result : false
        int[] C = {1, 2, 3}; // result : true
        boolean result = solution(A);
        System.out.println(result);
    }
    static boolean solution(int[] A) {
        boolean result;
        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        int count = 0;

        for(int i=0; i<A.length; i++) {
            if(A[i] != B[i]) {
                count++;
            }
        }
        if(count > 2) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}
