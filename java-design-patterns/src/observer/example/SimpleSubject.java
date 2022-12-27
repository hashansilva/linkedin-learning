package observer.example;

import java.util.ArrayList;

public class SimpleSubject implements Subject {
    private ArrayList<Observer> observers;
    private int value = 0;
    public SimpleSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.value);
        }
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}
