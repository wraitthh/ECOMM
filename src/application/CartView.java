package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class CartView {

	public CartView(Stage primaryStage) {
		Controller c = new Controller(primaryStage);
		
		AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #D0D9D8;");
        root.setPrefSize(601, 441);

        // Top HBox
        HBox topBar = new HBox();
        topBar.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        topBar.setPrefSize(600, 64);
        topBar.setStyle("-fx-background-color: #798C8A;");
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setPrefSize(453, 64);

        // Labels and Button in TopBar
        Label homeLabel = new Label("HOME");
        homeLabel.setPrefHeight(61);
        homeLabel.setOnMouseClicked(event -> c.goToHome());
        Label cartLabel = new Label("CART");
        cartLabel.setPrefHeight(59);
        cartLabel.setOnMouseClicked(event -> c.goToCart());
        Label accountLabel = new Label("ACCOUNT");
        accountLabel.setPrefHeight(68);
        accountLabel.setOnMouseClicked(event -> c.goToAccount());

        Button logoutButton = new Button("Logout");
        logoutButton.setPrefSize(96, 31);
        logoutButton.setStyle("-fx-background-color: #1D2025;");
        logoutButton.setTextFill(javafx.scene.paint.Color.web("#d0d8d9"));
        logoutButton.setOnAction(event -> c.goToLogin());

        buttonBar.getButtons().addAll(homeLabel, cartLabel, accountLabel, logoutButton);
        topBar.getChildren().add(buttonBar);

        // Label
        Label cartLabelHeader = new Label("Your Cart:");
        cartLabelHeader.setLayoutX(72);
        cartLabelHeader.setLayoutY(74);
        cartLabelHeader.setFont(Font.font("System Bold Italic", 14));

        // ScrollPane and GridPane for the Cart
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(34);
        scrollPane.setLayoutY(99);
        scrollPane.setPrefSize(534, 283);

        AnchorPane scrollContent = new AnchorPane();
        scrollContent.setPrefSize(523, 284);

        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(521, 283);
        gridPane.setStyle("-fx-background-color: #798C8A;");
        gridPane.setGridLinesVisible(true);

        // Columns and Rows for GridPane
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(205.6667);
        col1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(316.3333);
        col2.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(93.3333);
        row1.setVgrow(Priority.SOMETIMES);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(100.6667);
        row2.setVgrow(Priority.SOMETIMES);
        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(90.0);
        row3.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().addAll(row1, row2, row3);

        // Adding ImageViews to GridPane
        ImageView imageView1 = new ImageView();
        imageView1.setFitHeight(97);
        imageView1.setFitWidth(200);
        imageView1.setPreserveRatio(true);
        imageView1.setPickOnBounds(true);
        gridPane.add(imageView1, 0, 0);

        ImageView imageView2 = new ImageView();
        imageView2.setFitHeight(97);
        imageView2.setFitWidth(200);
        imageView2.setPreserveRatio(true);
        imageView2.setPickOnBounds(true);
        gridPane.add(imageView2, 0, 1);

        ImageView imageView3 = new ImageView();
        imageView3.setFitHeight(78);
        imageView3.setFitWidth(200);
        imageView3.setPreserveRatio(true);
        imageView3.setPickOnBounds(true);
        gridPane.add(imageView3, 0, 2);

        scrollContent.getChildren().add(gridPane);
        scrollPane.setContent(scrollContent);

        // Checkout Button
        Button checkoutButton = new Button("Proceed to Checkout");
        checkoutButton.setLayoutX(374);
        checkoutButton.setLayoutY(394);
        checkoutButton.setPrefSize(157, 31);
        checkoutButton.setStyle("-fx-background-color: #1d2025;");
        checkoutButton.setTextFill(javafx.scene.paint.Color.web("#d0d9d8"));
        checkoutButton.setOnAction(event -> c.goToCheckOut());

        // Adding all components to root
        root.getChildren().addAll(topBar, cartLabelHeader, scrollPane, checkoutButton);

        // Setting up the Stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Shopping Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
		
	}

