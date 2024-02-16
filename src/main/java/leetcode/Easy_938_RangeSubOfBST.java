package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Easy_938_RangeSubOfBST {

    public static void main(String[] args) {
        System.out.println(
                bfs(
                        new TreeNode(10,
                                new TreeNode(5,
                                        new TreeNode(3,
                                                new TreeNode(1),
                                                null
                                        ),
                                        new TreeNode(7,
                                                new TreeNode(6),
                                                null)
                                ),
                                new TreeNode(15,
                                        new TreeNode(13),
                                        new TreeNode(18)
                                )
                        ),
                        6,
                        10
                )
        );
    }

    public static int recursion(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return recursion(node.right, low, high);
        }
        if (node.val > high) {
            return recursion(node.left, low, high);
        }
        return node.val + recursion(node.left, low, high) + recursion(node.right, low, high);
    }

    public static int bfs(TreeNode root, int low, int high) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current == null) {
                continue;
            }
            if (current.val < low) {
                queue.add(current.right);
                continue;
            }
            if (current.val > high) {
                queue.add(current.left);
                continue;
            }
            result += current.val;
            queue.add(current.left);
            queue.add(current.right);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
