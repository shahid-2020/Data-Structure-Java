package stack.linkedListStack;

import stack.IStack;
import stack.StackException;

public class Stack <T> implements IStack <T> {
    private Node<T> head;
    private int size;

    public Stack(){
        head=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public T top() throws StackException {
        if(isEmpty()){
            throw new StackException("Empty Stack");
        }
        return head.data;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        size++;
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head=newNode;
    }

    @Override
    public T pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Empty Stack");
        }
        size--;
        T element = head.data;
        head=head.next;
        return element;
    }
}
