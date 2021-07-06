public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(6);
        tree.insert(2);
        tree.insert(5);
        tree.insert(7);
        System.out.println(tree.find(2));
        System.out.println(tree.find(10));
    }
}