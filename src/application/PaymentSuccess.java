package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class PaymentSuccess {

	public PaymentSuccess(Stage primaryStage) {
		Controller c = new Controller(primaryStage);
		AnchorPane root = new AnchorPane();
        root.setPrefSize(457, 304);
        root.setStyle("-fx-background-color: #D0D9D8;");

        // Label: "You have chosen to Pay Cash on Delivery"
        Label codLabel = new Label("You have chosen to Pay Cash on Delivery");
        codLabel.setLayoutX(92);
        codLabel.setLayoutY(404);
        codLabel.setPrefSize(244, 43);
        codLabel.setFont(new Font("System Bold", 12));

        // Rectangle for background
        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(51);
        rectangle.setLayoutY(59);
        rectangle.setWidth(351);
        rectangle.setHeight(200);
        rectangle.setArcWidth(5);
        rectangle.setArcHeight(5);
        rectangle.setFill(Color.valueOf("#798c8a"));
        rectangle.setStroke(Color.BLACK);

        // Label: "Your Payment was Successful!"
        Label paymentSuccessLabel = new Label("Your Payment was Successful!");
        paymentSuccessLabel.setLayoutX(77);
        paymentSuccessLabel.setLayoutY(85);
        paymentSuccessLabel.setPrefSize(273, 73);
        paymentSuccessLabel.setAlignment(javafx.geometry.Pos.CENTER);
        paymentSuccessLabel.setFont(new Font("System Bold", 19));

        // Label: "Thank you for Shopping with Us!"
        Label thankYouLabel = new Label("Thank you for Shopping with Us!");
        thankYouLabel.setLayoutX(60);
        thankYouLabel.setLayoutY(152);
        thankYouLabel.setPrefSize(319, 73);
        thankYouLabel.setAlignment(javafx.geometry.Pos.CENTER);
        thankYouLabel.setFont(new Font("System Bold", 19));

        // Label: "Back to Home"
        Label backToHomeLabel = new Label("Back to Home");
        backToHomeLabel.setLayoutX(155);
        backToHomeLabel.setLayoutY(203);
        backToHomeLabel.setPrefSize(132, 43);
        backToHomeLabel.setAlignment(javafx.geometry.Pos.CENTER);
        backToHomeLabel.setStyle("-fx-background-color: #1d2025;");
        backToHomeLabel.setTextFill(Color.valueOf("#d0d9d8"));
        backToHomeLabel.setOnMouseClicked(event -> c.goToHome());

        // Add all components to the root pane
        root.getChildren().addAll(codLabel, rectangle, paymentSuccessLabel, thankYouLabel, backToHomeLabel);

        // Set the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Payment Successful");
        primaryStage.show();
	}

}
