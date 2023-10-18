package ls13.aufgaben.rollenspiel.gamefigures.util;

import java.util.HashSet;
import java.util.Set;

public class Observable {
    private Set<Observer> observers = new HashSet<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    protected void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
