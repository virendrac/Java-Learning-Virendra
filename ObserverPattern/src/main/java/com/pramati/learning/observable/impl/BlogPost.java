package com.pramati.learning.observable.impl;

import com.pramati.learning.observable.Observable;
import com.pramati.learning.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BlogPost implements Observable{

    private String postName;
    private String data;
    private ArrayList<Observer> followers;
    private List<Comment> comments;

    public BlogPost() {
        this.followers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer o) {
        if(o!=null){
            if(!this.followers.contains(o)){
                this.followers.add(o);
                o.subscribe(this);
            }
        }

    }

    @Override
    public void unsubscribe(Observer o) {
        if(o!=null){
            if(this.followers.contains(o)){
                    this.followers.remove(o);
            }
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer observer:followers){
            observer.update();
        }
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
        notifyObservers();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        notifyObservers();
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            if (comments == null) {
                comments = new ArrayList<>();
            }

            comments.add(comment);
            notifyObservers();
        }
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "postName='" + postName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
