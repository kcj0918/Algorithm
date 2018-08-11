package others.strManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class strManipulation {
    public static void main(String[] args) {
        String S1 = "her";
        String T1 = "here";
        String S2 = "mouse";
        String T2 = "mose";
        String S3 = "sub";
        String T3 = "bus";
        String S4 = "add";
        String T4 = "o";
        String S5 = "gone";
        String T5 = "gone";
        System.out.println(Solution(S1, T1));
        System.out.println(Solution(S2, T2));
        System.out.println(Solution(S3, T3));
        System.out.println(Solution(S4, T4));
        System.out.println(Solution(S5, T5));
    }

    static String Solution(String S, String T) {
        String result;
        final String[] arrS = S.split("");
        final String[] arrT = T.split("");
        List<String> arrayS = new ArrayList<>();
        List<String> arrayT = new ArrayList<>();
        for (String word : arrS) {
            arrayS.add(word);
        }
        for (String word : arrT) {
            arrayT.add(word);
        }

        if (S.length() - T.length() == -1) {
            String resultS = "";
            String insertWord = "";
            for (int i = 0; i < arrS.length; i++) {
                if (!arrayS.get(i).equals(arrayT.get(i))) {
                    insertWord = arrayT.get(i);
                    arrayS.add(i, insertWord);
                    break;
                }
            }
            if (arrayS.size() != T.length()) {
                insertWord = arrayT.get(T.length() - 1);
                arrayS.add(insertWord);
            }
            for (int i = 0; i < T.length(); i++) {
                resultS = resultS.concat(arrayS.get(i));
            }
            if (resultS.equals(T)) {
                result = "INSERT " + insertWord;
            } else {
                result = "IMPOSSIBLE";
            }
        } else if (S.length() - T.length() == 1) {
            String resultS = "";
            String removeWord = "";
            for (int i = 0; i < arrT.length; i++) {
                if (!arrayS.get(i).equals(arrayT.get(i))) {
                    removeWord = arrayS.get(i);
                    arrayS.remove(i);
                    break;
                }
            }
            if (arrayS.size() != arrayT.size()) {
                removeWord = arrayS.get(arrS.length-1);
                arrayS.remove(arrS.length-1);
            }
            for (int i = 0; i < T.length(); i++) {
                resultS = resultS.concat(arrayS.get(i));
            }
            if (resultS.equals(T)) {
                result = "REMOVE " + removeWord;
            } else {
                result = "IMPOSSIBLE";
            }
        } else if (S.length() == T.length()) {
            if (S.equals(T)) {
                result = "NOTHING";
            } else {
                String resultS = "";
                List<Integer> index = new ArrayList<>();
                for (int i = 0; i < arrT.length; i++) {
                    if (!arrayS.get(i).equals(arrayT.get(i)) && index.size() != 2) {
                        index.add(i);
                    }
                    if(index.size() == 2) {
                        break;
                    }
                }
                Collections.swap(arrayS, index.get(0), index.get(1));
                for (int i = 0; i < T.length(); i++) {
                    resultS = resultS.concat(arrayS.get(i));
                }
                if (resultS.equals(T)) {
                    result = "SWAP " + arrayS.get(index.get(1)) + " " + arrayS.get(index.get(0));
                } else {
                    result = "IMPOSSIBLE";
                }
            }
        } else {
            result = "IMPOSSIBLE";
        }
        return result;
    }
}
