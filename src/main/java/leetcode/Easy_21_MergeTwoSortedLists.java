package leetcode;

public class Easy_21_MergeTwoSortedLists {

    public static void main(String[] args) {
        System.out.println(
                mergeTwoLists(
                        new ListNode(1, new ListNode(7, new ListNode(12))),
                        new ListNode(6, new ListNode(7, new ListNode(8)))
                )
        );
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode result = null;
        while (list1 != null || list2 != null) {
            ListNode current;
            if (list1 == null) {
                current = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                current = list1;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                current = list1;
                list1 = list1.next;
            } else {
                current = list2;
                list2 = list2.next;
            }
            if (result == null) {
                head = current;
                result = current;
            } else {
                result.next = current;
                result = result.next;
            }
        }
        return head;
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
            return val + (next == null ? "" : "->" + next);
        }
    }
}
