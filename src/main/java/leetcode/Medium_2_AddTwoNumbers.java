package leetcode;

public class Medium_2_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3, null))),
                new ListNode(5, new ListNode(6, new ListNode(4, null)))
        );
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addition = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || addition != 0) {
            int amount = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + addition;
            addition = amount / 10;
            amount = amount % 10;
            if (tail == null) {
                tail = new ListNode(amount, null);
                head = tail;
            } else {
                tail.next = new ListNode(amount, null);
                tail = tail.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (node != null) {
                stringBuilder.append(node.val).append(",");
                node = node.next;
            }
            return stringBuilder.toString();
        }
    }
}


