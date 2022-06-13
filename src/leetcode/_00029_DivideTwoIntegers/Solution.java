package leetcode._00029_DivideTwoIntegers;

/**
 * Project: LeetCode_java
 * Package: leetcode._00029_DivideTwoIntegers
 * Solution.java
 *
 * Description:
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 *
 * User: uuboyscy
 * Created Date: 6/7/22
 * Version: 0.0.1
 */

/*
* Runtime: 1 ms, faster than 99.96% of Java online submissions for Divide Two Integers.
Memory Usage: 39.5 MB, less than 90.31% of Java online submissions for Divide Two Integers.
* */

public class Solution {

    public int divide(int dividend, int divisor) {
        int tmpOutput = dividend / divisor;
        if (dividend < 0 && divisor < 0 &&tmpOutput < 0)
            return tmpOutput - 1;
        else
            return tmpOutput;
    }

    public static void main(String[] args) {
        int dividend, divisor;
        Solution solution = new Solution();

        dividend = 10;
        divisor = 3;
        System.out.println(solution.divide(dividend, divisor));  // 3

        System.out.println("===");

        dividend = 7;
        divisor = -3;
        System.out.println(solution.divide(dividend, divisor));  // -2

        System.out.println(-2147483648);
        System.out.println(2147483647);

        System.out.println(9 / -2);

    }
}
