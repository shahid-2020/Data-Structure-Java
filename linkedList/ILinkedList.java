package linkedList;

public interface ILinkedList <T>{
    int size();
    boolean isEmpty();
    boolean insert(T data);
    T delete(T data) throws LinkedListException;
    void print() throws LinkedListException;
}
