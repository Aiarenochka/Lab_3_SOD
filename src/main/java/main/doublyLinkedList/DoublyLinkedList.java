package main.doublyLinkedList;

import lombok.*;

@Getter
@Setter

public class DoublyLinkedList<T> {
    private Link<T> first;
    private Link<T> last;

    public boolean isEmpty() {
        return first == null || last == null;
    }

    public void insertFirst(T data) {
        Link<T> newLink = new Link<>(data);
        if(isEmpty()){
            first = newLink;
            last = newLink;
        } else{
            newLink.setNext(first);
            first.setPrev(newLink);
            first = newLink;
        }
    }

    public void insertLast(T data) {
        Link<T> newLink = new Link<>(data);
        if(isEmpty()){
            last = newLink;
            first = newLink;
        }else {
            last.setNext(newLink);
            newLink.setPrev(last);
            last = newLink;
        }
    }

    public T removeFirst() {
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        T data = first.getData();
        first = first.getNext();
        if(isEmpty()){
            last = null;
        } else {
            first.setPrev(null);
        }
        return data;
    }

    public T removeLast() {
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        T data = last.getData();
        last = last.getPrev();
        if(isEmpty()){
            first = null;
        } else {
            last.setNext(null);
        }
        return data;
    }

    public boolean contains(T data) {
        return getLink(data) != null;
    }

    public Link<T> getLink(T data) {
        if(isEmpty()){
            return null;
        }
        Link<T> cur = first;
        while(cur != null){
            if(cur.getData().equals(data)){
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }


    public boolean addBefore (T data, T newData){
        if(!contains(data)){
            return false;
        }
        Link<T> a = getLink(data);
        if(a == first){
            insertFirst(newData);
        } else {
            Link<T> b = a.getPrev();
            Link<T> c = new Link<>(newData);
            c.setNext(a);
            c.setPrev(b);
            a.setPrev(c);
            b.setNext(c);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Link<T> cur = first;
        while(cur != null){
            str.append(cur.getData());
            cur = cur.getNext();
            if(cur != null){
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}