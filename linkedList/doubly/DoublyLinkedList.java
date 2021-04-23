package linkedList.doubly;

import linkedList.ILinkedList;
import linkedList.LinkedListException;

public class DoublyLinkedList <T> implements ILinkedList <T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
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
        newNode.prev=tail;
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

        while(curr != null){
            if(curr.data == data){
                break;
            }
            curr=curr.next;
        }

        if(curr != null){
            size--;
            if(curr.prev == null){
                head = head.next;
                head.prev=null;
            }else{
                curr.prev.next=curr.next;
                if(curr.next != null) {
                    curr.next.prev=curr.prev;
                }
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
