package others.strRemove;

import java.util.ArrayList;
import java.util.List;

public class strRemove {
    public static void main(String[] args) {
        String s1 = "ACCAABBC"; // "AC"
        String s2 = "ABCBBCBA"; // ""
        String s3 = "BABABA"; // "BABABA"
        System.out.println("result : " + Solution(s3));
    }

    static String Solution(String S) {
        String[] copyS = S.split("");
        List<String> arrayStr = new ArrayList<>();
        for (int i = 0; i < copyS.length; i++) {
            arrayStr.add(copyS[i]);
        }
        String result = "";

        int index = 0;
        int maxIndex = arrayStr.size() - 1;
        while (index != maxIndex && maxIndex >= 1) {
            if (arrayStr.get(index).equals(arrayStr.get(index + 1))) {
                if (index == 0) {
                    arrayStr.remove(index);
                    arrayStr.remove(index);
                    maxIndex -= 2;
                } else {
                    arrayStr.remove(index);
                    arrayStr.remove(index);
                    maxIndex -= 2;
                    index -= 1;
                }
            } else {
                index += 1;
            }
        }

        final int size = arrayStr.size();
        if (!arrayStr.isEmpty()) {
            for (int i = 0; i < size; i++) {
                result += arrayStr.get(i);
            }
        }
        return result;
    }
}
