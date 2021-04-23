package linkedList.singly;
import linkedList.ILinkedList;
import linkedList.LinkedListException;


public class SinglyLinkedList <T> implements ILinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public boolean insert(T data) {
        Node<T> newNode = new Node<>(data);
        size++;
        if(head == null){
            head=newNode;
            tail=newNode;
            return true;
        }
        tail.next=newNode;
        tail=tail.next;
        return true;
    }

    @Override
    public T delete(T data) throws LinkedListException {
        if(isEmpty()){
            throw new LinkedListException("Empty Linked List");
        }
        Node<T> curr = head;
        Node<T> prev = null;

        while(curr != null){
            if(curr.data == data){
                break;
            }
            prev=curr;
            curr=curr.next;
        }

        if(curr != null){
            size--;
            if(prev == null){
                head = head.next;
            }else{
                prev.next=curr.next;
            }
            return data;
        }

        return null;
    }

    @Override
    public void print() throws LinkedListException {
        if(isEmpty()){
            throw new LinkedListException("Empty Linked List");
        }
        Node<T> head = this.head;
        System.out.println();
        while(head != null){
         System.out.print(head.data+" ");
         head=head.next;
        }
    }
}
