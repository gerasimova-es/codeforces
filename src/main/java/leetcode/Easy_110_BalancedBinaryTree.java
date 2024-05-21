package leetcode;

import utils.TreeNode;

public class Easy_110_BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println(
                isBalanced(
                        new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        new TreeNode(7)
                                )
                        )
                )
        );
    }

    public static boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }

    public static int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        if(Math.abs(leftDepth - rightDepth) > 1 || leftDepth < 0 || rightDepth < 0){
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
