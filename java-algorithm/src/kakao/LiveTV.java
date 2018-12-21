package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LiveTV {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }

    static int solution(int[] food_times, long k) {
        int answer = 0;
        int time = 0;
        List<Integer> foodNum = new ArrayList<>();
        Queue<Integer> eatFood = new LinkedList<>();

        int min_food_quantity = 1001;
        int min_food_index = -1;

        // 큐와 리스트에 각각 값 세팅
        for (int i = 0; i < food_times.length; i++) {
            foodNum.add(food_times[i]);
            eatFood.offer(i);
            if (food_times[i] < min_food_quantity) {
                min_food_quantity = food_times[i];
                min_food_index = i;
            }
        }

        //사이클돌릴수 있는 횟수 센후 횟수만큼 빼주기
        int cycleCount = (int) k / foodNum.size();
        if (cycleCount > min_food_quantity) {
            cycleCount -= min_food_quantity;
        }

        //해당 사이클가능횟수만큼 반복문 돌려서 빼주기
        int size = foodNum.size();
        for (int i = 0; i < size; i++) {
            foodNum.set(i, foodNum.get(i) - cycleCount);
        }

        for(int value : foodNum) {
            System.out.println(value + " ");
        }

        if (cycleCount != 0) {

        }
        return answer;
    }

    static List<Integer> eatTheFood(List<Integer> food_num, int start_index) {
        int size = food_num.size();
        return food_num;
    }

}
