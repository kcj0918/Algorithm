package others.seatReservation;

public class Main {
    public static void main(String[] args) {
//        int N = 2;
//        String S = "1A 2F 1C";
        int N = 1;
        String S = "";
        System.out.println(solution(N, S));
    }

    static int solution(int N, String S) {
        int result = 0;
        boolean[][] seat = new boolean[N][10];
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
        if (!S.equals(null) && !S.equals("")) {
            String[] reserved = S.split(" ");
            for (int i = 0; i < reserved.length; i++) {
                String firstStr = reserved[i].substring(0, 1);
                String secondStr = reserved[i].substring(1, 2);
                int firstIndex = Integer.parseInt(firstStr) - 1;
                for (int j = 0; j < array.length; j++) {
                    if (secondStr.equals(array[j])) {
                        int secondIndex = j;
                        seat[firstIndex][secondIndex] = true;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            while (true) {
                if (!seat[i][0] && !seat[i][1] && !seat[i][2]) {
                    result++;
                }
                if ((!seat[i][3] && !seat[i][4] && !seat[i][5]) || (!seat[i][4] && !seat[i][5] && !seat[i][6])) {
                    result++;
                }
                if (!seat[i][7] && !seat[i][8] && !seat[i][9]) {
                    result++;
                }
                break;
            }
        }
        return result;
    }
}
