package application;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class CheckOut {

	public CheckOut(Stage primaryStage) {
		Controller c = new Controller(primaryStage);
		
		 AnchorPane anchorPane = new AnchorPane();
	        anchorPane.setStyle("-fx-background-color: #D0D9D8;");
	        anchorPane.setPrefSize(601, 441);

	        // Create the HBox with a ButtonBar for the navigation bar
	        HBox hBox = new HBox();
	        hBox.setAlignment(Pos.TOP_CENTER);
	        hBox.setStyle("-fx-background-color: #798C8A;");
	        hBox.setPrefSize(600, 64);

	        ButtonBar buttonBar = new ButtonBar();
	        buttonBar.setPrefSize(453, 64);

	        Label homeLabel = new Label("HOME");
	        homeLabel.setAlignment(Pos.CENTER);
	        homeLabel.setPrefHeight(55);
	        homeLabel.setOnMouseClicked(e -> c.goToHome());

	        Label cartLabel = new Label("CART");
	        cartLabel.setAlignment(Pos.CENTER);
	        cartLabel.setPrefHeight(55);
	        cartLabel.setOnMouseClicked(e -> c.goToCart());

	        Label accountLabel = new Label("ACCOUNT");
	        accountLabel.setAlignment(Pos.CENTER);
	        accountLabel.setPrefHeight(57);
	        accountLabel.setOnMouseClicked(e -> c.goToAccount());

	        Button logoutButton = new Button("Logout");
	        logoutButton.setStyle("-fx-background-color: #1D2025;");
	        logoutButton.setTextFill(javafx.scene.paint.Color.web("#d0d9d9"));
	        logoutButton.setPrefHeight(31);
	        logoutButton.setPrefWidth(96);
	        logoutButton.setOnAction(e -> c.goToLogin());

	        buttonBar.getButtons().addAll(homeLabel, cartLabel, accountLabel, logoutButton);
	        hBox.getChildren().add(buttonBar);
	        anchorPane.getChildren().add(hBox);

	        // Create the ScrollPane containing the GridPane
	        ScrollPane scrollPane = new ScrollPane();
	        scrollPane.setLayoutX(34);
	        scrollPane.setLayoutY(99);
	        scrollPane.setPrefSize(534, 283);

	        AnchorPane scrollPaneAnchor = new AnchorPane();
	        scrollPaneAnchor.setPrefSize(529, 295);

	        GridPane gridPane = new GridPane();
	        gridPane.setStyle("-fx-background-color: #798C8A;");
	        gridPane.setPrefSize(534, 283);
	        gridPane.setGridLinesVisible(true);

	        ColumnConstraints column1 = new ColumnConstraints();
	        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
	        column1.setPrefWidth(65);
	        column1.setMaxWidth(256);

	        ColumnConstraints column2 = new ColumnConstraints();
	        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
	        column2.setPrefWidth(209);

	        ColumnConstraints column3 = new ColumnConstraints();
	        column3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
	        column3.setPrefWidth(316);

	        RowConstraints row1 = new RowConstraints();
	        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
	        row1.setPrefHeight(93);

	        RowConstraints row2 = new RowConstraints();
	        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
	        row2.setPrefHeight(100);

	        RowConstraints row3 = new RowConstraints();
	        row3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
	        row3.setPrefHeight(90);

	        gridPane.getColumnConstraints().addAll(column1, column2, column3);
	        gridPane.getRowConstraints().addAll(row1, row2, row3);

	        // Add ImageViews
	        ImageView imageView1 = new ImageView();
	        imageView1.setFitHeight(97);
	        imageView1.setFitWidth(200);
	        imageView1.setPreserveRatio(true);
	        gridPane.add(imageView1, 1, 0);

	        ImageView imageView2 = new ImageView();
	        imageView2.setFitHeight(97);
	        imageView2.setFitWidth(200);
	        imageView2.setPreserveRatio(true);
	        gridPane.add(imageView2, 1, 1);

	        ImageView imageView3 = new ImageView();
	        imageView3.setFitHeight(78);
	        imageView3.setFitWidth(200);
	        imageView3.setPreserveRatio(true);
	        gridPane.add(imageView3, 1, 2);

	        // Add CheckBoxes
	        CheckBox checkBox1 = new CheckBox();
	        checkBox1.setPrefSize(28, 43);
	        checkBox1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
	        checkBox1.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
	        gridPane.add(checkBox1, 0, 0);

	        CheckBox checkBox2 = new CheckBox();
	        checkBox2.setPrefSize(28, 43);
	        checkBox2.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
	        checkBox2.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
	        gridPane.add(checkBox2, 0, 1);

	        CheckBox checkBox3 = new CheckBox();
	        checkBox3.setPrefSize(28, 43);
	        checkBox3.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
	        checkBox3.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
	        gridPane.add(checkBox3, 0, 2);

	        scrollPaneAnchor.getChildren().add(gridPane);
	        scrollPane.setContent(scrollPaneAnchor);
	        anchorPane.getChildren().add(scrollPane);

	        // Create Labels
	        Label cartLabelText = new Label("Your Cart:");
	        cartLabelText.setFont(Font.font("System Bold Italic", 14));
	        cartLabelText.setLayoutX(72);
	        cartLabelText.setLayoutY(74);
	        cartLabelText.setPrefSize(149, 25);

	        Label totalBillLabel = new Label("Total Bill: $");
	        totalBillLabel.setFont(Font.font("System Italic", 14));
	        totalBillLabel.setLayoutX(34);
	        totalBillLabel.setLayoutY(394);
	        totalBillLabel.setPrefSize(177, 31);

	        // Create Purchase Button
	        Button purchaseButton = new Button("Purchase");
	        purchaseButton.setStyle("-fx-background-color: #1d2025;");
	        purchaseButton.setTextFill(javafx.scene.paint.Color.web("#d0d9d9"));
	        purchaseButton.setLayoutX(456);
	        purchaseButton.setLayoutY(394);
	        purchaseButton.setPrefSize(111, 31);
	        purchaseButton.setOnAction(e -> c.goToPayment());

	        // Add all the created elements to the AnchorPane
	        anchorPane.getChildren().addAll(cartLabelText, totalBillLabel, purchaseButton);

	        // Set the scene and show the stage
	        Scene scene = new Scene(anchorPane, 601, 441);
	        primaryStage.setTitle("Your Cart");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}

}
