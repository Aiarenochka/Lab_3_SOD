package main.timer;

import main.priorityQueue.PriorityQueue;

public class TimeMeasurement {
    public void benchmarkQueueOperationsAdding(PriorityQueue<Integer> checkList){
        for(int i = 0; i < 10_000; i++){
            checkList.add((int) (Math.random() * 10_000));
        }
    }
    public void benchmarkQueueOperationsDeleting(PriorityQueue<Integer> checkList){
        for(int i = 0; i < 1000; i++){
            checkList.delete();
        }
    }
    public long tmAdding(PriorityQueue<Integer> checkList){
        long start = System.nanoTime();
        benchmarkQueueOperationsAdding(checkList);
        long end = System.nanoTime();
        return end - start;
    }
    public long tmDeleting(PriorityQueue<Integer> checkList){
        long start = System.nanoTime();
        benchmarkQueueOperationsDeleting(checkList);
        long end = System.nanoTime();
        return end - start;
    }
}