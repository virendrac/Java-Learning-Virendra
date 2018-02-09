package com.learning.pramati.lru.data;

/*
@author Virendra

This class is to act as a single node of data on the LRU cache.

 */

public class LRUData <T> {
    private T data;
    private LRUData<T> prevNode;
    private LRUData<T> nextNode;

    public LRUData(T data) {
        this.data = data;
    }
    public LRUData() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LRUData<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(LRUData<T> prevNode) {
        this.prevNode = prevNode;
    }

    public LRUData<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LRUData<T> nextNode) {
        this.nextNode = nextNode;
    }
}
