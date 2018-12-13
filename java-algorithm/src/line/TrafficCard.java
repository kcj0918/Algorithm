package line;

public class TrafficCard {
    public static void main(String[] args) {
        int[] A = {11, 128, 15, 111, 59, 31, 70, 102, 50, 172, 88, 56, 40, 41, 40};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int currentMoney = 20000;
        int totalUsedMoney = 0;
        for (int i = 0; i < A.length; i++) {
            int oneUsedMoney;
            if (A[i] < 4 || A[i] > 178) {
                break;
            } else {
                if (A[i] > 40) {
                    oneUsedMoney = 720;
                    double distance = A[i] - 40;
                    double multiply = distance / 8;
                    double remain = distance % 8;
                    if (remain != 0) {
                        multiply++;
                    }
                    oneUsedMoney += (int) multiply * 80;
                } else {
                    oneUsedMoney = 720;
                }
            }
            totalUsedMoney += oneUsedMoney;
        }
        return currentMoney - totalUsedMoney;
    }
}
