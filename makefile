default: src/banking/MortgageApp.java src/banking/MortgageController.java src/banking/MortgageView.java src/banking/models/IMortgage.java src/banking/models/ICustomer.java src/banking/models/AbsMortgage.java src/banking/models/AbsCustomer.java src/banking/models/Mortgage.java src/banking/models/Customer.java src/banking/views/IMortgageView.java src/banking/controllers/IMortgageController.java
	javac src/banking/MortgageApp.java src/banking/MortgageController.java src/banking/MortgageView.java src/banking/models/IMortgage.java src/banking/models/ICustomer.java src/banking/models/AbsMortgage.java src/banking/models/AbsCustomer.java src/banking/models/Mortgage.java src/banking/models/Customer.java src/banking/views/IMortgageView.java src/banking/controllers/IMortgageController.java
	
run: src/banking/MortgageApp.class src/banking/MortgageController.class src/banking/MortgageView.class src/banking/models/IMortgage.class src/banking/models/ICustomer.class src/banking/models/AbsMortgage.class src/banking/models/AbsCustomer.class src/banking/models/Mortgage.class src/banking/models/Customer.class src/banking/views/IMortgageView.class src/banking/controllers/IMortgageController.class
	java src.banking.MortgageApp
clean:
	rm -f src/banking/models/*.class
	rm -f src/banking/views/*.class
	rm -f src/banking/controllers/*.class
	rm -f src/banking/*.class