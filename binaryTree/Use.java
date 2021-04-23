package binaryTree;

public class Use {
    public static void main(String[] args) throws Exception{
        BinaryTree bt = new BinaryTree();
        bt.insert();
        bt.printRecursive();
        bt.inorderTraversal();
        bt.preorderTraversal();
        bt.postorderTraversal();
    }
}
