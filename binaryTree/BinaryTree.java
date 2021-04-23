package binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private final BufferedReader br;
    private Node root;

    public BinaryTree(){
        br = new BufferedReader(new InputStreamReader(System.in));
        root = null;
    }

    private Node insertRecursive() throws IOException{
        System.out.println("Enter node");
        int data = Integer.parseInt(br.readLine());
        if(data == -1){
            return null;
        }
        Node node = new Node(data);
        node.left = insertRecursive();
        node.right = insertRecursive();
        return node;
    }

    public void insertRecursiveTree() throws IOException{
        root = insertRecursive();
    }

    private void printRecursive(Node node){
        if(node == null){
            return;
        }
        StringBuilder str = new StringBuilder(node.data+":");
        if(node.left != null){
            str.append(" L : ").append(node.left.data);
        }
        if(node.right != null){
            str.append(" R : ").append(node.right.data);
        }
        System.out.println(str);
        printRecursive(node.left);
        printRecursive(node.right);
    }

    public void printRecursive(){
         printRecursive(root);
    }

    public void insert() throws IOException{
        System.out.println("Enter the root Node");
        int data = Integer.parseInt(br.readLine());
        if(data == -1){
            return;
        }
        root = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.println("Enter the Left child of "+ curr.data);
            int leftData = Integer.parseInt(br.readLine());
            if(leftData != -1) {
                curr.left = new Node(leftData);;
                queue.add(curr.left);
            }

            System.out.println("Enter the Right child of "+ curr.data);
            int rightData = Integer.parseInt(br.readLine());
            if(rightData != -1) {
                curr.right=new Node(rightData);
                queue.add(curr.right);
            }
        }

    }

    public void levelorderTraversal(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            StringBuilder str = new StringBuilder(curr.data+":");

            if(curr.left != null){
                str.append(" L ").append(curr.left.data);
                queue.add(curr.left);
            }else{
                str.append(" L ").append("-1");
            }

            if(curr.right != null){
                str.append(" R ").append(curr.right.data);
                queue.add(curr.right);
            }else{
                str.append(" R ").append("-1");
            }

            System.out.println(str);
        }
    }

    private void inorderTraversal(Node node) {
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data+" ");
        inorderTraversal(node.right);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void preorderTraversal(Node node) {
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void postorderTraversal(Node node) {
        if(node == null){
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data+" ");
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

}
