package dp;

/*
    참고 url : http://blog.daum.net/rhaoslikesan/287
    Problem source :
 */
public class Knapsack {
    public static void main(String[] args) {
        final int[] weight = {3, 4, 1, 2, 3};
        final int[] value = {2, 3, 2, 3, 6};
        final int N = 5; // stuff number
        final int W = 10; // Max Weight
        System.out.println(solution(N, W, weight, value));
    }

    static int solution(int N, int W, int[] weight, int[] value) {
        int[] wt = new int[N + 1];
        for (int i = 1; i < wt.length; i++) {
            wt[i] = weight[i - 1];
        }
        int[] val = new int[N + 1];
        for (int i = 1; i < val.length; i++) {
            val[i] = value[i - 1];
        }
        int[][] V = new int[N+1][W+1];
        return knapsack(N, W, wt, val, V);
    }

    static int knapsack(int N, int W, int[] w, int[] v, int[][] result) {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if ((w[i] <= j) && (result[i - 1][j] < v[i] + result[i - 1][j - w[i]])) {
                    result[i][j] = v[i] + result[i - 1][j - w[i]];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[N][W];
    }
}
