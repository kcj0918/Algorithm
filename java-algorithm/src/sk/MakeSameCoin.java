package sk;

public class MakeSameCoin {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1, 0, 0};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int zeroCount = 0;
        for (int value : A) {
            if (value == 0) {
                zeroCount++;
            }
        }
        return Math.min(zeroCount, A.length - zeroCount);
    }
}
