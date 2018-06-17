package others.minimumTriangle;

public class Main {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20}; // result : 23
//        int[] A = {5, 10, 18, 7, 8, 3}; // result : 15
//        int[] A = {10, 20, 30}; // result : -1
        int result = solution(A);
        System.out.println(result);
    }

    static int solution(int[] A) {
        boolean checkTriangle = false;
        int minSum = 0;
        int sum;
        for (int i = 0; i <= A.length - 3; i++) {
            for (int j = i + 1; j <= A.length - 2; j++) {
                for (int k = j + 1; k <= A.length - 1; k++) {
                    if ((A[i] + A[j]) > A[k] && (A[i] + A[k]) > A[j] && (A[j] + A[k]) > A[i]) {
                        checkTriangle = true;
                        sum = A[i] + A[j] + A[k];
                        if (sum < minSum || minSum == 0) {
                            minSum = sum;
                        }
                    }
                }
            }
        }
        if (checkTriangle) {
            return minSum;
        } else {
            return -1;
        }
    }
}
