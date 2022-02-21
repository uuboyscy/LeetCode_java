package leetcode._00001_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

public class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        if (numsLength == 2) return new int[] {0,1};
        else{
            int[] minorResult = new int[numsLength];
            Map majorMap = new HashMap();
            Map minorMap = new HashMap();
            for (int i = 0 ; i < numsLength ; i++){
                majorMap.put(nums[i], i);
                minorMap.put(target - nums[i], i);
            }
            for (Object key : majorMap.keySet().toArray()){
                try{
                    return new int[] {(Integer) majorMap.get(key), (Integer) minorMap.get(key)};
                }catch(Exception e){
                    continue;
                }
            }
            return null;
        }
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        for (int k : (new Solution02()).twoSum(nums, target)) System.out.print(k + "\t");
        System.out.println();

        nums = new int[]{3,2,4};
        target = 6;
        for (int k : (new Solution02()).twoSum(nums, target)) System.out.print(k + "\t");
        System.out.println();

        nums = new int[]{3,3};
        target = 6;
        for (int k : (new Solution02()).twoSum(nums, target)) System.out.print(k + "\t");
        System.out.println();
    }
}
