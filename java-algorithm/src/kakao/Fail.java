package kakao;

import java.util.*;

public class Fail {
    public static void main(String[] args) {
        int n = 5; // 스테이지 수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; //배열길이 : 사용자 수 내용 : 현재 사용자가 머물러있는 스테이지
        int n1= 4;
        int[] stages1 = {4,4,4,4,4};

        int[] result = solution(n1, stages1);
        for (int value : result) {
            System.out.println(value);
        }
    }

    static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> rate = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double challengeNum = 0.0;
            double failNum = 0.0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i + 1) {
                    challengeNum += 1.0;
                }
                if (stages[j] == i + 1) {
                    failNum += 1.0;
                }
            }
            rate.add(new Stage(i+1, failNum / challengeNum));
        }

        Collections.sort(rate, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                if (s1.getRate() > s2.getRate()) {
                    return -1;
                } else if (s1.getRate() < s2.getRate()) {
                    return 1;
                }
                return 0;
            }
        });
        int index = 0;
        for(Stage s1 : rate) {
            answer[index] = s1.getIndex();
            index++;
        }
        return answer;
    }
}
class Stage {
    private int index;
    private double rate;

    public Stage(int index, double rate) {
        this.index = index;
        this.rate = rate;
    }

    public int getIndex() {
        return index;
    }

    public double getRate() {
        return rate;
    }
}