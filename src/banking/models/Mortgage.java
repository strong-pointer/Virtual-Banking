package src.banking.models;

import java.lang.Math;

public class Mortgage extends AbsMortgage implements IMortgage{
    /**
     * @invariant years >= 0 AND monthsInYear = 12 AND payment >= 0 AND 1 >= rate >= 0 AND debtToIncome > 0 AND
     *            principal > 0 AND 12 * MIN_YEARS <= numOfPayments <= 12 * MAX_YEARS AND 0 <= percentDown < 1
     * Correspondent self.MonthsInYear = 12 AND self.years = 0 AND self.payment = payment
     *               AND self.rate = BASERATE AND self.debtToIncome = debtToIncome AND self.principal = principal
     *               AND self.numOfPayments = numOfPayments AND self. percentDown = percentDown
     */

    private static final int monthsInYear = 12;
    private int years = 0;
    private double payment;
    private double rate = BASERATE;
    private double debtToIncome;
    private double principal;
    private int numOfPayments;
    private double percentDown;

    /**
     * Creates a new object to track the mortgages' values
     *
     * @param cost cost of the home
     * @param downPayment the down payment on the house
     * @param numOfYears number of years
     * @param customer the actual customer
     *
     * @pre cost > 0 AND 0 <= downPayment < cost AND 0 <= numOfYears AND [customer is initialized]
     * @post years = numOfYears AND percentDown = downPayment / cost AND rate = #rate / 12
     *       AND principal = cost - downPayment AND numPayments = years * 12 AND
     *       payment = (Rate * Principal) / (1-(1+Rate)^ -NumberOfPayments) AND [debtToIncome = ratio of debt payments
     *       over years and income over the same years 
     */
    public Mortgage(double cost, double downPayment, int numOfYears, ICustomer customer) {
        years = numOfYears;
        percentDown = downPayment / cost;

        // Rate calculation
        if (years < MAX_YEARS) {
            rate += GOODRATEADD;
        }
        else {
            rate += NORMALRATEADD;
        }

        if (percentDown < PREFERRED_PERCENT_DOWN)
        {
            rate += GOODRATEADD;
        }

        // very bad credit score
        if (customer.getCreditScore() < BADCREDIT)
        {
            rate += VERYBADRATEADD;
        }
        // bad credit score
        else if (customer.getCreditScore() < FAIRCREDIT && customer.getCreditScore() >= BADCREDIT) {
            rate += BADRATEADD;
        }
        // fair credit score
        else if (customer.getCreditScore() < GOODCREDIT && customer.getCreditScore() >= FAIRCREDIT) {
            rate += NORMALRATEADD;
        }
        // good credit score
        else if (customer.getCreditScore() < GREATCREDIT && customer.getCreditScore() >= GOODCREDIT) {
            rate += GOODRATEADD;
        }
        rate = rate / monthsInYear;

        principal = cost - downPayment;
        numOfPayments = years * monthsInYear;

        payment = (rate * principal);
        payment = payment / (1 - (Math.pow((1 + rate), (-1*numOfPayments))));

        debtToIncome = ((customer.getMonthlyDebtPayments() + payment) / years) / ((customer.getIncome() / monthsInYear) / years);
    }

    // Tests for the applicable credit scores to see if the customer is approved
    public boolean loanApproved() {
         if ((getRate() < RATETOOHIGH) && (percentDown >= MIN_PERCENT_DOWN) && (debtToIncome <=  DTOITOOHIGH)) {
            return true;
         }
        else {
            return false;
        }
    }

    public double getPayment() {
        return payment;
    }

    // APR calculation
    public double getRate() {
        return rate * monthsInYear;
    }

    public double getPrincipal() {
        return principal;
    }

    public int getYears() {
        return years;
    }
}
