package leetcode._00027_RemoveElement;

/**
 * Project: LeetCode_java
 * Package: leetcode._00027_RemoveElement
 * Solution_1.java
 *
 * Description:
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * User: uuboyscy
 * Created Date: 6/3/22
 * Version: 0.0.1
 */

/*
* Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
Memory Usage: 40.5 MB, less than 96.80% of Java online submissions for Remove Element.*/

public class Solution_1 {

    public int removeElement(int[] nums, int val) {
        int removedCount = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val) nums[i - removedCount] = nums[i];
            else removedCount ++;

        return nums.length - removedCount;
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] nums = {3, 2, 2, 3};

        System.out.println("OUTPUT: " + solution_1.removeElement(nums, 3)); // Output: 2, nums = [2,2,_,_]

        System.out.println();

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("OUTPUT: " + solution_1.removeElement(nums, 2)); // Output: 5, nums = [0,1,4,0,3,_,_,_]
    }

}
