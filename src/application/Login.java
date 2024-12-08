package application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Login {
	
	Controller c;
	
	
	public Login(Stage primaryStage) {
	
		 c = new Controller(primaryStage);
	    // Create the root AnchorPane
        AnchorPane root = new AnchorPane();
        root.setPrefSize(391, 390);
        root.setStyle("-fx-background-color: #D0D9D8;");

        // Rectangle background
        Rectangle rectangle = new Rectangle(45, 98, 303, 174);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setFill(Paint.valueOf("#798C8A"));
        rectangle.setStroke(Color.BLACK);

        // Labels
        Label loginLabel = new Label("LOGIN");
        loginLabel.setLayoutX(164);
        loginLabel.setLayoutY(73);
        loginLabel.setFont(Font.font("System Bold Italic", 18));
        loginLabel.setTextFill(Paint.valueOf("#4C5359"));

        Label forgotPasswordLabel = new Label("Forgot Your Password?");
        forgotPasswordLabel.setLayoutX(83);
        forgotPasswordLabel.setLayoutY(283);

        Label signUpPromptLabel = new Label("Don't Have an Account?");
        signUpPromptLabel.setLayoutX(174);
        signUpPromptLabel.setLayoutY(23);

        // Buttons
        Button forgotPasswordButton = new Button("Click Here");
        forgotPasswordButton.setLayoutX(217);
        forgotPasswordButton.setLayoutY(279);
        forgotPasswordButton.setStyle("-fx-background-color: #4C5359;");
        forgotPasswordButton.setTextFill(Paint.valueOf("#D0D9D8"));


        Button signUpButton = new Button("Sign Up");
        signUpButton.setLayoutX(310);
        signUpButton.setLayoutY(19);
        signUpButton.setStyle("-fx-background-color: #4C5359;");
        signUpButton.setTextFill(Paint.valueOf("#D0D9D8"));
        signUpButton.setOnAction(e -> goToSignUp());

        // GridPane for login form
        GridPane loginForm = new GridPane();
        loginForm.setLayoutX(66);
        loginForm.setLayoutY(139);
        loginForm.setPrefSize(253, 90);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(70.33);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(182.33);

        loginForm.getColumnConstraints().addAll(column1, column2);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(30);

        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(30);

        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(30);

        loginForm.getRowConstraints().addAll(row1, row2, row3);

        // Add form components
        Label usernameLabel = new Label("Username");
        TextField loginUser = new TextField();
        loginUser.setPromptText("username or email");
        loginUser.setStyle("-fx-background-color: #D0D9D8;");

        Label passwordLabel = new Label("Password");
        PasswordField loginPass = new PasswordField();
        loginPass.setPromptText("password");
        loginPass.setStyle("-fx-background-color: #D0D9D8;");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #4C5359;");
        submitButton.setTextFill(Paint.valueOf("#D0D9D8"));
        
        

        loginForm.add(usernameLabel, 0, 0);
        loginForm.add(loginUser, 1, 0);
        loginForm.add(passwordLabel, 0, 1);
        loginForm.add(loginPass, 1, 1);
        loginForm.add(submitButton, 1, 2);

        // Unsuccessful login label
        Label unsuccessfulLabel = new Label("Login Failed. Incorrect Password or username");
        unsuccessfulLabel.setLayoutX(80);
        unsuccessfulLabel.setLayoutY(320);
        unsuccessfulLabel.setPrefSize(263, 35);
        unsuccessfulLabel.setVisible(false);
        
        submitButton.setOnAction(e -> {
       	 System.out.println("Login attempt with username: " + loginUser.getText() + " and password: " + loginPass.getText());
        	if(passwordChecker.login(loginUser, loginPass))
    			c.goToHome();
    		else
    			unsuccessfulLabel.setVisible(true);
       });

        // Add components to root
        root.getChildren().addAll(rectangle, loginLabel, forgotPasswordLabel, signUpPromptLabel, 
                                  forgotPasswordButton, signUpButton, loginForm, unsuccessfulLabel);

        // Set up the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login UI");
        primaryStage.show();
    }

    private void goToSignUp() {
        System.out.println("Sign Up button clicked!");
        c.goToSignUp();
    }

   

   
	
}
