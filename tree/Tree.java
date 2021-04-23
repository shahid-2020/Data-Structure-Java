package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private final BufferedReader br;

    public Tree (){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Node insertRecursive() throws IOException{
        System.out.println("Enter new node");
        int element = Integer.parseInt(br.readLine());
        System.out.println("Enter child count of "+ element);
        int childCount = Integer.parseInt(br.readLine());
        Node node = new Node(element, childCount);
        for(int i=0; i < childCount; i++){
            Node child = insertRecursive();
            node.children.add(child);
        }
        return node;
    }

    public void printRecursive(Node node){
        StringBuilder str = new StringBuilder(node.data + ": ");
        for(int i=0; i<node.children.size(); i++){
            str.append(node.children.get(i).data).append(" ");
        }
        System.out.println(str);
        for(int i=0; i<node.children.size(); i++){
            printRecursive(node.children.get(i));
        }
    }

    public Node insert() throws IOException{
        System.out.println("Enter the root node");
        int element = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(element);
        queue.add(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.println("Enter child count of "+ curr.data);
            int childCount = Integer.parseInt(br.readLine());
            for(int i=0; i<childCount; i++){
                System.out.println("Enter the "+(i+1)+" child of "+ curr.data);
                int childElement = Integer.parseInt(br.readLine());
                Node childNode = new Node(childElement);
                curr.children.add(childNode);
                queue.add(childNode);
            }
        }
        return node;
    }

    public void preorderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        for(int i=0; i<node.children.size(); i++){
            preorderTraversal(node.children.get(i));
        }
    }

    public void postorderTraversal(Node node){
        if(node == null){
            return;
        }
        for(int i=0; i<node.children.size(); i++){
            postorderTraversal(node.children.get(i));
        }
        System.out.print(node.data+" ");
    }

    public void levelorderTraversal(Node node){
        if(node == null){
            return;
        }
        Queue<Node> parent = new LinkedList<>();
        Queue<Node> child = new LinkedList<>();
        parent.add(node);

        while(!parent.isEmpty()){
            Node curr = parent.poll();
            System.out.print(curr.data+" ");
            child.addAll(curr.children);
            if(parent.isEmpty()){
                parent = child;
                child = new LinkedList<>();
                System.out.println();
            }
        }
    }

}
