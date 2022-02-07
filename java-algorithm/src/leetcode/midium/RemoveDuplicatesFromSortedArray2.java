package leetcode.midium;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
     * 3 ms, faster than 7.61% of Java online submissions for Remove Duplicates from Sorted Array II.
     */
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    static int removeDuplicates(int[] nums) {
        int currentNum = Integer.MAX_VALUE;
        int count = 0;
        int changeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != currentNum) {
                currentNum = nums[i];
                count = 1;
            } else {
                count++;
                if(count > 2) {
                    changeCount++;
                    nums[i] = Integer.MAX_VALUE;
                }

            }
        }

        Arrays.sort(nums);

        return nums.length - changeCount;
    }
}
