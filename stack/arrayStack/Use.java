package stack.arrayStack;

public class Use {
    public static void main(String[] args) throws Exception{
        Stack stack = new Stack(2);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
