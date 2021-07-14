public class Main {
    public static void main(String[] args) {
        Tree customTree = new Tree();
        customTree.insert(7);
        customTree.insert(4);
        customTree.insert(9);
        customTree.insert(1);
        customTree.insert(6);
        customTree.insert(8);
        customTree.insert(10);
        System.out.println(customTree.height());
        System.out.println(customTree.find(7));
        System.out.println(customTree.find(13));
        customTree.traversePreOrder();
        System.out.println();
        customTree.traverseInOrder();
        System.out.println();
        customTree.traversePostOrder();
        System.out.println();
        // ----------------------------
        Tree scustomTree = new Tree();
        scustomTree.insert(7);
        scustomTree.insert(4);
        scustomTree.insert(9);
        scustomTree.insert(1);
        scustomTree.insert(6);
        scustomTree.insert(8);
        scustomTree.insert(10);
        System.out.println(customTree.equals(scustomTree));
        System.out.println(customTree.equals(null));
    }
}
