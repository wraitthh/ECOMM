package application;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignUP  {
	String accountType = null;
	Controller c ;

    public SignUP(Stage primaryStage) {
        // Root container
        AnchorPane root = new AnchorPane();
        root.setPrefSize(490, 516);
        root.setStyle("-fx-background-color: #798C8A;");

        // Title Label
        Label titleLabel = new Label("SIGN UP");
        titleLabel.setFont(Font.font("Arial Bold", 19));
        titleLabel.setLayoutX(197);
        titleLabel.setLayoutY(8);

        // GridPane for form fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setLayoutX(27);
        grid.setLayoutY(49);
        grid.setPrefSize(435, 445);

        // Define column and row constraints
        ColumnConstraints col1 = new ColumnConstraints(170.666);
        col1.setHgrow(Priority.SOMETIMES);

        ColumnConstraints col2 = new ColumnConstraints(265.333);
        col2.setHgrow(Priority.SOMETIMES);

        grid.getColumnConstraints().addAll(col1, col2);

        for (int i = 0; i < 7; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            grid.getRowConstraints().add(row);
        }

        // Form Labels and Fields
        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(new Font(14));
        GridPane.setHalignment(nameLabel, HPos.CENTER);

        TextField nameField = new TextField();
        nameField.setPrefSize(225, 51);
        nameField.setPromptText("username");
        nameField.setStyle("-fx-background-color: #D0D9D8;");
        GridPane.setColumnIndex(nameField, 1);

        Label emailLabel = new Label("Email address: ");
        emailLabel.setFont(new Font(14));
        GridPane.setRowIndex(emailLabel, 1);
        GridPane.setHalignment(emailLabel, HPos.CENTER);

        TextField emailField = new TextField();
        emailField.setPrefSize(225, 51);
        emailField.setPromptText("name@gmail.com");
        emailField.setStyle("-fx-background-color: #D0D9D8;");
        GridPane.setColumnIndex(emailField, 1);
        GridPane.setRowIndex(emailField, 1);

        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setFont(new Font(14));
        GridPane.setRowIndex(phoneLabel, 2);
        GridPane.setHalignment(phoneLabel, HPos.CENTER);

        TextField phoneField = new TextField();
        phoneField.setPrefSize(225, 51);
        phoneField.setStyle("-fx-background-color: #D0D9D8;");
        GridPane.setColumnIndex(phoneField, 1);
        GridPane.setRowIndex(phoneField, 2);

        Label addressLabel = new Label("Address: ");
        addressLabel.setFont(new Font(14));
        GridPane.setRowIndex(addressLabel, 3);
        GridPane.setHalignment(addressLabel, HPos.CENTER);

        TextField addressField = new TextField();
        addressField.setPrefSize(225, 51);
        addressField.setStyle("-fx-background-color: #D0D9D8;");
        GridPane.setColumnIndex(addressField, 1);
        GridPane.setRowIndex(addressField, 3);

        Label passwordLabel = new Label("Create a Password: ");
        passwordLabel.setFont(new Font(14));
        GridPane.setRowIndex(passwordLabel, 4);
        GridPane.setHalignment(passwordLabel, HPos.CENTER);

        TextField passwordField = new TextField();
        passwordField.setPrefSize(225, 51);
        passwordField.setStyle("-fx-background-color: #D0D9D8;");
        GridPane.setColumnIndex(passwordField, 1);
        GridPane.setRowIndex(passwordField, 4);

        Label accountTypeLabel = new Label("Account Type: ");
        accountTypeLabel.setFont(new Font(14));
        GridPane.setRowIndex(accountTypeLabel, 5);

        RadioButton sellerRadio = new RadioButton("Seller");
        sellerRadio.setFont(new Font(14));
        GridPane.setColumnIndex(sellerRadio, 1);
        GridPane.setRowIndex(sellerRadio, 5);

        RadioButton customerRadio = new RadioButton("Customer");
        customerRadio.setFont(new Font(14));
        GridPane.setColumnIndex(customerRadio, 1);
        GridPane.setRowIndex(customerRadio, 5);
        GridPane.setHalignment(customerRadio, HPos.RIGHT);

        Button signUpButton = new Button("Create Account");
        signUpButton.setPrefSize(126, 53);
        signUpButton.setStyle("-fx-background-color: #2E3740; -fx-text-fill: #d0d9d8;");
        GridPane.setColumnIndex(signUpButton, 1);
        GridPane.setRowIndex(signUpButton, 6);
        GridPane.setHalignment(signUpButton, HPos.CENTER);
        
        
      
        
        ToggleGroup accountTypeGroup = new ToggleGroup();
        sellerRadio.setToggleGroup(accountTypeGroup);
        customerRadio.setToggleGroup(accountTypeGroup);
    
        
        
        sellerRadio.setOnAction(event ->{
        	accountType= "Seller";
        });
        customerRadio.setOnAction(event ->{
        	accountType= "Customer";
        });
        
        signUpButton.setOnAction(event -> {
            // Get values from fields
            String username = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String password = passwordField.getText();
            boolean isSeller = sellerRadio.isSelected();
            //boolean isCustomer = customerRadio.isSelected();

            
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || accountType==null) {
                System.out.println("Please fill in all required fields!");
            } else {
                System.out.println("Account Created!");
                System.out.println("Details:");
                System.out.println("Name: " + username);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("Password: " + password);
                System.out.println("Account Type: " + (isSeller ? "Seller" : "Customer"));
                passwordChecker.register(nameField, passwordField);
                signUpButton.setText("Account Created!");
                Controller c = new Controller(primaryStage);
                c.goToLogin();
                
               
            }
        });
        
        
        

        
        
        

        // Add all components to the grid
        grid.getChildren().addAll(
                nameLabel, nameField,
                emailLabel, emailField,
                phoneLabel, phoneField,
                addressLabel, addressField,
                passwordLabel, passwordField,
                accountTypeLabel, sellerRadio, customerRadio,
                signUpButton
        );

        // Add components to the root
        root.getChildren().addAll(titleLabel, grid);

        // Scene and Stage setup
        Scene scene = new Scene(root);
        primaryStage.setTitle("Sign Up Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
}
