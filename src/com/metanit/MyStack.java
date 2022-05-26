package com.metanit;

import java.util.LinkedList;

public class MyStack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data) {
        linkedList.addFirst(data);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}