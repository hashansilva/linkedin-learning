package decorator.example;

public class DarkRost extends Beverage {
    public DarkRost() {
        this.description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
