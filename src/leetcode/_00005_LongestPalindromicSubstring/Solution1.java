package leetcode._00005_LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: java_practice
 * Package: leetcode._005_LongestPalindromicSubstring
 * Solution1.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/5/31
 * Version: 0.0.1
 */

public class Solution1 {

    public static Map<Character, Integer[]> charTocIdxMao(char[] c) {
        Map<Character, Integer[]> cIdxMap = new HashMap<>();
        Map<Character, List<Integer>> tmpCIdxMap = new HashMap<>();

        for (int eachCIdx = 0 ; eachCIdx < c.length ; eachCIdx++) {
            char nowChar = c[eachCIdx];
            if (tmpCIdxMap.containsKey(nowChar)) {
                tmpCIdxMap.get(nowChar).add(eachCIdx);
            } else {
                int finalEachCIdx = eachCIdx;
                tmpCIdxMap.put(nowChar, new ArrayList<Integer>(){{add(finalEachCIdx);}});
            }
        }

        for (char eachC : tmpCIdxMap.keySet()) {
            cIdxMap.put(
                    eachC,
                    tmpCIdxMap.get(eachC).toArray(new Integer[tmpCIdxMap.get(eachC).size()])
            );
        }
        return cIdxMap;
    }

    public static boolean isPalindrome(char[] c, int startIdx, int endIdx) {
        if ((endIdx - startIdx) <= 2) return true;
        else if (c[startIdx + 1] != c[endIdx - 1]) return false;
        else return isPalindrome(c, startIdx + 1, endIdx - 1);
    }

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        char[] c2;
        Map<Character, Integer[]> cIdxMap = charTocIdxMao(c);

        int tmpIdxAmount;
        int startIdx;
        int endIdx;

        int longestLength = 0;
        int longestStartIndex = 0;
        int longestEndIndex = 0;

//        int cLength = c.length;

        for (char eachC : cIdxMap.keySet()){
            Integer[] idxsOfEachC = cIdxMap.get(eachC);
            tmpIdxAmount = idxsOfEachC.length;
            startIdx = idxsOfEachC[0];
            endIdx = tmpIdxAmount == 1 ? startIdx : idxsOfEachC[tmpIdxAmount - 1];
            if (tmpIdxAmount == 1) {
                if (((endIdx - startIdx + 1) > longestLength) && isPalindrome(c, startIdx, endIdx)) {
                    longestStartIndex = startIdx;
                    longestEndIndex = endIdx;
                    longestLength = endIdx - startIdx + 1;
                }
            } else {
                for (int i = 0 ; i < tmpIdxAmount - 1 ; i++) {
//                    if (idxsOfEachC[i] == endIdx) continue;
                    for (int j = tmpIdxAmount - 1 ; j > 0 ; j--){
                        if(((idxsOfEachC[j] - idxsOfEachC[i] + 1) > longestLength) && isPalindrome(c, idxsOfEachC[i], idxsOfEachC[j])) {
                            longestStartIndex = idxsOfEachC[i];
                            longestEndIndex = idxsOfEachC[j];
                            longestLength = longestEndIndex - longestStartIndex + 1;
                        }
                    }
                }
            }
        }
//        System.out.println("longestLength: " + longestLength);
//        System.out.println("longestStartIndex: " + longestStartIndex);
//        System.out.println("longestEndIndex: " + longestEndIndex);

        c2 = new char[longestLength];
        for (int i = longestStartIndex ; i <= longestEndIndex ; i++) c2[i - longestStartIndex] = c[i];

        return new String(c2);
    }

    public static void main(String[] args){
        String s = "afchxzuiaa";
        String ss = "abvba";
        String sss = "abvaaavba";
//        System.out.println(s.toCharArray());
        char a = 43;
//        System.out.println(a);
//        System.out.println('G' - 'S');
//        System.out.println(s.toCharArray());
//        System.out.println(new String(s.toCharArray()));

//        for (char c : s.toCharArray()) System.out.println(c);
//        for (String a : s.split("")) System.out.println(a);

//        for (char c : s.toCharArray()) {
//            System.out.println(c);
//        }
//        System.out.println(s.toCharArray()[3] - s.toCharArray()[2]);

        charTocIdxMao(s.toCharArray()).forEach((x,y) -> {
            System.out.println(x);
            for (Integer i : y) System.out.print(i + ",");
            System.out.println();
        });

        System.out.println("==========");

//        System.out.println(isPalindrome(ss.toCharArray(), 0, 4));
//        System.out.println(isPalindrome("abba".toCharArray(), 0, 3));
//        System.out.println(isPalindrome("abvvba".toCharArray(), 0, 5));
//        System.out.println(isPalindrome("abvzsvba".toCharArray(), 0, 7));
        System.out.println(isPalindrome("abvzvba".toCharArray(), 0, 6));
        System.out.println(isPalindrome("aa".toCharArray(), 0, 1));
        System.out.println(isPalindrome("abvaaavba".toCharArray(), 0, 8));

        System.out.println("==========");

        System.out.println(new Solution1().longestPalindrome(s));
        System.out.println(new Solution1().longestPalindrome(ss));
        System.out.println(new Solution1().longestPalindrome(sss));
    }
}
