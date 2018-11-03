package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CardShuffle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        int shuffleCount = Integer.parseInt(br.readLine());
        int[] exceptCardCount = new int[shuffleCount];
        for (int i = 0; i < shuffleCount; i++) {
            exceptCardCount[i] = Integer.parseInt(br.readLine());
        }
        int[] result = solution(cardCount, shuffleCount, exceptCardCount);
        for (int value : result) {
            System.out.println(value);
        }
    }

    static int[] solution(int cardCount, int shuffleCount, int[] exceptCardCount) {
        int[] result = new int[5];
        List<Integer> cardList = new ArrayList<>();
        for (int i = 1; i <= cardCount; i++) {
            cardList.add(i);
        }
        for (int i = 0; i < shuffleCount; i++) {
            int n = exceptCardCount[i];
            int upCardCount = cardCount;
            int stopCardCount = n * 2;
            while (upCardCount > stopCardCount) {
                int count = 0;
                for (int j = upCardCount - n - 1; j >= n; j--) {
                    cardList.add(0, cardList.remove(upCardCount - n - 1));
                    count++;
                }
                upCardCount = count;
            }
        }
        for (int i = 0; i < 5; i++) {
            result[i] = cardList.get(i);
        }
        return result;
    }
}
