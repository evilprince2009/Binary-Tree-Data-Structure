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
        return minValue(root);
    }

    // Private helper methods

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
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

    private int minValue(Node root) {
        if (leafNode(root)) {
            return root.value;
        }

        int left = minValue(root.leftChild);
        int right = minValue(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }

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

