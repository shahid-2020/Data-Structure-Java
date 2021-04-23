package Trie;

public class Trie {
    private final Node root;

    public Trie(){
        root = new Node('\0');
    }

    private void add(String word, Node node){
        if(word.length() == 0){
            node.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        Node child = node.children[childIndex];
        if(child == null){
            child = new Node(word.charAt(0));
            node.children[childIndex] = child;
            node.childCount++;
        }
        add(word.substring(1), child);
    }

    public void add(String word){
        add(word, root);
    }

    private boolean search(String word, Node node){
     if(word.length() == 0){
         return node.isTerminating;
     }

     int childIndex = word.charAt(0) - 'a';
     Node child = node.children[childIndex];
     if(child == null){
         return false;
     }

     return search(word.substring(1), child);
    }

    public boolean search(String word){
        return search(word, root);
    }

    private void remove(String word, Node node){
        if(word.length() == 0){
            node.isTerminating = false;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        Node child = node.children[childIndex];
        if(child == null){
            return;
        }
        remove(word.substring(1), child);

        if(!child.isTerminating && child.childCount == 0) {
            node.children[childIndex] = null;
            node.childCount--;
        }
    }

    public void remove(String word){
        remove(word, root);
    }
}
