package leetcode._00004_MedianofTwoSortedArrays;

/**
 * Project: java_practice
 * Package: leetcode._004_MedianofTwoSortedArrays
 * Solution1.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/5/8
 * Version: 0.0.1
 */

public class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        short maxIdxOfNums1 = (short) ((short)nums1.length - (short)1);
        short maxIdxOfNums2 = (short) ((short)nums2.length - (short)1);
        short sumOflengthOfTwoArrays = (short) (maxIdxOfNums1 + maxIdxOfNums2 + (short)2);
        short targetIdxOfTwoArrayRefer = (short) (sumOflengthOfTwoArrays - (short)1);
        short targetIdxOfTwoArrayLeft = (short) Math.floor(targetIdxOfTwoArrayRefer / (float)2);
        short targetIdxOfTwoArrayRight = (short) Math.ceil(targetIdxOfTwoArrayRefer / (float)2);

        short idx1 = 0;
        short idx2 = 0;

        short left;
        short right;

        for (short position = 0; position <= targetIdxOfTwoArrayRight ; position++) {

            if ((position == targetIdxOfTwoArrayLeft) && (position == targetIdxOfTwoArrayRight)) {
                left = right = (short) nums1[idx1] <= (short) nums2[idx2] ? (short) nums1[idx1] : (short) nums2[idx2];
//                System.out.println("[1]" + left + "  " + right);
                return left;
            }
            else if (position == targetIdxOfTwoArrayLeft) {
                left = (short) nums1[idx1] <= (short) nums2[idx2] ? (short) nums1[idx1++] : (short) nums2[idx2++];
                right = (short) nums1[idx1] <= (short) nums2[idx2] ? (short) nums1[idx1] : (short) nums2[idx2];
//                System.out.println("[2]" + left + "  " + right);
                return (left + right) / 2.0;
            }
            if (nums1[idx1] <= nums2[idx2]) idx1 += 1;
            else idx2 += 1;

        }

        return 0;
    }

    public double findMedianSortedArraysM(int[] nums1, int[] nums2) {
        short maxIdxOfNums1 = (short) ((short)nums1.length - (short)1);
        short maxIdxOfNums2 = (short) ((short)nums2.length - (short)1);
        short sumOflengthOfTwoArrays = (short) (maxIdxOfNums1 + maxIdxOfNums2 + (short)2);
        short targetIdxOfTwoArrayRefer = (short) (sumOflengthOfTwoArrays - (short)1);
        short targetIdxOfTwoArrayLeft = (short) Math.floor(targetIdxOfTwoArrayRefer / (float)2);
        short targetIdxOfTwoArrayRight = (short) Math.ceil(targetIdxOfTwoArrayRefer / (float)2);

        short idx1 = 0;
        short idx2 = 0;

        int left;
        int right;

        if (sumOflengthOfTwoArrays == 1) return maxIdxOfNums1 > maxIdxOfNums2 ? nums1[maxIdxOfNums1] : nums2[maxIdxOfNums2];

        for (short position = 0; position <= targetIdxOfTwoArrayRight ; position++) {

            if (position == targetIdxOfTwoArrayLeft) {
                try {
                    left = nums1[idx1] <= nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
                } catch (ArrayIndexOutOfBoundsException e) {
                    left = idx1 > maxIdxOfNums1 ? nums2[idx2++] : nums1[idx1++];
                }
                try {
                    right = nums1[idx1] <= nums2[idx2] ? nums1[idx1] : nums2[idx2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    right = idx1 > maxIdxOfNums1 ? nums2[idx2] : nums1[idx1];
                }
                return position == targetIdxOfTwoArrayRight ? left : (left + right) / 2.0;
            }
            try {
                if (nums1[idx1] <= nums2[idx2]) idx1 += 1;
                else idx2 += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                if (idx1 > maxIdxOfNums1) idx2 += 1;
                else idx1 += 1;
            }

        }

        return 0;
    }

    public static void main(String[] args) {

        int[] a = {1};
        int[] b = {};

        int idx1 = 1;
        int idx2 = 0;

//        short left = (short)a[idx1] <= (short)b[idx2] ? (short)a[idx1++] : (short)b[idx2++];
//        System.out.println(idx1);
//        System.out.println(idx2);
//        System.out.println(left);
//        System.out.println(b[idx2]);

//        System.out.println(new Solution2().findMedianSortedArrays(a, b));
        System.out.println(new Solution2().findMedianSortedArraysM(a, b));
        System.out.println((short)100000 + (short)100000);
    }

}
