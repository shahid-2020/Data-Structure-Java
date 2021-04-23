package tree;
import java.util.ArrayList;

public class Node {
    public int data;
    public ArrayList<Node> children;

    public Node(int data){
        this.data = data;
        children = new ArrayList<>();
    }
    public Node(int data, int childCount){
        this.data = data;
        children = new ArrayList<>(childCount);
    }
}
