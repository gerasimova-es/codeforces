package others.tree;

import java.util.List;

public class BPlusTree {

    private final int m;
    private Node root;

    public BPlusTree(int m) {
        this.m = m;
    }

    public static void main(String[] args) {
        BPlusTree tree = new BPlusTree(3);
        tree.insert(5, 105);
    }

    public void insert(int key, int value) {

    }

    private static class Node {
        private final int m;
        private Node parent;
        private List<Node> nodes;

        public Node(int m) {
            this.m = m;
        }

    }

    private static class Data {
        private final int key;
        private int value;

        public Data(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
