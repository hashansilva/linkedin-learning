package observer.example;

public class SimpleObserver implements Observer{

    private int value;
    private Subject simpleSubject;

    public SimpleObserver(Subject simpleSubject) {
        this.simpleSubject = simpleSubject;
        this.simpleSubject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        this.value = value;
        display();
    }

    private void display() {
        System.out.println("Value" + this.value);
    }
}
