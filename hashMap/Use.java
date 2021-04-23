package hashMap;

public class Use {
    public static void main(String[] args) {
        Map<String,Integer> hashmap = new Map<>();
        for(int i=0; i < 40; i++) {
            System.out.println("abc"+i);
            hashmap.insert("abc"+i, i);
        }

        System.out.println(hashmap.getValue("abc"+2));
        System.out.println(hashmap.remove("abc"+2));
        System.out.println(hashmap.getValue("abc"+2));

    }
}
