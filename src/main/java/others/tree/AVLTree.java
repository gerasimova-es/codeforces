package others.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AVLTree {

    private Node root;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.add(100, 150, 170, 200, 15, 50, 7, 120, 250, 300, 90, 115);
        tree.remove(150);

        TreePrinter printer = new TreePrinter();
        printer.print(tree);

        TreeNavigator navigator = new TreeNavigator(tree);

        Node found = navigator.find(50);
        printer.print(found);

        List<Node> sorted = navigator.nodes();
        printer.print(sorted);
    }

    public void add(int... keys) {
        for (int key : keys) {
            root = add(root, key);
        }
    }

    private Node add(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key > node.key) {
            node.right = add(node.right, key);
        } else if (key < node.key) {
            node.left = add(node.left, key);
        } else {
            throw new RuntimeException(String.format("Key %d already exists in tree", key));
        }
        node.fixHeight();
        return balance(node);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }
        if (node.factor() == 2) {
            if (node.right.factor() < 0) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        } else if (node.factor() == -2) {
            if (node.left.factor() > 0) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
        return node;
    }

    private Node rotateLeft(Node parent) {
        Node rightChild = parent.right;
        parent.right = rightChild.left;
        rightChild.left = parent;
        parent.fixHeight();
        rightChild.fixHeight();
        return rightChild;
    }

    private Node rotateRight(Node parent) {
        Node leftChild = parent.left;
        parent.left = leftChild.right;
        leftChild.right = parent;
        parent.fixHeight();
        leftChild.fixHeight();
        return leftChild;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node node, int key) {
        if (key > node.key) {
            node = remove(node.right, key);
        } else if (key < node.key) {
            node = remove(node.left, key);
        } else {
            if (node.left == null) {
                node = node.right;
            } else {
                Node max = getMax(node.left);
                max.left = removeMax(node.left);
                max.right = node.right;
                max.fixHeight();
                return balance(max);
            }
        }
        node.fixHeight();
        return balance(node);
    }

    private Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = removeMax(node.right);
        node.fixHeight();
        return balance(node);
    }

    private static class Node {
        private final int key;
        private int height;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
        }

        public int factor() {
            return getHeight(right) - getHeight(left);
        }

        public void fixHeight() {
            height = Math.max(getHeight(left), getHeight(right)) + 1;
        }

        private int getHeight(Node node) {
            return node == null ? 0 : node.height;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    private static class TreeNavigator {
        private final AVLTree tree;

        public TreeNavigator(AVLTree tree) {
            this.tree = tree;
        }

        public Node find(int key) {
            return find(tree.root, key);
        }

        private Node find(Node node, int key) {
            if (node == null) {
                return null;
            }
            if (key > node.key) {
                return find(node.right, key);
            } else if (key < node.key) {
                return find(node.left, key);
            } else {
                return node;
            }
        }

        public List<Node> nodes() {
            List<Node> nodes = new ArrayList<>();
            nodes(tree.root, nodes);
            return nodes;
        }

        private void nodes(Node node, List<Node> nodes) {
            if (node == null) {
                return;
            }
            nodes(node.left, nodes);
            nodes.add(node);
            nodes(node.right, nodes);
        }
    }

    private static class TreePrinter {

        public void print(Node node) {
            System.out.println(node);
        }

        public void print(List<Node> nodes) {
            System.out.println(
                    nodes.stream()
                            .map(node -> String.valueOf(node.key))
                            .collect(Collectors.joining(", "))
            );
        }

        public void print(AVLTree tree) {
            print("", tree.root, false);
        }

        private void print(String prefix, Node node, boolean isLeft) {
            if (node != null) {
                System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.key);
                print(prefix + (isLeft ? "|   " : "    "), node.left, true);
                print(prefix + (isLeft ? "|   " : "    "), node.right, false);
            }
        }
    }
}
