package others.strChange;

public class Main {
    public static void main(String[] args) {
        String S = "ABBCC";
//        String S = "BABCC";
        String result = solution(S);
        System.out.println(result);
    }

    static String solution(String S) {
        while(true) {
            if(S.matches(".*AB.*")) {
                S = S.replaceFirst("AB", "AA");
            } else if(S.matches(".*BA.*")) {
                S = S.replaceFirst("BA", "AA");
            } else if(S.matches(".*CB.*")) {
                S = S.replaceFirst("CB", "CC");
            } else if(S.matches(".*BC.*")) {
                S = S.replaceFirst("BC", "CC");
            } else if(S.matches(".*AA.*")) {
                S = S.replaceFirst("AA", "A");
            } else if(S.matches(".*CC.*")) {
                S = S.replaceFirst("CC", "C");
            } else {
                break;
            }
        }
        return S;
    }
}
