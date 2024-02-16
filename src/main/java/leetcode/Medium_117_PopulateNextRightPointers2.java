package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_117_PopulateNextRightPointers2 {
    public static void main(String[] args) {
        Integer[] tree = new Integer[]{2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7};
        Node node = convert(tree);
        recursion(node);
        System.out.println(node);
    }

    private static Node recursion(Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            node.left.next = node.right;
            if (node.left.next == null) {
                node.left.next = nextChild(node);
            }
        }
        if (node.right != null) {
            node.right.next = nextChild(node);
        }
        recursion(node.right);
        recursion(node.left);
        return node;
    }

    private static Node nextChild(Node node) {
        Node next = node.next;
        while (next != null) {
            if (next.left != null) {
                return next.left;
            } else if (next.right != null) {
                return next.right;
            }
            next = next.next;
        }
        return null;
    }

    private static Node bfs(Node node) {
        if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (i < size - 1) {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return node;
    }

    private static Node convert(Integer[] array) {
        return convert(array, 0);
    }

    private static Node convert(Integer[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        if (array[index] == null) {
            return null;
        }
        return new Node(
                array[index],
                convert(array, index * 2 + 1),
                convert(array, index * 2 + 2)
        );
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

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
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
