package leetcode._00004_MedianofTwoSortedArrays;

import java.util.Arrays;

/**
 * Project: java_practice
 * Package: leetcode._004_MedianofTwoSortedArrays
 * Solution1.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/5/7
 * Version: 0.0.1
 */

public class Solution1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        short lengthOfNums1 = (short)nums1.length;
        short lengthOfNums2 = (short)nums2.length;
        short sumOflengthOfTwoArrays = (short) (lengthOfNums1 + lengthOfNums2);
        int[] twoArray = new int[sumOflengthOfTwoArrays];
        System.arraycopy(nums1, 0, twoArray, 0, lengthOfNums1);
        System.arraycopy(nums2, 0,  twoArray, lengthOfNums1, lengthOfNums2);
        Arrays.sort(twoArray);
        float meanOfLengthsOfTowArrays = ((float)(lengthOfNums1 + lengthOfNums2 + (short)1) / (short)2) - (short)1;

        return (twoArray[(short)Math.ceil(meanOfLengthsOfTowArrays)] + twoArray[(short)Math.floor(meanOfLengthsOfTowArrays)]) / 2.0;
    }

    public static void main(String[] args) {

        int[] a = {1,2};
        int[] b = {3,4};

        System.out.println(new Solution1().findMedianSortedArrays(a, b));
    }

}
