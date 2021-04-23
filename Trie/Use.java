package Trie;

public class Use {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("this");
        t.add("news");
        t.remove("this");
        System.out.println(t.search("this"));
        System.out.println(t.search("new"));
        System.out.println(t.search("news"));
    }
}
