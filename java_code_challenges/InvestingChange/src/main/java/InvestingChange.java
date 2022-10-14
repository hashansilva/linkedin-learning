import java.util.List;

public class InvestingChange {

    static double calculateAvgChangeInvested(List<Double> purchases) {
        if (purchases.size() > 0) {
            double change = purchases.stream().mapToDouble(purchase -> Math.abs(Math.ceil(purchase) - purchase)).sum();
            return change / purchases.size();
        }
        return 0;

    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAvgChangeInvested(purchases));
    }
}
