package leetcode;

import utils.TreeNode;

public class Easy_543_DiameterOfBinaryTree {
    private static int maxLength = 0;

    public static void main(String[] args) {
        int result = diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)));
        System.out.println(result);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        execute(root);
        return maxLength;
    }

    public static int execute(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = execute(root.left);
        int right = execute(root.right);
        maxLength = Math.max(maxLength, left + right);
        return Math.max(left, right) + 1;
    }
}
