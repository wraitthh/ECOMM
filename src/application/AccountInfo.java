package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class AccountInfo {

	public AccountInfo(Stage primaryStage) {

		Controller c = new Controller(primaryStage);
		AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #D0D9D8;");
        root.setPrefSize(601, 441);

        // Header Label
        Label headerLabel = new Label("ACCOUNT:");
        headerLabel.setLayoutX(72);
        headerLabel.setLayoutY(74);
        headerLabel.setPrefSize(149, 25);
        headerLabel.setFont(Font.font("System Bold Italic", 14));

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(1);
        scrollPane.setLayoutY(102);
        scrollPane.setPrefSize(600, 340);
        scrollPane.setStyle("-fx-background-color: #d0d9d8;");

        // ScrollPane content
        AnchorPane scrollContent = new AnchorPane();
        scrollContent.setPrefSize(590, 349);
        scrollContent.setStyle("-fx-background-color: #d0d9d8;");

        // GridPane
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(28);
        gridPane.setLayoutY(14);
        gridPane.setPrefSize(548, 221);

        // Column Constraints
        ColumnConstraints col1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        col1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints col2 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        col2.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().addAll(col1, col2);

        // Row Constraints
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Labels and Texts in GridPane
        Label nameLabel = createLabel("Name: ", 0);
        Label emailLabel = createLabel("Email: ", 1);
        Label phoneLabel = createLabel("Phone number: ", 2);
        Label addressLabel = createLabel("Address", 3);
        Label accountTypeLabel = createLabel("Account Type: ", 4);

        Text nameText = createText("Text", 0);
        Text emailText = createText("Text", 1);
        Text phoneText = createText("Text", 2);
        Text addressText = createText("Text", 3);
        Text accountTypeText = createText("Text", 4);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(phoneLabel, 0, 2);
        gridPane.add(addressLabel, 0, 3);
        gridPane.add(accountTypeLabel, 0, 4);

        gridPane.add(nameText, 1, 0);
        gridPane.add(emailText, 1, 1);
        gridPane.add(phoneText, 1, 2);
        gridPane.add(addressText, 1, 3);
        gridPane.add(accountTypeText, 1, 4);

        scrollContent.getChildren().add(gridPane);
        scrollPane.setContent(scrollContent);

        // Top HBox (Navigation Bar)
        HBox topBar = new HBox();
        topBar.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        topBar.setPrefSize(600, 64);
        topBar.setStyle("-fx-background-color: #798C8A;");

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setPrefSize(453, 64);

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

        // Adding components to the root
        root.getChildren().addAll(topBar, headerLabel, scrollPane);

        // Setting up the Stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Account Details");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	private Label createLabel(String text, int rowIndex) {
        Label label = new Label(text);
        label.setFont(Font.font("System Bold", 14));
        label.setPrefWidth(281);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        GridPane.setRowIndex(label, rowIndex);
        return label;
    }

    private Text createText(String text, int rowIndex) {
        Text displayText = new Text(text);
        displayText.setFont(Font.font(14));
        displayText.setWrappingWidth(270);
        displayText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setRowIndex(displayText, rowIndex);
        GridPane.setColumnIndex(displayText, 1);
        return displayText;
    }

    

}
