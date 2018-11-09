package nhn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelSearch {
    public static void main(String[] args) {
        String[] words = {"toasoaet", "standard", "bank", "display", "book"};
        int[] result = solution(words);
        for(int v : result) {
            System.out.println(v);
        }
    }

    static int[] solution(String[] words) {
        int[] result = new int[2];
        int caseOneCount = 0;
        int caseTwoCount = 0;
        Pattern pattern = Pattern.compile("[aeuio]{2,}");
        Pattern pattern1 = Pattern.compile("[^aeuio]{3,}");
        for(int i = 0; i<words.length; i++) {
            Matcher matcher = pattern.matcher(words[i]);
            int strMaxSize = 0;
            while(matcher.find()) {
                int size = matcher.group(0).length();
                if(size > strMaxSize) {
                    strMaxSize = size;
                }
            }
            if(strMaxSize == 2) {
                caseOneCount++;
            }
            matcher = pattern1.matcher(words[i]);
            strMaxSize = 0;
            while(matcher.find()) {
                int size = matcher.group(0).length();
                if(size > strMaxSize) {
                    strMaxSize = size;
                }
            }
            if(strMaxSize == 3) {
                caseTwoCount++;
            }
        }
        result[0] = caseOneCount;
        result[1] = caseTwoCount;
        return result;
    }
}
