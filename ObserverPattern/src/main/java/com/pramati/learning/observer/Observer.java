package com.pramati.learning.observer;

import com.pramati.learning.observable.Observable;

public interface Observer {

    public void update();
    public void subscribe(Observable p);
}
