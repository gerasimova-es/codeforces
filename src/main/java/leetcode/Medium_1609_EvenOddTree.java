package leetcode;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class Medium_1609_EvenOddTree {

    public static void main(String[] args) {
        System.out.println(
                isEvenOddTree(convert(new Integer[]{
                        5,
                        4, 2,
                        3, 5, 7
                }))
        );
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root.val % 2 == 0) {
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean even = false;
        while (!queue.isEmpty()) {
            int prev = even ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (even && (node.val % 2 == 1 || node.val >= prev)){
                    return false;
                }
                if(!even && (node.val % 2 == 0 || node.val <= prev)){
                    return false;
                }
                prev = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            even = !even;
        }
        return true;
    }

    private static TreeNode convert(Integer[] array) {
        return convert(array, 0);
    }

    private static TreeNode convert(Integer[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        if (array[index] == null) {
            return null;
        }
        return new TreeNode(
                array[index],
                convert(array, index * 2 + 1),
                convert(array, index * 2 + 2)
        );
    }

    private record Pair(int level, TreeNode node) {
    }
}


