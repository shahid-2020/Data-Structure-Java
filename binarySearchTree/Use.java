package binarySearchTree;

public class Use {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.print();
        System.out.println(bst.search(2));
        bst.delete(2);
        System.out.println(bst.search(2));
        bst.print();

    }
}
