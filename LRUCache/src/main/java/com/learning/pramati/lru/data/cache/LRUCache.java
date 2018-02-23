package com.learning.pramati.lru.data.cache;

import com.learning.pramati.lru.data.LRUData;

/*
@author Virendra

This class is for imlementing LRU cache using LRUData objects.

 */

public class LRUCache <T> {
    private int size;
    private LRUData<T> head;
    private LRUData<T> tail;
    private int counter=0;

    public LRUCache(int size) {
        this.size = size;
    }

    public void add(T o ){
        LRUData<T> t=new LRUData<T>();
        t.setData(o);
        if(head==null){
            head=t;
            tail=t;
            counter++;
        }else{
            LRUData<T> temp=tail;
            while(temp!=null){
                if(temp.getData().equals(t.getData())){
                    t.setNextNode(head);
                    head.setPrevNode(t);
                    temp.getPrevNode().setNextNode(temp.getNextNode());
                    temp.getNextNode().setPrevNode(temp.getPrevNode());
                    head=t;
                    return;
                }
                temp=temp.getPrevNode();
            }

            if(counter<size){
                head.setPrevNode(t);
                temp=head;
                head=t;
                head.setNextNode(temp);
                counter++;
            }else{
                t.setNextNode(head);
                head.setPrevNode(t);
                head=t;
                tail=tail.getPrevNode();
                tail.setNextNode(null);
            }
        }
    }

    public void printCache(){
        LRUData<T> temp=head;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNextNode();
        }
    }
}
