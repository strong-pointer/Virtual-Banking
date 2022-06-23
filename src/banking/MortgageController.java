package src.banking;

import src.banking.controllers.IMortgageController;
import src.banking.models.Customer;
import src.banking.models.ICustomer;
import src.banking.models.IMortgage;
import src.banking.models.Mortgage;
import src.banking.views.IMortgageView;

public class MortgageController implements IMortgageController {
    private IMortgageView view;

    public MortgageController(IMortgageView MortgageView) {
        view = MortgageView;
    }

    public void submitApplication() {
        boolean anotherMort = false;
        boolean run = true;

        // Customer Variables
        String name = "temp";
        double income = 1;
        double debt = 1;
        int score = 1;
        // create customer object
        ICustomer customer = new Customer(debt, income, score, name);

        // Mortgage Variables
        double houseCost;
        double downPayment;
        int years;

        // loop for current customer
        while (run) {
            // Customer Variables initialized
            income = -1;
            debt = -1;
            score = -1;

            // keeps customer info same if user doesn't want another mortgage
            if (!anotherMort) {
                name = view.getName();
                // Validating income
                while (income <= 0) {
                    income = view.getYearlyIncome();
                    if (income <= 0) {
                        System.out.println("Income must be greater than 0.");
                    }
                }
                // Validating debt
                while (debt < 0) {
                    debt = view.getMonthlyDebt();
                    if (debt < 0) {
                        System.out.println("Debt must be greater than or equal to 0.");
                    }
                }
                // Validating credit score
                while (score <= 0 || score > 850) {
                    score = view.getCreditScore();
                    if (score <= 0 || score > 850) {
                        System.out.println("Credit Score must be greater than 0 and less than 850.");
                    }
                }
                // create customer object
                customer = new Customer(debt, income, score, name);
            }

            // Mortgage Variables Initialized
            houseCost = 0.0;
            downPayment = 0.0;
            years = 0;

            // Validating house cost
            while (houseCost <= 0) {
                houseCost = view.getHouseCost();
                if (houseCost <= 0) {
                    System.out.println("Cost must be greater than 0.");
                }
            }

            // validating down payment
            while (downPayment <= 0 || downPayment > houseCost) {
                downPayment = view.getDownPayment();
                if (downPayment <= 0 || downPayment > houseCost) {
                    System.out.println("Down payment must be greater than 0 and less than the cost of the house.");
                }
            }

            // validating years
            while (years <= 0) {
                years = view.getYears();
                if (years <= 0) {
                    System.out.println("Years must be greater than 0");
                }
            }
            // create mortgage object
            IMortgage mortgage = new Mortgage(houseCost, downPayment, years, customer);

            // print customer and mortgage info
            System.out.print(customer.toString());
            System.out.print(mortgage.toString());

            // check if user would like to apply for another mortgage
            if (!view.getAnotherMortgage()) {
                // check if user would like to consider another customer
                if (view.getAnotherCustomer()) {
                    run = true;
                } else {
                    run = false;
                }
                anotherMort = false;
            }
            // Yes to another mortgage
            else {
                anotherMort = true;
            }
        }
    }
}

