package leetcode;

import utils.TreeNode;

public class Medium_235_LowestCommonAncestorBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(
                lowestCommonAncestor(
                        new TreeNode(3,
                                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                new TreeNode(1, new TreeNode(0), new TreeNode(8))
                        ),
                        new TreeNode(2),
                        new TreeNode(3)
                )
        );
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
