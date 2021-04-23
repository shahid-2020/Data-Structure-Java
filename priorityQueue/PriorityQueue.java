package priorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
    private final ArrayList<Integer> heap;

    public PriorityQueue(){
        heap = new ArrayList<>();
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return (size() == 0);
    }

    public int min() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException("Empty Priority Queue");
        }
        return heap.get(0);
    }

    public void insert(int element){
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex -1) / 2;

        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp= heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex -1) / 2;
            }else {
                return;
            }
        }
    }

    public int remove() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException("Empty Priority Queue");
        }
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index=0;
        int minIndex = index;
        int leftIndex = 1;
        int rightIndex = 2;
        while(leftIndex < heap.size()){
            if(heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            if(minIndex == index) {
                break;
            }
            int temp1 = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp1);
            index=minIndex;
            leftIndex = 2*index+1;
            rightIndex = 2*index+2;
        }
        return temp;
    }
}
