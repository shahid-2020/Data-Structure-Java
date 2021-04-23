package Trie;

public class Node {
    public char data;
    public boolean isTerminating;
    public Node[] children;
    public int childCount;

    public Node(char data){
        this.data = data;
        isTerminating = false;
        children = new Node[26];
        childCount = 0;
    }
}
