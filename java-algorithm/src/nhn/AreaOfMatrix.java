package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    NHN Ent Mock Test
 */
public class AreaOfMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] matrix = new int[size][size];
        visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visit[i][j] == false && matrix[i][j] == 1) {
                    visitMatrix(matrix, i, j);
                    myList.add(visitCount);
                    visitCount = 0;
                }
            }
        }

        if (myList.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(myList.size());
            Collections.sort(myList);
            for (int result : myList) {
                System.out.print(result + " ");
            }
        }
    }

    static void visitMatrix(int[][] matrix, int n, int m) {
        visit[n][m] = true;
        visitCount = visitCount + 1;
        if (m + 1 < matrix.length && matrix[n][m + 1] == 1 && visit[n][m + 1] == false) {
            visitMatrix(matrix, n, m + 1);
        }
        if (n + 1 < matrix.length && matrix[n + 1][m] == 1 && visit[n + 1][m] == false) {
            visitMatrix(matrix, n + 1, m);
        }
    }

    static int visitCount = 0;
    static boolean[][] visit;
    static List<Integer> myList = new ArrayList<>();
}
