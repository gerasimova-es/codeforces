package leetcode;

public class Medium_236_LowestCommonAncestors {

    public static void main(String[] args) {
        System.out.println(
                lowestCommonAncestor(
                        new TreeNode(3,
                                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                new TreeNode(1, new TreeNode(0), new TreeNode(8))
                        ),
                        new TreeNode(2),
                        new TreeNode(8)
                )
        );
    }

    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node.val == p.val || node.val == q.val) {
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left != null && right != null) {
            return node;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
