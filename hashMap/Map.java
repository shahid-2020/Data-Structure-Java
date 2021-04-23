package hashMap;

import java.util.ArrayList;

public class Map <K, V>{

    private ArrayList<Node<K, V>> bucket;
    private int bucketSize;
    private int size;

    public Map(){
        bucketSize = 20;
        size = 0;
        bucket = new ArrayList<>(bucketSize);
        for(int i=0; i < bucketSize; i++) {
            bucket.add(null);
        }
    }

    public int size(){
        return size;
    }

    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        return (hashCode % bucketSize);
    }

    private void rehash(){
        bucketSize *= 2;
        ArrayList<Node<K,V>> temp = bucket;
        bucket = new ArrayList<>(bucketSize);
        for (int i=0; i < bucketSize; i++){
            bucket.add(null);
        }
        size=0;
        for(int i=0; i < temp.size(); i++){
            Node<K, V> head = temp.get(i);
            while (head != null){
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public void insert(K key, V value){
        int index = getBucketIndex(key);
        Node<K, V> head = bucket.get(index);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucket.get(index);
        Node<K, V> node = new Node<>(key, value);
        node.next = head;
        bucket.set(index, node);
        size++;
        double loadFactor = (1.0 * size) / bucketSize;
        if(loadFactor > 0.7){
            rehash();
        }
    }

    public V getValue(K key){
        int index = getBucketIndex(key);
        Node<K, V> head = bucket.get(index);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int index = getBucketIndex(key);
        Node<K, V> prev = null;
        Node<K, V> curr = bucket.get(index);
        while(curr != null){
            if(curr.key.equals(key)){
                if(prev == null){
                    bucket.set(index, curr.next);
                }else{
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }
}
