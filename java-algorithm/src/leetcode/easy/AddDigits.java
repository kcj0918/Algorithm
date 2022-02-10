package leetcode.easy;

public class AddDigits {
    /**
     * https://leetcode.com/problems/add-digits/
     * 3 ms, faster than 22.87% of Java online submissions for Add Digits.
     */
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    static int addDigits(int num) {
        int result = num;

        while (String.valueOf(result).length() > 1) {
            char[] numArr = String.valueOf(result).toCharArray();
            result = 0;
            for (char ch : numArr) {
                result += Character.getNumericValue(ch);
            }
        }

        return result;
    }
}
