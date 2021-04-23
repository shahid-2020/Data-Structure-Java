package tree;

import java.io.IOException;

public class Use {
    public static void main(String[] args) throws IOException {
        try{
            Tree tree = new Tree();
            Node node = tree.insert();
            tree.preorderTraversal(node);
            System.out.println("-------------");
            tree.postorderTraversal(node);
            System.out.println("-------------");
            tree.levelorderTraversal(node);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
