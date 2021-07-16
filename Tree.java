public class Tree {
    private Node root;

    // Usable public methods
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

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    
    public void traverseInOrder() {
        traverseInOrder(root);
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

    public int height() {
        return height(root);
    }

    public int minValue() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null) {
            return false;
        }
        return equals(root, other.root);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Private helper methods
    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);
        }

        return false;
    } 

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;
        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traversePreOrder(root.leftChild);
        System.out.print(root.value + " ");
        traversePreOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    private int height(Node root) {
        if (root == null) return -1;
        if (leafNode(root)) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean leafNode(Node root) {
        return root.leftChild == null && root.rightChild == null;
    } 

    // private int minValue(Node root) {
    //     if (leafNode(root)) {
    //         return root.value;
    //     }

    //     int left = minValue(root.leftChild);
    //     int right = minValue(root.rightChild);
    //     return Math.min(Math.min(left, right), root.value);
    // }

    // Base implementation
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