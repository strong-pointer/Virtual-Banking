package src.banking;

import src.banking.controllers.IMortgageController;
import src.banking.views.IMortgageView;
import java.util.Scanner;

public class MortgageView implements IMortgageView {
    private IMortgageController controller;
    private Scanner myObj = new Scanner(System.in);

    // Default constructor
    public MortgageView() {
    }

    public void setController(IMortgageController c) {
        controller = c;
    }

    public double getHouseCost() {
        printToUser("How much does the house cost?");
        return myObj.nextDouble();
    }

    public double getDownPayment() {
        printToUser("How much is the down payment?");
        return myObj.nextDouble();
    }

    public int getYears() {
        printToUser("How many years?");
        return myObj.nextInt();
    }

    public double getMonthlyDebt() {
        printToUser("How much are your monthly debt payments?");
        return myObj.nextDouble();
    }

    public double getYearlyIncome() {
        printToUser("How much is your yearly income?");
        return myObj.nextDouble();
    }

    public int getCreditScore() {
        printToUser("What is your credit score?");
        return myObj.nextInt();
    }

    public String getName() {
        printToUser("What's your name?");
        return myObj.nextLine();
    }

    public void printToUser(String s) {
        System.out.println(s);
    }

    // Unused
    public void displayPayment(double p) {
    }

    // Unused
    public void displayRate(double r) {
    }

    public void displayApproved(boolean a) {
        if (a)
        {
            System.out.println("Loan Approved");
        }
        else
        {
            System.out.println("Loan Denied");
        }
    }

    public boolean getAnotherMortgage() {
        char selection = 'z';
        while (selection != 'Y' && selection != 'y' && selection != 'N' && selection != 'n') {
            System.out.println("\nWould you like to apply for another mortgage? Y/N");
            selection = myObj.next().charAt(0);
            // Get rid of newline char
            myObj.nextLine();
            if (selection == 'Y' || selection == 'y') {
                return true;
            } else if (selection == 'N' || selection == 'n') {
                return false;
            }
        }
        return false;
    }

    public boolean getAnotherCustomer() {
        char selection = 'z';
        while (selection != 'Y' && selection != 'y' && selection != 'N' && selection != 'n') {
            System.out.println("Would you like to consider another customer? Y/N");
            selection = myObj.next().charAt(0);
            // Get rid of newline char
            myObj.nextLine();
            if (selection == 'Y' || selection == 'y') {
                return true;
            } else if (selection == 'N' || selection == 'n') {
                return false;
            }
        }
        return false;
    }

}
