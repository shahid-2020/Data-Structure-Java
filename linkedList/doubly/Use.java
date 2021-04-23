package linkedList.doubly;

import linkedList.LinkedListException;

public class Use {
    public static void main(String[] args) throws LinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for(int i=0; i< 5; i++) {
            list.insert(i+1);
        }
        list.print();
        list.delete(1);
        list.print();
        list.delete(3);
        list.print();
        list.delete(5);
        list.print();
    }
}
