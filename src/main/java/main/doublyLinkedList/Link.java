package main.doublyLinkedList;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Link<T> {
    private T data;
    private Link<T> next;
    private Link<T> prev;

    public Link(T data) {
        this.data = data;
    }
}