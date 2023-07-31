package others;

import java.util.Objects;

public class BalancedTree {

    private Node root;

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(7);
        tree.insert(5);
        tree.insert(8);
        tree.insert(20);
        tree.insert(11);
        tree.insert(18);
        tree.insert(16);
        tree.insert(3);
        tree.insert(9);
        tree.insert(17);
        tree.insert(6);
        tree.insert(4);
        tree.insert(14);
        tree.insert(15);

        tree.remove(12);

        System.out.println("stop");
    }

    public void insert(int key) {
        root = this.insert(root, key);
    }

    public void remove(int key) {
        root = this.remove(root, key);
    }


    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int factor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.right) - height(node.left);
    }

    private void fixHeight(Node node) {
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    // правый поворот вокруг node
    private Node rightRotate(Node node) {
        Node root = node.left;
        node.left = root.right;
        root.right = node;
        fixHeight(node);
        fixHeight(root);
        return root;
    }

    // левый поворот вокруг node
    private Node leftRotate(Node node) {
        Node root = node.right;
        node.right = root.left;
        root.left = node;
        fixHeight(node);
        fixHeight(root);
        return root;
    }

    // балансировка узла node
    private Node balance(Node node) {
        fixHeight(node);
        if (factor(node) == 2) { // если правое поддерево больше левого на 2
            if (factor(node.right) < 0) { // если в правом поддереве левое поддерево больше правого
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        if (factor(node) == -2) {
            if (factor(node.left) > 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
        return node; // балансировка не нужна
    }

    // вставка ключа key в дерево с корнем node
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("Duplicated key = " + key);
        }
        return balance(node);
    }

    //поиск узла с минимальным ключом (самый левый узел в поддереве)
    private Node findMin(Node node) {
        return node.left != null ? findMin(node.left) : node;
    }

    // удаление узла с минимальным ключом из дерева
    private Node removeMin(Node node) {
        if (node.left == null) {
            //возвращаем правый чтобы поставить его на местро род. (левого) элемента
            return node.right;
        }
        //node.left как самый мин. будет заменен: 1) или на null 2) или на его правый элемент
        node.left = removeMin(node.left);
        return balance(node);
    }

    // удаление ключа k из дерева p
    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            //в правом поддереве найдем самый левый элемент - 16
            Node min = findMin(node.right);
            //в правую часть минимального элемента вставим замену после удаления
            min.right = removeMin(node.right);
            //в левую часть вствляем левый элемент удаляемого узла
            min.left = node.left;
            return balance(min);
        }
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key && height == node.height && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, height, left, right);
        }

        @Override
        public String toString() {
            return "key=" + key;
        }
    }
}
