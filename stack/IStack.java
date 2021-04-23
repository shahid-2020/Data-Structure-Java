package stack;

public interface IStack <T>{
    int size();
    boolean isEmpty();
    T top () throws StackException;
    void push(T element);
    T pop() throws StackException;
}
