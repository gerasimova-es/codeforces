package leetcode;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Medium_1171_RemoveZeroSeq {

    public static void main(String[] args) {
        System.out.println(
                removeZeroSumSublists(ListNode.create(new int[]{2, 2, -2, 1, -1, -1}))
        );
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int currentSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        for (ListNode node = dummy; node != null; node = node.next) {
            currentSum += node.val;
            ListNode start = map.get(currentSum);
            if (start != null) {
                int tempAmount = currentSum;
                for (ListNode del = start.next; del != node; del = del.next) {
                    tempAmount += del.val;
                    if (tempAmount > 0) {
                        map.remove(tempAmount);
                    }
                }
                start.next = node.next;
            } else {
                map.put(currentSum, node);
            }
        }
        return dummy.next;
    }


    public static ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy;
        while (start != null) {
            ListNode node = start.next;
            int sum = 0;
            while (node != null) {
                sum += node.val;
                if (sum == 0) {
                    start.next = node.next;
                }
                node = node.next;
            }
            start = start.next;
        }
        return dummy.next;
    }
}
