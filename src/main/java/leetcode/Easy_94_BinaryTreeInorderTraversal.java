package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy_94_BinaryTreeInorderTraversal {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        execute(root);
        return result;
    }

    public void execute(TreeNode node){
        if(node == null){
            return;
        }
        execute(node.left);
        result.add(node.val);
        execute(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
