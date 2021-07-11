public class Tree {
    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if(current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null) return;
        traversePreOrder(root.leftChild);
        System.out.print(root.value + " ");
        traversePreOrder(root.rightChild);
    }
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }
}

