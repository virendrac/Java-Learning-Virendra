package com.pramati.learning.observable.impl;

import com.pramati.learning.observable.Observable;
import com.pramati.learning.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Comment implements Observable{

    private String commentString;
    private List<Comment> childComments;
    private ArrayList<Observer> followers;

    public Comment() {
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
        if(followers!=null){

            for (Observer observer:followers){
                observer.update();
            }
            if(childComments!=null){
                for(Comment child:childComments){
                    child.notifyObservers();
                }
            }
        }
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
        notifyObservers();
    }

    public void addChildComments(Comment comment){
        if(childComments!=null){
            childComments.add(comment);
        }else{
            childComments=new ArrayList<>();
            childComments.add(comment);
        }
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentString='" + commentString +
                '}';
    }
}
