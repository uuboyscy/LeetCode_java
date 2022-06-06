package leetcode._00028_ImplementStrStr;

/**
 * Project: LeetCode_java
 * Package: leetcode._00028_ImplementStrStr
 * Solution.java
 *
 * Description:
 *
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * User: uuboyscy
 * Created Date: 6/6/22
 * Version: 0.0.1
 */

/*
* Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
Memory Usage: 40.5 MB, less than 79.09% of Java online submissions for Implement strStr().
* */

public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        String haystack, needle;
        Solution solution = new Solution();

        haystack = "hello";
        needle = "ll";
        System.out.println(solution.strStr(haystack, needle));  // 2

        haystack = "aaaaa";
        needle = "bba";
        System.out.println(solution.strStr(haystack, needle));  // -1

        haystack = "aaaaa";
        needle = "";
        System.out.println(needle.isEmpty());
        System.out.println(solution.strStr(haystack, needle));  // 0
    }

}
