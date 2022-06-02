package leetcode._00026_RemoveDuplicatesFromSortedArray;

/**
 * Project: LeetCode_java
 * Package: leetcode._00026_RemoveDuplicatesFromSortedArray
 * Solution.java
 *
 * Description:
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * User: uuboyscy
 * Created Date: 6/2/22
 * Version: 0.0.1
 */

/*
* Runtime: 1 ms, faster than 96.62% of Java online submissions for Remove Duplicates from Sorted Array.
Memory Usage: 43.8 MB, less than 93.34% of Java online submissions for Remove Duplicates from Sorted Array.
* */

public class Solution {

    public int removeDuplicates(int[] nums) {
        int outputInt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[outputInt] = nums[i];
                outputInt += 1;
            }
        }

        return outputInt;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};

        System.out.println("OUTPUT: " + solution.removeDuplicates(nums));

        System.out.println();

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("OUTPUT: " + solution.removeDuplicates(nums));

    }

}
