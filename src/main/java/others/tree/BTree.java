package others.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BTree {

//    private final int degree;
//    private Node root;
//
//    public BTree(int degree) {
//        this.degree = degree;
//    }
//
//    public static void main(String[] args) {
//        BTree tree = new BTree(3);
//        tree.insert(100, 100);
//        tree.insert(200, 200);
//        tree.insert(300, 300);
//        tree.insert(400, 400);
//        System.out.println(tree);
//    }
//
//    public void insert(int key, int value) {
//        if (root == null) {
//            root = new Node(degree, new Element(key, value));
//        } else {
//            Node leaf = findLeaf(root, key);
//            leaf.add(new Element(key, value));
//            balance(leaf);
//        }
//    }
//
//    private Node findLeaf(Node node, int key) {
//        for (int i = node.elements.size() - 1; i > 0; i--) {
//            Element element = node.elements.get(i);
//            if (element.node != null && element.key < key) {
//                return findLeaf(element.node, key);
//            }
//        }
//        return node;
//    }
//
//    private void balance(Node node) {
//        if (!node.overfilled()) {
//            return;
//        }
//        Node newNode = node.split();
//        Element toParent = node.trim();
//        if (node.parent == null) {
//            Node parent = new Node(degree, toParent);
//            node.parent = parent;
//            newNode.parent = parent;
//        } else {
//            node.parent.add(toParent);
//        }
//        balance(node.parent);
//    }
//
//    private static class Node {
//        //root: key count = {1; 2*degree - 1}
//        //child: key count = {degree - 1; 2*degree - 1}
//        private final int degree;
//        private List<Element> elements;
//
//        public Node(int degree, List<Element> elements) {
//            this.degree = degree;
//            this.elements = elements;
//        }
//
//        public Node(int degree, Element element) {
//            this(degree, new ArrayList<>(List.of(element)));
//        }
//
//        public boolean overfilled() {
//            return elements.size() > degree - 1;
//        }
//
//        public void add(Element element) {
//            elements.add(element);
//            elements.sort(Comparator.comparingInt(e -> e.key));
//        }
//
//        public Node split() {
//            List<Element> rightElements =
//                    elements.subList(
//                            (elements.size() / 2) + 1,
//                            elements.size()
//                    );
//            elements.removeAll(rightElements);
//            return new Node(degree, rightElements);
//        }
//
//        public Element trim() {
//            return elements.remove(elements.size() - 1);
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "degree=" + degree +
//                    ", elements=" + elements +
//                    '}';
//        }
//    }
//
//    private static class Element implements Comparable<Element> {
//        private final int key;
//        private int value;
//        private Node node;
//
//        public Element(int key, int value, Node node) {
//            this.key = key;
//            this.value = value;
//            this.node = node;
//        }
//
//        public Element(int key, int value) {
//            this(key, value, null);
//        }
//
//        @Override
//        public int compareTo(Element element) {
//            return this.key - element.key;
//        }
//
//        @Override
//        public String toString() {
//            return "Element{" +
//                    "key=" + key +
//                    ", value=" + value +
//                    ", node=" + node +
//                    '}';
//        }
//    }
}
