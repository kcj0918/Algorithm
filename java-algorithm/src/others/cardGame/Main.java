package others.cardGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int result = solution("A586QK", "JJ653K");
        System.out.println(result);
    }

    static int solution(String A, String B) {
        String[] row = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        char[] charRow = new char[row.length];
        char[] alec = new char[A.length()];
        char[] bob = new char[B.length()];
        int count=0;

        ArrayList<Integer> alecScore = new ArrayList<>();
        ArrayList<Integer> bobScore = new ArrayList<>();


        for (int i = 0; i < charRow.length; i++) {
            charRow[i] = row[i].charAt(0);
        }

        for (int i = 0; i < A.length(); i++) {
            alec[i] = A.charAt(i);
            bob[i] = B.charAt(i);
        }
        for (int i = 0; i < A.length(); i++) {
            String alecIndex = Character.toString(alec[i]);
            String bobIndex = Character.toString(bob[i]);
            for (int j = 0; j < charRow.length; j++) {
                String charRowIndex = Character.toString(charRow[j]);
                if (alecIndex.equals(charRowIndex)) {
                    alecScore.add(j);
                }
                if (bobIndex.equals(charRowIndex)) {
                    bobScore.add(j);
                }
            }
        }
        for (int i = 0; i < alecScore.size(); i++) {
            if (alecScore.get(i) > bobScore.get(i)) {
                count++;
            }
        }
        return count;
    }
}
