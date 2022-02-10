package leetcode.midium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KdiffPairInAnArray {
    /**
     * https://leetcode.com/problems/k-diff-pairs-in-an-array/
     * 8 ms, faster than 74.33% of Java online submissions for K-diff Pairs in an Array.
     */
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));
    }

    static int findPairs(int[] nums, int k) {
        int result = 0;
        if (k == 0) {
            Set<Integer> numberSet = new HashSet<>();
            Set<Integer> duplicateNumber = new HashSet<>();
            for (int num : nums) {
                if (numberSet.contains(num)) {
                    duplicateNumber.add(num);
                } else {
                    numberSet.add(num);
                }
            }
            return duplicateNumber.size();
        } else {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        break;
                    }
                    int sum = nums[j] - nums[i];
                    if (sum == k) {
                        result++;
                        break;
                    }
                    if (sum > k) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
