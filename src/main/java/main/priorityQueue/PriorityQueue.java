package main.priorityQueue;

public interface PriorityQueue<T> {
    void add(T data);
    T peek();
    T delete();
    boolean isEmpty();
}