package application;

import javafx.stage.Stage;

public class Controller {
	
	private final Stage primaryStage;

	public Controller(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void goToSignUp() {
		new SignUP(primaryStage);
	}

	public void goToLogin() {
		new Login(primaryStage);
		
	}

	public void goToHome() {
		new Home(primaryStage);
		
	}

	public void goToCart() {
		new CartView(primaryStage);
		
	}

	public void goToAccount() {
		new AccountInfo(primaryStage);
		
	}

	public void goToCheckOut() {
		 new CheckOut(primaryStage);
		
	}

	public void goToPayment() {
		new Payment(primaryStage);
	}

	public void goToPaymentSuccessful() {
		new PaymentSuccess(primaryStage);
	}
	
	public void goToProductView() {
		new ProductView(primaryStage);
	}

}
