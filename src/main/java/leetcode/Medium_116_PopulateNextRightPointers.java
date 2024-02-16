package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_116_PopulateNextRightPointers {

    public static void main(String[] args) {
        Node result = dfs(
                new Node(1,
                        new Node(2, new Node(4), new Node(5), null),
                        new Node(3, new Node(6), new Node(7), null),
                        null
                )
        );
        System.out.println(result);
    }

    public static Node dfs(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        node.left.next = node.right;
        if(node.next != null){
            node.right.next = node.next.left;
        }
        dfs(node.left);
        dfs(node.right);
        return node;
    }

    public static Node bfs(Node node) {
        Node mostLeft = node;
        while (mostLeft != null) {
            Node current = mostLeft;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                    if (current.next != null) {
                        current.right.next = current.next.left;
                    }
                }
                current = current.next;
            }
            mostLeft = mostLeft.left;
        }
        return node;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            queue.offer(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                stringBuilder.append(", ").append(node.val);
                if (node.next == null) {
                    stringBuilder.append("(next = null)");
                } else {
                    stringBuilder.append("(next = ").append(node.next.val).append(")");
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return stringBuilder.toString();
        }
    }
}
