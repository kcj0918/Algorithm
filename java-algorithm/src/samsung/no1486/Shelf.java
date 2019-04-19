package samsung.no1486;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shelf {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());

        for(int a=1;a<=testSize;a++){
            String[] line = br.readLine().split(" ");
            int people_num = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            int[] nums = new int[people_num];
            String[] peoples = br.readLine().split(" ");
            for(int i=0; i<people_num; i++) {
                nums[i] = Integer.parseInt(peoples[i]);
            }
            solution(height, nums);
            System.out.println("#" + a +" " + (min_value - height));
            min_value = Integer.MAX_VALUE;
        }
    }

    static int solution(int height, int[] nums) {
        include = new boolean[nums.length];
        powerSet(0, nums, height, 0);
        return 0;
    }

    static void powerSet(int k, int[] nums, int height, int currentHeight) {
        if (k == nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (include[i]) {
                    currentHeight += nums[i];
                }
                if (currentHeight >= height) {
                    min_value = Math.min(min_value, currentHeight);
                    break;
                }
            }
            return;
        }
        include[k] = false;
        powerSet(k + 1, nums, height, currentHeight);
        include[k] = true;
        powerSet(k + 1, nums, height, currentHeight);
    }

    static boolean[] include;
    static int min_value = Integer.MAX_VALUE;
}
