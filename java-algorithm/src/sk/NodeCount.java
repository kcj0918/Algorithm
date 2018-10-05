package sk;

public class NodeCount {
    public static void main(String[] args) {
        int[] A = {1, 4, -1, 3, 2};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        boolean[] visit = new boolean[A.length];
        int length = 0;
        int nextIndex = 0;
        while (A[nextIndex] != -1 || !visit[nextIndex]) {
            if (A[nextIndex] != -1) {
                length++;
                visit[nextIndex] = true;
                nextIndex = A[nextIndex];
                if (A[nextIndex] == -1) {
                    length++;
                    break;
                }
                if (visit[nextIndex]) {
                    break;
                }
            } else {
                length++;
                break;
            }
        }
        return length;
    }
}
