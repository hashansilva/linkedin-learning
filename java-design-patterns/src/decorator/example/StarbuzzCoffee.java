package decorator.example;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new DarkRost();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        System.out.println(beverage.getDescription() + " $" + beverage.cost());

    }
}
