package zigzag;

public class StringNumber {
    public static void main(String[] args) {
        String S = "ab2v9bc13j5jf4jv";
        int result = solution(S);
        System.out.println(result);
    }

    static int solution(String S) {
        String[] number = S.split("[^0-9]");
        int result = 0;
        for (String v : number) {
            if (!v.equals("") && Integer.parseInt(v) % 2 == 1) {
                int num = Integer.parseInt(v);
                result += num * num;
            }
        }
        return result;
    }
}
