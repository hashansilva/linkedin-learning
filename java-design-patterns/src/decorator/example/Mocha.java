package decorator.example;

public class Mocha extends CondimentDecorator{

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+.90;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" , Mocha";
    }
}
