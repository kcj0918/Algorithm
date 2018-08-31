package others.shortestPath;

public class ShortestPath {
    public static void main(String[] args) {
        int A = 4;
        int B = 5;
        System.out.println(solution(A, B));
    }

    static int solution(int row, int column) {
        final int rowSize = row + 1;
        final int columnSize = column + 1;
        int[][] arr = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[row][column];
    }
}
