package com.pramati.learning.observable;

import com.pramati.learning.observer.Observer;

public interface Observable {

    public void subscribe(Observer o);
    public void unsubscribe(Observer o);
    public void notifyObservers();

}
