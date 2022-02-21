package leetcode._00002_addTwoNumber;

/**
 * Project: java_practice
 * Package: leetcode.addTwoNumber
 * Solution1.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/3/10
 * Version: 0.0.1
 */

public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode outputListNode;
        ListNode tmpOutputListNode;
        ListNode tmpL1 = l1.next;
        ListNode tmpL2 = l2.next;

        int sum = l1.val + l2.val;
        int nextVal = sum > 9 ? 1 : 0;

        boolean isL1Stop = tmpL1 == null ? true : false;
        boolean isL2Stop = tmpL2 == null ? true : false;

        outputListNode = new ListNode(sum > 9 ? sum - 10 : sum);
        if (nextVal == 1 || (nextVal == 0 && (!isL1Stop || !isL2Stop))) {
            outputListNode.next = new ListNode();
            tmpOutputListNode = outputListNode.next;
        } else {
            return outputListNode;
        }

        while (!isL1Stop || !isL2Stop){
            sum = (isL1Stop ? 0 : tmpL1.val) + (isL2Stop ? 0 : tmpL2.val) + nextVal;
            nextVal = sum > 9 ? 1 : 0;

            tmpL1 = tmpL1 == null ? null : tmpL1.next;
            tmpL2 = tmpL2 == null ? null : tmpL2.next;

            isL1Stop = tmpL1 == null ? true : false;
            isL2Stop = tmpL2 == null ? true : false;

            tmpOutputListNode.val = sum > 9 ? sum - 10 : sum;
            if (nextVal == 1 || (nextVal == 0 && (!isL1Stop || !isL2Stop))) {
                tmpOutputListNode.next = new ListNode();
                tmpOutputListNode = tmpOutputListNode.next;
            }
        }
        if (nextVal == 1) tmpOutputListNode.val = nextVal;

        return outputListNode;
    }

    public static void main(String[] args){
        ListNode listNode = new Solution1().addTwoNumbers(
                new IntToListNode(128).listNode,
                new IntToListNode(42).listNode
        );

        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
//        System.out.println(listNode.next.next.next.val);

        listNode = new Solution1().addTwoNumbers(
                new ListNode(0),
                new ListNode(0)
        );

        System.out.println(listNode.val);
        System.out.println(listNode.next.val);

    }
}
