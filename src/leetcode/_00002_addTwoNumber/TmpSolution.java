package leetcode._00002_addTwoNumber;

/**
 * Project: java_practice
 * Package: leetcode.addTwoNumber
 * TmpSolution.java
 * Description:
 * User: uuboyscy
 * Created Date: 2021/3/10
 * Version: 0.0.1
 */

public class TmpSolution {

    public static void main(String[] args){
        /*
        * 2 -> 4 -> 3
        * 5 -> 6 -> 4
        * */
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4, n3);
        ListNode n2 = new ListNode(2, n4);

        System.out.println(n2.val);
        System.out.println(n2.next.val);
        System.out.println(n2.next.next.val);
//        System.out.println(n2.next.next.next.val);

        Integer integer = new Integer(123);
        System.out.println(integer.toString());
//        Arrays.asList(integer.toString()).forEach(x -> System.out.println(x));
        System.out.println(integer.toString().toCharArray());
        for (char s : integer.toString().toCharArray()){
            System.out.println(String.valueOf(s));
        }

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.val);

        System.out.println("=====");

        ListNode newListNode = new IntToListNode(75844922).listNode;
        System.out.println(newListNode.val);
        System.out.println(newListNode.next.val);
        System.out.println(newListNode.next.next.val);
        System.out.println(newListNode.next.next.val);
        System.out.println(newListNode.next.next.next.val);
        System.out.println(newListNode.next.next.next.next.val);
        System.out.println(newListNode.next.next.next.next.next.val);
        System.out.println(newListNode.next.next.next.next.next.next.val);
        System.out.println(newListNode.next.next.next.next.next.next.next.val);
//        System.out.println(newListNode.next.next.next.next.next.next.next.next.val);
        System.out.println(newListNode.next.next.next.next.next.next.next.next == null);
//        System.out.println(newListNode.next.next.next.next.next.next.next.next.next);
        System.out.println(new ListNode().val);
    }
}
