package others.strCombination;

public class Main {
    public static void main(String[] args) {
        String result = solution(1, 4);
        System.out.println(result);
    }

    static String solution(int A, int B) {
        String result = "";
        int aCount = A;
        int bCount = B;
        while (true) {
            if (aCount == 0 && bCount == 0) {
                break;
            } else {
                if (aCount >= bCount) {
                    result = result.concat("a");
                    aCount--;
                    if (result.matches("aaa")) {
                        result = result.replace("aaa", "aab");
                        bCount--;
                        aCount++;
                    }
                } else {
                    result = result.concat("b");
                    bCount--;
                    if (result.matches("bbb")) {
                        result = result.replace("bbb", "bba");
                        aCount--;
                        bCount++;
                    }
                }
            }
        }
        return result;
    }
}
