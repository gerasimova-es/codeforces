package leetcode;

import utils.ListNode;

/**
 * The overall idea is to use the second pointer to keep track of the element that is n elements behind.
 * As soon as it is linked list to solve this problem we need to reach the end of the list with first pointer
 * and also reach the n'th node from the end simultaneously with a second pointer.
 *
 * We have the method which takes the head which represents the list as an argument.
 * We define the first pointer and assign the head as its value. We also define a second pointer with initial value null.
 * To keep track of the encountered elements we define an index value.
 *
 * We enter the loop and use current == null as our exit condition. To have n'th element removed we need to
 * store the node before. So we assign preRemovable variable as our head when the index meets condition.
 * Otherwise, if have it already assigned we iterate over our list.
 *
 * When we reach the end of the list we need to check if n is the same as the length of the list.
 * If it so it makes the first node the target node. And we just return null as an answer.
 *
 * Otherwise, once we successfully find the node before the target,
 * we can then stitch it together with the node after the target, and then return head.
 */
public class Medium_19_RemoveNthNode {

    public static void main(String[] args) {
        System.out.println(
                removeNthFromEnd(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
                        4
                )
        );
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode preRemovable = null;
        int index = 1;
        while (current != null) {
            if (index == n + 1) {
                preRemovable = head;
            } else if (preRemovable != null) {
                preRemovable = preRemovable.next;
            }
            current = current.next;
            index++;
        }
        if (preRemovable == null) {
            if(head.next != null){
                return head.next;
            } else {
                return null;
            }
        }
        preRemovable.next = preRemovable.next.next;
        return head;
    }
}

