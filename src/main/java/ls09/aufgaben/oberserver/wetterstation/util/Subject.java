package ls09.aufgaben.oberserver.wetterstation.util;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Subject {
    Collection<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
