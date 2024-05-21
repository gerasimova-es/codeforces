package leetcode;

import utils.ListNode;

public class Easy_206_ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head;
        ListNode current = previous.next;
        previous.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}