package leetcode._00006_ZigZagConversion;

/**
 * Project: java_practice
 * Package: leetcode._006_ZigZagConversion
 * Solution1.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/7/18
 * Version: 0.0.1
 */

public class Solution1 {

    public String convert(String s, int numRows) {
        int sLength = s.length();
        if (numRows == 1 || numRows >= sLength) return s;

        int maxInterval = numRows * 2 - 2;
        int dInterval = maxInterval;
        int uInterval = 0;
        int nowInterval = dInterval;
        int oCharIndex = 0;
//        int sCharIndex = 0;
        int startIndexForEachRow = 0;
        char[] sCharArray = s.toCharArray();
        char[] oChatArray = new char[sCharArray.length];

        for (int row = 0 ; row < numRows ; row++) {
            startIndexForEachRow = row; // This is also for index
            for (int i = 0 ; true ; i++) {
                nowInterval = i % 2 == 0 ? dInterval : uInterval;
                if (nowInterval == 0) continue;
                else oChatArray[oCharIndex] = sCharArray[startIndexForEachRow];
//                System.out.println(oChatArray[oCharIndex] + " : " + nowInterval);
                startIndexForEachRow = startIndexForEachRow + nowInterval;
                oCharIndex += 1;
                if (startIndexForEachRow > sLength - 1 || oCharIndex > sLength - 1) break;
            }
            dInterval -= 2;
            uInterval += 2;
        }

        return new String(oChatArray);
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String ss = "A";
        System.out.println(new Solution1().convert(s, 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(new Solution1().convert(s, 4).equals("PINALSIGYAHRPI"));
        System.out.println(new Solution1().convert(s, 2));
        System.out.println(new Solution1().convert(s, 1));
        System.out.println(new Solution1().convert(s, 2));
        System.out.println(new Solution1().convert(ss, 1));
        System.out.println(new Solution1().convert("ac", 3));

    }
}
