package queue.arrayQueue;

public class Use {
    public static void main(String[] args) throws Exception{
        Queue queue = new Queue(2);
        for(int i=0; i < 10; i++){
            queue.enqueue(i+1);
        }

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.peek());

        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue()+" ");
        }
    }
}
