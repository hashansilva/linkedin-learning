import java.util.Scanner;

public class WaterBill {

    public static double calculateWaterBill(double gallonsUsage) {
        double minimumWaterUsage = 1496;
        double gallonsForUnit = 748;
        double minimumWaterBill = 18.84;
        double chargeForUnit = 3.90;
        if (gallonsUsage <= minimumWaterUsage) {
            return minimumWaterBill;
        } else {
            double additionalUsage = gallonsUsage - minimumWaterUsage;
            double additionalCharge = Math.ceil(additionalUsage / gallonsForUnit) * chargeForUnit;
            return additionalCharge + minimumWaterBill;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water " +
                "did you use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
    }
}
