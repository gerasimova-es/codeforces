package leetcode;

public class Medium_2265_CountNodesEqualToAverageOfSubtree {

    private static int result;

    public static void main(String[] args) {
        System.out.println(
                averageOfSubtree(
                        new TreeNode(4,
                                new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                                new TreeNode(5, null, new TreeNode(6)))
                )
        );
    }

    public static int averageOfSubtree(TreeNode root) {
        result = 0;
        recursion(root);
        return result;
    }

    private static Pair recursion(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair left = recursion(node.left);
        Pair right = recursion(node.right);
        int count = left.count + right.count + 1;
        int amount = left.amount + right.amount + node.val;
        if (amount / count == node.val) {
            result++;
        }
        return new Pair(amount, count);
    }

    private record Pair(int amount, int count) { }

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
