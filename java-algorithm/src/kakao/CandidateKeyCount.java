package kakao;

import java.util.*;

/*
    Problem source : https://www.welcomekakao.com/learn/courses/30/lessons/42890?language=java
 */
public class CandidateKeyCount {
    public static void main(String[] args) {
        //후보키 개수 찾기
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        }; // 기댓값 : 2  -> 학번, {이름, 전공}
        System.out.println(solution(relation));
    }

    static int solution(String[][] relation) {
        int answer = 0;
        int length1 = relation.length; // 6
        int length2 = relation[0].length; // 4
        set = new int[length2];
        LEVEL = set.length;
        subSet = new int[LEVEL];
        for (int i = 0; i < length2; i++) {
            set[i] = i;
        }
        powerSet(0, 0);
        boolean[] check = new boolean[myList.size()];


        for (int i = 0; i < myList.size(); i++) {
            Set<String> checkSet = new HashSet<>();
            for (int j = 0; j < length1; j++) {
                StringBuilder sb = new StringBuilder();
                Iterator<Integer> it = myList.get(i).iterator();
                while (it.hasNext()) {
                    int index = it.next();
                    sb.append(relation[j][index]);
                }
                checkSet.add(sb.toString());
            }
            if (checkSet.size() == length1) {
                check[i] = true;
            }
        }
        for (int i = 0; i < myList.size() - 1; i++) {
            if (check[i]) {
                for (int j = i + 1; j < myList.size(); j++) {
                    if (check[j]) {
                        if (myList.get(j).containsAll(myList.get(i))) {
                            check[j] = false;
                        }
                    }
                }
            }
        }
        for (boolean v : check) {
            if (v) {
                answer++;
            }
        }
        return answer;
    }

    private static int[] set;
    private static int LEVEL;
    private static int[] subSet;
    private static List<Set<Integer>> myList = new ArrayList<>();

    public static void powerSet(int level, int subSetLen) {
        if (level == LEVEL) {
            Set<Integer> tempSet = new HashSet<>();
            for (int i = 0; i < subSetLen; i++) {
                tempSet.add(subSet[i]);
            }
            if (tempSet.size() != 0) {
                myList.add(tempSet);
            }
            return;
        }
        powerSet(level + 1, subSetLen);
        subSet[subSetLen++] = set[level];
        powerSet(level + 1, subSetLen);
    }
}
