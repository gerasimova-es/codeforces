package others.tree;

public class RedAndBlackTree {

    private Node root;

    private enum Color {
        RED, BLACK
    }

    private class Node {
        private int key;
        private Color color;
        private Node parent, left, right;
    }
}
