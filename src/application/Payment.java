package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Payment {

	public Payment(Stage primaryStage) {
		Controller c = new Controller(primaryStage);
		 AnchorPane root = new AnchorPane();
	        root.setStyle("-fx-background-color: #D0D9D8;");

	        // HBox for the header
	        HBox header = new HBox();
	        header.setAlignment(javafx.geometry.Pos.TOP_CENTER);
	        header.setPrefHeight(65);
	        header.setStyle("-fx-background-color: #798C8A;");
	        header.setPadding(new Insets(5, 0, 0, 0));
	        
	        header.prefWidthProperty().bind(root.widthProperty());

	        ButtonBar buttonBar = new ButtonBar();
	        buttonBar.setPrefHeight(64);

	        // Buttons in ButtonBar
	        Label homeLabel = new Label("HOME");
	        homeLabel.setPrefHeight(55);
	        homeLabel.setOnMouseClicked(event -> c.goToHome());

	        Label cartLabel = new Label("CART");
	        cartLabel.setPrefHeight(55);
	        cartLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
	        cartLabel.setOnMouseClicked(event -> c.goToCart());

	        Label accountLabel = new Label("ACCOUNT");
	        accountLabel.setPrefHeight(57);
	        accountLabel.setOnMouseClicked(event -> c.goToAccount());

	        Button logoutButton = new Button("Logout");
	        logoutButton.setPrefHeight(31);
	        logoutButton.setPrefWidth(96);
	        logoutButton.setStyle("-fx-background-color: #1D2025;");
	        logoutButton.setTextFill(javafx.scene.paint.Color.web("#d0d8d9"));
	        logoutButton.setOnAction(event -> c.goToLogin());

	        buttonBar.getButtons().addAll(homeLabel, cartLabel, accountLabel, logoutButton);
	        header.getChildren().add(buttonBar);
	        root.getChildren().add(header);

	        // Label and Button for payment action
	        Label paymentLabel = new Label("Payment: ");
	        paymentLabel.setLayoutX(72);
	        paymentLabel.setLayoutY(74);
	        paymentLabel.setFont(Font.font("System Bold Italic", 14));

	        Label totalBillLabel = new Label("Total Bill: $");
	        totalBillLabel.setLayoutX(228);
	        totalBillLabel.setLayoutY(71);
	        totalBillLabel.setFont(Font.font("System Italic", 14));

	        Button paymentButton = new Button("Make Payment");
	        paymentButton.setLayoutX(434);
	        paymentButton.setLayoutY(410);
	        paymentButton.setPrefHeight(31);
	        paymentButton.setPrefWidth(157);
	        paymentButton.setStyle("-fx-background-color: #1d2025;");
	        paymentButton.setTextFill(javafx.scene.paint.Color.web("#d0d9d8"));
	        paymentButton.setOnAction(event -> c.goToPaymentSuccessful());

	        root.getChildren().addAll(paymentLabel, totalBillLabel, paymentButton);

	        // GridPane for the payment form
	        GridPane paymentGrid = new GridPane();
	        paymentGrid.setLayoutX(24);
	        paymentGrid.setLayoutY(128);
	        paymentGrid.setPrefHeight(261);
	        paymentGrid.setPrefWidth(585);
	        paymentGrid.setHgap(10);
	        paymentGrid.setVgap(10);

	        ColumnConstraints col1 = new ColumnConstraints();
	        col1.setPrefWidth(167);
	        paymentGrid.getColumnConstraints().add(col1);
	        ColumnConstraints col2 = new ColumnConstraints();
	        col2.setPrefWidth(418);
	        paymentGrid.getColumnConstraints().add(col2);

	        RowConstraints row1 = new RowConstraints();
	        row1.setPrefHeight(35);
	        paymentGrid.getRowConstraints().add(row1);
	        RowConstraints row2 = new RowConstraints();
	        row2.setPrefHeight(43);
	        paymentGrid.getRowConstraints().add(row2);
	        RowConstraints row3 = new RowConstraints();
	        row3.setPrefHeight(43);
	        paymentGrid.getRowConstraints().add(row3);
	        RowConstraints row4 = new RowConstraints();
	        row4.setPrefHeight(49);
	        paymentGrid.getRowConstraints().add(row4);
	        RowConstraints row5 = new RowConstraints();
	        row5.setPrefHeight(45);
	        paymentGrid.getRowConstraints().add(row5);
	        RowConstraints row6 = new RowConstraints();
	        row6.setPrefHeight(48);
	        paymentGrid.getRowConstraints().add(row6);

	        // Payment Method Label and Radio Buttons
	        Label paymentMethodLabel = new Label("Select a Payment Method: ");
	        paymentGrid.add(paymentMethodLabel, 0, 0);

	        HBox paymentMethods = new HBox();
	        RadioButton creditCardRadio = new RadioButton("Credit Card");
	        RadioButton debitCardRadio = new RadioButton("Debit Card");
	        RadioButton onlineBankingRadio = new RadioButton("Online Banking");
	        RadioButton cashRadio = new RadioButton("Cash");

	        paymentMethods.getChildren().addAll(creditCardRadio, debitCardRadio, onlineBankingRadio, cashRadio);
	        paymentGrid.add(paymentMethods, 1, 0);

	        // Card Number Field
	        Label cardNumberLabel = new Label("Enter your Card Number: ");
	        paymentGrid.add(cardNumberLabel, 0, 1);
	        TextField cardNumberField = new TextField();
	        paymentGrid.add(cardNumberField, 1, 1);

	        // Mobile Number Field
	        Label mobileNumberLabel = new Label("Enter Mobile Number: ");
	        paymentGrid.add(mobileNumberLabel, 0, 2);
	        TextField mobileNumberField = new TextField();
	        paymentGrid.add(mobileNumberField, 1, 2);

	        // Expiration Date Field
	        Label expDateLabel = new Label("Enter Expiration Date: ");
	        paymentGrid.add(expDateLabel, 0, 3);
	        TextField expDateField = new TextField();
	        paymentGrid.add(expDateField, 1, 3);

	        // PIN Field
	        Label pinLabel = new Label("Enter PIN: ");
	        paymentGrid.add(pinLabel, 0, 4);
	        TextField pinField = new TextField();
	        paymentGrid.add(pinField, 1, 4);

	        // CVV Field
	        Label cvvLabel = new Label("Enter CVV: ");
	        paymentGrid.add(cvvLabel, 0, 5);
	        TextField cvvField = new TextField();
	        paymentGrid.add(cvvField, 1, 5);

	        root.getChildren().add(paymentGrid);

	        // Cash Payment Confirmation Label
	        Label cashPaymentLabel = new Label("You have chosen to Pay Cash on Delivery");
	        cashPaymentLabel.setLayoutX(92);
	        cashPaymentLabel.setLayoutY(404);
	        cashPaymentLabel.setFont(Font.font("System Bold", 12));
	        root.getChildren().add(cashPaymentLabel);

	        // Set Scene and Stage
	        Scene scene = new Scene(root, 628, 479);
	        primaryStage.setTitle("Payment Application");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}

}
