import java.util.Scanner;
import java.text.DecimalFormat;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // Reading inputs from the console
        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int overheadPercentage = Integer.parseInt(scanner.nextLine());

        // Apply a 5% discount on the price per night if more than 7 nights
        if (nights > 7) {
            pricePerNight *= 0.95;
        }

        // Calculate the total cost for the nights
        double totalCostForNights = nights * pricePerNight;
        // Calculate the overhead costs based on the budget
        double overheadCosts = (budget * overheadPercentage) / 100;

        // Total expenses calculation
        double totalExpenses = totalCostForNights + overheadCosts;

        // Output based on whether the budget is enough
        if (budget >= totalExpenses) {
            double remainingFunds = budget - totalExpenses;
            System.out.println("Ivanovi will be left with " + df.format(remainingFunds) + " leva after vacation.");
        } else {
            double additionalNeeded = totalExpenses - budget;
            System.out.println(df.format(additionalNeeded) + " leva needed.");
        }

        scanner.close();
    }
}
