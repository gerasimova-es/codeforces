package leetcode;

public class Easy_101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        } else if(left == null || right == null){
            return false;
        } else if(left.val != right.val){
            return false;
        }
        return recursion(left.left, right.right)
                && recursion(left.right, right.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

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


