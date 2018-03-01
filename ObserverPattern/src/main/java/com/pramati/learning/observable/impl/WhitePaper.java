package com.pramati.learning.observable.impl;

import com.pramati.learning.observable.Observable;
import com.pramati.learning.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WhitePaper implements Observable{

    private String topic;
    private String data;
    private ArrayList<Observer> followers;
    private List<Comment> comments;

    public WhitePaper() {
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
        return "WhitePaper{" +
                "topic='" + topic + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
