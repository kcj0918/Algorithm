package leetcode.midium;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    /**
     * https://leetcode.com/problems/4sum-ii/
     * 114 ms, faster than 85.55% of Java online submissions for 4Sum II.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int sum = n3 + n4;
                if (sumMap.containsKey(-sum)) {
                    count += sumMap.get(-sum);
                }
            }
        }

        return count;
    }
}
