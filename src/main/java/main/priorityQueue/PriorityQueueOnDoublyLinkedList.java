package main.priorityQueue;

import main.doublyLinkedList.DoublyLinkedList;
import main.doublyLinkedList.Link;

public class PriorityQueueOnDoublyLinkedList implements PriorityQueue<Integer> {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    @Override
    public void add(Integer data) {
        if(list.isEmpty()){
            list.insertFirst(data);
        } else {
            Link<Integer> cur = list.getFirst();
            while(cur != null && data < cur.getData()){
                cur = cur.getNext();
            }
            if(cur == null){
                list.insertLast(data);
            } else {
                list.addBefore(cur.getData(), data);
            }
        }
    }

    @Override
    public Integer peek() {
        return list.getFirst().getData();
    }

    @Override
    public Integer delete() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}