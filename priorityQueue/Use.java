package priorityQueue;

public class Use {
    public static void main(String[] args) throws Exception{

        PriorityQueue pq = new PriorityQueue();
        int arr[] = {5,1,9,2,0};
        for(int i=0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }
        System.out.println(pq.min());
        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
