package dfs.gridCell;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] gird = new int[n][m];
        boolean visit[][] = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                gird[i][j] = scan.nextInt();
            }
        }
        System.out.println();
    }
    static int DFS(int[][] gird) {
        return 0;
    }
}
