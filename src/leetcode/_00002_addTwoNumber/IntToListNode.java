package leetcode._00002_addTwoNumber;

/**
 * Project: java_practice
 * Package: leetcode.addTwoNumber
 * IntToListNode.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/3/10
 * Version: 0.0.1
 */

public class IntToListNode {
    public ListNode listNode;
    public IntToListNode(Integer integer){
        ListNode outputListNode = new ListNode();
        ListNode tmpListNode;

        char[] integerCharArray = integer.toString().toCharArray();
        int integerCharArrayLength = integerCharArray.length;

        outputListNode.val = Integer.valueOf(String.valueOf(integerCharArray[0]));
        outputListNode.next = new ListNode(Integer.valueOf(String.valueOf(integerCharArray[1])));
        tmpListNode = outputListNode.next;

        for (int i = 1 ; i < integerCharArrayLength - 1 ; i++) {
            tmpListNode.val = Integer.valueOf(String.valueOf(integerCharArray[i]));
            tmpListNode.next = new ListNode(Integer.valueOf(String.valueOf(integerCharArray[i + 1])));
            tmpListNode = tmpListNode.next;
        }

        this.listNode = outputListNode;
    }
}
