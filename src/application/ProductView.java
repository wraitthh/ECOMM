package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ProductView {

	public ProductView(Stage primaryStage) {
		Controller c = new Controller(primaryStage);
		  AnchorPane root = new AnchorPane();
	        root.setPrefSize(600, 450);
	        root.setStyle("-fx-background-color: #D0D9D8;");

	        // ScrollPane
	        ScrollPane scrollPane = new ScrollPane();
	        scrollPane.setLayoutY(62);
	        scrollPane.setPrefSize(600, 388);

	        AnchorPane scrollContent = new AnchorPane();
	        scrollContent.setPrefSize(583, 700);

	        // Rectangle and ImageView for product image
	        Rectangle productImageBackground = new Rectangle(311, 199);
	        productImageBackground.setLayoutX(25);
	        productImageBackground.setLayoutY(64);
	        productImageBackground.setArcHeight(5);
	        productImageBackground.setArcWidth(5);
	        productImageBackground.setFill(Color.valueOf("#2e3740"));
	        productImageBackground.setStroke(Color.BLACK);

	        ImageView productImage = new ImageView();
	        productImage.setFitWidth(291);
	        productImage.setFitHeight(180);
	        productImage.setLayoutX(35);
	        productImage.setLayoutY(74);

	        // Product details rectangle
	        Rectangle productDetailsBackground = new Rectangle(200, 279);
	        productDetailsBackground.setLayoutX(359);
	        productDetailsBackground.setLayoutY(64);
	        productDetailsBackground.setArcHeight(5);
	        productDetailsBackground.setArcWidth(5);
	        productDetailsBackground.setFill(Color.valueOf("#798c8a"));
	        productDetailsBackground.setStroke(Color.BLACK);

	        // TextField for search
	        TextField searchField = new TextField();
	        searchField.setLayoutX(45);
	        searchField.setLayoutY(14);
	        searchField.setPrefSize(275, 31);
	        searchField.setPromptText("Search");
	        searchField.setStyle("-fx-border-color: #1D2025;");

	        // VBox for product properties
	        VBox productProperties = new VBox();
	        productProperties.setLayoutX(45);
	        productProperties.setLayoutY(314);
	        productProperties.setPrefSize(275, 323);

	        Label propertiesLabel = new Label("Properties:");
	        Label detailsLabel = new Label("jkghk");
	        Label descriptionLabel = new Label("Description:");
	        Label descriptionText = new Label("Label");

	        productProperties.getChildren().addAll(propertiesLabel, detailsLabel, descriptionLabel, descriptionText);

	        // Button for "Add to Cart"
	        Button addToCartButton = new Button("Add to Cart");
	        addToCartButton.setLayoutX(409);
	        addToCartButton.setLayoutY(291);
	        addToCartButton.setPrefSize(99, 31);
	        addToCartButton.setStyle("-fx-background-color: #1D2025;");
	        addToCartButton.setTextFill(Color.valueOf("#d0d9d8"));

	        // Labels for product name and price
	        Label nameLabel = new Label("NAME");
	        nameLabel.setLayoutX(375);
	        nameLabel.setLayoutY(85);
	        nameLabel.setPrefSize(167, 64);
	        nameLabel.setTextFill(Color.valueOf("#2e2740"));
	        nameLabel.setFont(new Font(14));

	        Label priceLabel = new Label("PRICE");
	        priceLabel.setLayoutX(375);
	        priceLabel.setLayoutY(149);
	        priceLabel.setPrefSize(167, 64);
	        priceLabel.setTextFill(Color.valueOf("#2e2740"));
	        priceLabel.setFont(new Font(14));

	        // HBox for stock availability
	        HBox stockHBox = new HBox();
	        stockHBox.setLayoutX(362);
	        stockHBox.setLayoutY(211);
	        stockHBox.setPrefSize(193, 34);

	        Label stockLabel = new Label("Stock Available:");
	        stockLabel.setPrefSize(111, 33);
	        stockLabel.setFont(new Font(14));

	        Label stockValueLabel = new Label("Yes");
	        stockValueLabel.setPrefSize(97, 33);
	        stockValueLabel.setFont(new Font(14));

	        stockHBox.getChildren().addAll(stockLabel, stockValueLabel);

	        // Search Icon
	        ImageView searchIcon = new ImageView(new Image("file:src/resources/search(1).png"));
	        searchIcon.setFitWidth(31);
	        searchIcon.setFitHeight(31);
	        searchIcon.setLayoutX(9);
	        searchIcon.setLayoutY(14);

	        // Adding components to scroll content
	        scrollContent.getChildren().addAll(
	                productImageBackground, productImage, productDetailsBackground,
	                searchField, productProperties, addToCartButton,
	                nameLabel, priceLabel, stockHBox, searchIcon
	        );
	        scrollPane.setContent(scrollContent);

	        // Top navigation bar
	        HBox topBar = new HBox();
	        topBar.setAlignment(javafx.geometry.Pos.TOP_CENTER);
	        topBar.setPrefSize(600, 64);
	        topBar.setStyle("-fx-background-color: #798C8A;");

	        ButtonBar buttonBar = new ButtonBar();
	        buttonBar.setPrefSize(453, 64);

	        Label homeLabel = new Label("HOME");
	        homeLabel.setOnMouseClicked(event -> {
		    	System.out.println("going to home");
		    	c.goToHome();
		    });
	        Label cartLabel = new Label("CART");
	        cartLabel.setOnMouseClicked(event -> {
		    	c.goToCart();
		    });
	        Label accountLabel = new Label("ACCOUNT");
	        accountLabel.setOnMouseClicked(event -> {
		    	c.goToAccount();
		    });

	        Button logoutButton = new Button("Logout");
	        logoutButton.setPrefSize(96, 31);
	        logoutButton.setStyle("-fx-background-color: #1D2025;");
	        logoutButton.setTextFill(Color.valueOf("#d0d9d9"));
	        logoutButton.setOnAction(event -> {
		    	c.goToLogin();
		    });

	        buttonBar.getButtons().addAll(homeLabel, cartLabel, accountLabel, logoutButton);
	        topBar.getChildren().add(buttonBar);

	        // Adding components to root
	        root.getChildren().addAll(scrollPane, topBar);

	        // Setting the scene
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Product Details");
	        primaryStage.show();
	}

}
