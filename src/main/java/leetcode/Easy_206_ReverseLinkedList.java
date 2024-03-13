package leetcode;

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + (next == null ? "" : next);
        }
    }
}
