package others.tree;

import java.util.Comparator;
import java.util.List;

public class BTree2 {

//    private final int degree;
//    private Node root;
//
//    public BTree2(int degree) {
//        this.degree = degree;
//    }
//
//    public static void main(String[] args) {
//        BTree2 tree = new BTree2(3);
//        tree.insert(100, 100);
//        tree.insert(200, 200);
//        tree.insert(300, 300);
//        tree.insert(400, 400);
//        System.out.println(tree);
//    }
//
//    public void insert(int key, int value) {
//        if (root == null) {
//            root = new Node(degree, new Dictionary(key, value));
//        } else {
//            Node leaf = findLeaf(root, key);
//            leaf.add(new Dictionary(key, value));
//            balance(leaf);
//        }
//    }
//
//    private Node insert(Node node, int key, int value) {
//        for (int i = node.children.size() - 1; i > 0; i--) {
//            Node child = node.children.get(i);
//            if (child.key < key) {
//                insert(dictionary.node, key, value);
//            }
//        }
//    }
//
//    private void balance(Node node) {
//        if (!node.overfilled()) {
//            return;
//        }
//        Node newNode = node.split();
//        Dictionary toParent = node.trim();
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
//        private List<Dictionary> dictionaries;
//
//        private List<Node> children;
//
//        public Node(int degree, List<Dictionary> dictionaries, List<Node> children) {
//            this.degree = degree;
//            this.dictionaries = dictionaries;
//            this.children = children;
//        }
//
//        public boolean overfilled() {
//            return dictionaries.size() > degree - 1;
//        }
//
//        public void add(Dictionary dictionary) {
//            dictionaries.add(dictionary);
//            dictionaries.sort(Comparator.comparingInt(e -> e.key));
//        }
//
//        public Node split() {
//            List<Dictionary> rightDictionaries =
//                    dictionaries.subList(
//                            (dictionaries.size() / 2) + 1,
//                            dictionaries.size()
//                    );
//            dictionaries.removeAll(rightDictionaries);
//            return new Node(degree, rightDictionaries);
//        }
//
//        public Dictionary trim() {
//            return dictionaries.remove(dictionaries.size() - 1);
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "degree=" + degree +
//                    ", elements=" + dictionaries +
//                    '}';
//        }
//    }
//
//    private static class Dictionary implements Comparable<Dictionary> {
//        private final int key;
//        private int value;
//
//        public Dictionary(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public int compareTo(Dictionary dictionary) {
//            return this.key - dictionary.key;
//        }
//
//        @Override
//        public String toString() {
//            return "Element{" +
//                    "key=" + key +
//                    ", value=" + value +
//                    '}';
//        }
//    }
}
