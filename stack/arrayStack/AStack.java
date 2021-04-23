package stack.arrayStack;

public abstract class AStack {
    protected int[] data;
    protected int top;

    public AStack()
    {
        this(10);
    }

    public AStack(int capacity){
        data = new int[capacity];
        top=-1;
    }

    protected final void printStackArray() {
        System.out.println();
        for (int element: data) {
            System.out.print(element+" ");
        }
    }

    public abstract void doubleCapacity();
}
