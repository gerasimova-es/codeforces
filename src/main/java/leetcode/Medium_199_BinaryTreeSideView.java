package leetcode;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium_199_BinaryTreeSideView {

    public static void main(String[] args) {
        System.out.println(
                backtracking(
                        new TreeNode(1,
                                new TreeNode(2, null, new TreeNode(5)),
                                new TreeNode(3, null, new TreeNode(4))
                        )
                )
        );
    }

    private static List<Integer> backtracking(TreeNode node) {
        if (node == null) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        execute(node, 1, result);
        return result;
    }

    private static void execute(TreeNode node, int level, List<Integer> results) {
        if (node == null) {
            return;
        }
        if (results.size() < level) {
            results.add(node.val);
        }
        execute(node.right, level + 1, results);
        execute(node.left, level + 1, results);
    }

    private static List<Integer> queue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);

        Queue<TreeNode> childsQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            Integer value = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    value = value == null ? node.right.val : value;
                    childsQueue.add(node.right);
                }
                if (node.left != null) {
                    value = value == null ? node.left.val : value;
                    childsQueue.add(node.left);
                }
            }
            if (value != null) {
                result.add(value);
                queue.addAll(childsQueue.stream().toList());
                if (childsQueue.isEmpty()) {
                    break;
                }
                childsQueue.clear();
            }
        }
        return result;
    }

}



