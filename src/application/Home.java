package application;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
		
		public class Home {
		
			Controller c;
		   public Home(Stage primaryStage) { // Root container
			   c = new Controller(primaryStage);
		    AnchorPane root = new AnchorPane();
		    root.setStyle("-fx-background-color: #D0D9D8; -fx-pref-width: 600; -fx-pref-height: 550;");
		    root.setPrefSize(558, 468);
		
		    // Search field
		    TextField searchField = new TextField();
		    searchField.setPromptText("Search");
		    searchField.setStyle("-fx-border-color: #1D2025;");
		    searchField.setPrefSize(275, 31);
		    AnchorPane.setLeftAnchor(searchField, 68.0);
		    AnchorPane.setTopAnchor(searchField, 72.0);
		
		    // Labels
		    Label categoryLabel = new Label("CATEGORY:");
		    AnchorPane.setLeftAnchor(categoryLabel, 41.0);
		    AnchorPane.setTopAnchor(categoryLabel, 117.0);
		
		    Label sortByLabel = new Label("Sort By: ");
		    AnchorPane.setLeftAnchor(sortByLabel, 373.0);
		    AnchorPane.setTopAnchor(sortByLabel, 119.0);
		
		    Label numItemsLabel = new Label("num+items found");
		    numItemsLabel.setVisible(false);
		    AnchorPane.setLeftAnchor(numItemsLabel, 125.0);
		    AnchorPane.setTopAnchor(numItemsLabel, 158.0);
		
		    Label itemNameLabel = new Label("ItemName: ");
		    itemNameLabel.setFont(Font.font("System Bold", 12));
		    itemNameLabel.setVisible(false);
		    AnchorPane.setLeftAnchor(itemNameLabel, 48.0);
		    AnchorPane.setTopAnchor(itemNameLabel, 160.0);
		
		    // ChoiceBoxes
		    ChoiceBox<String> categoryChoiceBox = new ChoiceBox<>();
		    AnchorPane.setLeftAnchor(categoryChoiceBox, 117.0);
		    AnchorPane.setTopAnchor(categoryChoiceBox, 117.0);
		
		    ChoiceBox<String> sortByChoiceBox = new ChoiceBox<>();
		    sortByChoiceBox.setPrefSize(141, 25);
		    AnchorPane.setLeftAnchor(sortByChoiceBox, 418.0);
		    AnchorPane.setTopAnchor(sortByChoiceBox, 117.0);
		
		    // ScrollPane with GridPane
		    GridPane gridPane = new GridPane();
		    gridPane.setStyle("-fx-background-color: #4C5359;");
		    gridPane.getColumnConstraints().addAll(
		            new ColumnConstraints(283.67), // Column 1
		            new ColumnConstraints(270.33) // Column 2
		    );
		    gridPane.getRowConstraints().addAll(
		            new RowConstraints(170.33), // Row 1
		            new RowConstraints(177.67) // Row 2
		    );
		
		    for (int row = 0; row < 2; row++) {
		        for (int col = 0; col < 2; col++) {
		            StackPane stackPane = new StackPane();
		            Rectangle rectangle = new Rectangle(252, 151, Color.web("#d0d9d8"));
		            rectangle.setArcHeight(5.0);
		            rectangle.setArcWidth(5.0);
		
		            VBox vBox = new VBox();
		            vBox.setAlignment(javafx.geometry.Pos.CENTER);
		            ImageView imageView = new ImageView();
		            imageView.setFitHeight(107);
		            imageView.setFitWidth(179);
		
		            Label label = new Label("Label");
		            label.setFont(new Font(22));
		            label.setTextFill(Color.web("#1c1f24"));
		
		            vBox.getChildren().addAll(imageView, label);
		            stackPane.getChildren().addAll(rectangle, vBox);
		
		            gridPane.add(stackPane, col, row);
		        }
		    }
		
		    ScrollPane scrollPane = new ScrollPane(gridPane);
		    scrollPane.setPrefSize(577, 355);
		    AnchorPane.setLeftAnchor(scrollPane, 14.0);
		    AnchorPane.setTopAnchor(scrollPane, 189.0);
		
		    // HBox (Bottom Bar)
		    HBox bottomBar = new HBox();
		    bottomBar.setAlignment(javafx.geometry.Pos.TOP_CENTER);
		    bottomBar.setPrefSize(600, 64);
		    bottomBar.setStyle("-fx-background-color: #798C8A;");
		
		    ButtonBar buttonBar = new ButtonBar();
		    buttonBar.setPrefSize(453, 64);
		
		    Label homeLabel = new Label("HOME");
		    homeLabel.setOnMouseClicked(event -> {
		    	System.out.println("going to home");
		    	c.goToHome();
		    });
		    homeLabel.setPrefHeight(61);
		
		    Label cartLabel = new Label("CART");
		    cartLabel.setOnMouseClicked(event -> {
		    	c.goToCart();
		    });
		    cartLabel.setPrefHeight(57);
		
		    Label accountLabel = new Label("ACCOUNT");
		    accountLabel.setOnMouseClicked(event -> {
		    	c.goToAccount();
		    });
		    accountLabel.setPrefHeight(58);
		
		    Button logoutButton = new Button("Logout");
		    logoutButton.setOnAction(event -> {
		    	c.goToLogin();
		    });
		    logoutButton.setStyle("-fx-background-color: #1D2025;");
		    logoutButton.setTextFill(Color.web("#d0d8d9"));
		    logoutButton.setPrefSize(96, 31);
		
		    buttonBar.getButtons().addAll(homeLabel, cartLabel, accountLabel, logoutButton);
		    bottomBar.getChildren().add(buttonBar);
		
		    // Search Icon
		    ImageView searchIcon = new ImageView(new Image("file:src/resources/search(1).png"));
		    searchIcon.setFitHeight(31);
		    searchIcon.setFitWidth(32);
		    AnchorPane.setLeftAnchor(searchIcon, 32.0);
		    AnchorPane.setTopAnchor(searchIcon, 72.0);
		
		    // Add all children to root
		    root.getChildren().addAll(
		            searchField, categoryLabel, sortByLabel, numItemsLabel, itemNameLabel,
		            categoryChoiceBox, sortByChoiceBox, scrollPane, bottomBar, searchIcon
		    );
		
		    // Scene and Stage
		    Scene scene = new Scene(root);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("FXML to Java Example");
		    primaryStage.show();
		   
		}
		
	}
