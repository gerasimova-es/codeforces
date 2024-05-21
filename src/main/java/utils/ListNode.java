package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode create(int[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        ListNode head = new ListNode(numbers[0]);
        ListNode node = head;
        for (int i = 1; i < numbers.length; i++) {
            node.next = new ListNode(numbers[i]);
            node = node.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : "->" + next);
    }

}
