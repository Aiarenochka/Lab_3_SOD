package main.priorityQueue;

public class PriorityQueueOnArray implements PriorityQueue<Integer> {
    private final int[] array = new int[10_001];
    private int size = -1;

    @Override
    public void add(Integer data) {
        size++;
        array[size] = data;
        shiftUp(size);
    }

    @Override
    public Integer peek() {
        return array[0];
    }

    @Override
    public Integer delete() {
        int res = array[0];
        array[0] = array[size];
        size--;
        shiftDown(0);
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size == -1;
    }

    // Realisation of the heap methods
    public int parent(int i) {
        return (i - 1) / 2;
    }
    public int lChild(int i) {
        return i * 2 + 1;
    }
    public int rChild(int i) {
        return i * 2 + 2;
    }

    public void shiftUp(int i){
        while(i > 0 && array[parent(i)] < array[i]){
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public void shiftDown(int i) {
        int mxIndex = i;
        int lChild = lChild(i);
        if(lChild <= size && array[lChild] > array[mxIndex]){
            mxIndex = lChild;
        }
        int rChild = rChild(i);
        if(rChild <= size && array[rChild] > array[mxIndex]){
            mxIndex = rChild;
        }
        if(i != mxIndex){
            swap(i, mxIndex);
            shiftDown(mxIndex);
        }
    }

    public void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i < size + 1; i++){
            str.append(array[i]);
            if(i != size){
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}