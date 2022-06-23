package src.banking;

import src.banking.controllers.IMortgageController;
import src.banking.views.IMortgageView;

public class MortgageApp {
    public static void main(String [] args) {
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
        controller.submitApplication();
    }
}