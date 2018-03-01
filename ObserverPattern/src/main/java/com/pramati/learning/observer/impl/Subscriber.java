package com.pramati.learning.observer.impl;

import com.pramati.learning.observable.Observable;
import com.pramati.learning.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subscriber  implements Observer{

    private String name;
    private List<Observable> posts;

    public Subscriber(String name) {
        this.name = name;
        this.posts = new ArrayList<>();
    }

    public Subscriber() {
        this.posts = new ArrayList<>();
    }

    public void subscribe(Observable p){
        this.posts.add(p);
    }

    @Override
    public void update() {
        for(Observable observable:posts)
        {
            System.out.println("User Name:: "+ this.name + " Notified of update on post:");
            System.out.println(observable.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
