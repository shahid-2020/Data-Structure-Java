package binarySearchTree;

public class BinarySearchTree implements IBinarySearchTree{
    private Node root;

    private Node insert(Node node, int element) {
        if(node == null){
            return new Node(element);
        }

        if(node.data > element){
            node.left = insert(node.left, element);
        }else{
            node.right = insert(node.right, element);
        }

        return node;
    }

    @Override
    public void insert(int element) {
        root = insert(root, element);
    }

    private Node delete(Node node, int element) {
        if(node == null){
            return null;
        }

        if(node.data > element){
            node.left = delete(node.left, element);
            return node;
        }else if(node.data < element){
            node.right = delete(node.right, element);
            return node;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        if(node.left != null && node.right == null){
            return node.left;
        }

        if(node.left == null && node.right != null){
            return node.right;
        }

        Node min = node.right;
        while(min.left != null){
            min = min.left;
        }
        node.data = min.data;
        root.right = delete(node.right, min.data);
        return node;
    }

    @Override
    public void delete(int element) {
        root = delete(root, element);
    }

    private boolean search(Node node, int element) {
        if(node == null){
            return false;
        }

        if(node.data == element){
            return true;
        }else if(node.data > element){
            return search(node.left, element);
        }else{
            return search(node.right, element);
        }
    }

    @Override
    public boolean search(int element) {
        return search(root, element);
    }


    private void print(Node node) {
        if(node == null) {
            return;
        }
        StringBuilder str = new StringBuilder(node.data+":");

        if(node.left != null) {
            str.append(" L ").append(node.left.data);
        }
        if(node.right != null) {
            str.append(" R ").append(node.right.data);
        }

        System.out.println(str);
        print(node.left);
        print(node.right);
    }

    @Override
    public void print() {
        print(root);
    }
}
