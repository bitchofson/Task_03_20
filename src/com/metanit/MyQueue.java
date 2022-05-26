package com.metanit;


import java.util.LinkedList;

class MyQueue<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void add(T e) {
        linkedList.addLast(e);
    }

    public boolean isEmpty() {
            return linkedList.peek() == null;
    }

    public T remove() {
        return linkedList.removeFirst();
    }
}
