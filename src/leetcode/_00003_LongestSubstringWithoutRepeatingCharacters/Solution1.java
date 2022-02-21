package leetcode._00003_LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: java_practice
 * Package: leetcode._003_LongestSubstringWithoutRepeatingCharacters
 * Solution1.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/5/5
 * Version: 0.0.1
 */

public class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        int stringLength = s.length();
        if (stringLength <= 1) return stringLength;
        List<Character> charList = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int charListSize = 0;
        int outputWordAmount = 0;
        charList.add(charArray[0]);
        for (int i = 1 ; i < (stringLength) ; i++) {
            char nowChar = charArray[i];
            if (charList.contains(nowChar)){
                outputWordAmount = outputWordAmount > charListSize ? outputWordAmount : charListSize;
                charList.subList(0, charList.indexOf(nowChar) + 1).clear();
            }
            charList.add(nowChar);
            charListSize = charList.size();
        }
        return outputWordAmount > charListSize ? outputWordAmount : charListSize;
    }

    public int lengthOfLongestSubstring2(String s) {
        int stringLength = s.length();
        if (stringLength <= 1) return stringLength;
        List<Character> charList = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int charListSize = 0;
        int outputWordAmount = 0;
        charList.add(charArray[0]);
        for (int i = 1 ; i < (stringLength) ; i++) {
            char nowChar = charArray[i];
            if (charList.contains(nowChar)){
                outputWordAmount = Math.max(outputWordAmount, charListSize);
                charList.subList(0, charList.indexOf(nowChar) + 1).clear();
            }
            charList.add(nowChar);
            charListSize = charList.size();
        }
        return Math.max(outputWordAmount, charListSize);
    }

    public int lengthOfLongestSubstring3(String s) {
        int stringLength = s.length();
        if (stringLength == 0) return 0;
        List<Character> charList = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int charListSize = 1;
        int outputWordAmount = 1;
        charList.add(charArray[0]);
        for (char c : charArray) {
            if (charList.contains(c)){
                outputWordAmount = Math.max(outputWordAmount, charListSize);
                charList.subList(0, charList.indexOf(c) + 1).clear();
            }
            charList.add(c);
            charListSize = charList.size();
        }
        return Math.max(outputWordAmount, charListSize);
    }

    public static void main(String[] args) {
        String s = "ad89sahucja1234567890a";
        s = " ";
        System.out.println(new Solution1().lengthOfLongestSubstring(s));
        System.out.println("======");
//        for (char c : s.toCharArray()) System.out.println(c);
//        Set<Character> charSet = new HashSet<>();
//        charSet.add('s');
//        charSet.add('a');
//        charSet.add('1');
//        charSet.add('h');
//        System.out.println(charSet.size());
//        charSet.clear();
//        System.out.println(charSet.size());
        List<Character> list = new ArrayList<>();
        list.add('a');
        System.out.println(list.get(0));
        list.add('b');
        System.out.println(list.remove(0));
        System.out.println(list.get(0));
        list.add('c');
        list.add('d');
        System.out.println(list.indexOf('c'));
        list.add('e');
        list.add('f');
        System.out.println(list.subList(0,2));
    }
}
