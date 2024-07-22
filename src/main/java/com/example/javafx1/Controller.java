package com.example.javafx1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ResourceBundle;

@RestController
public class Controller implements Initializable {

	@FXML
	public Label username;

	@FXML
	public Label password;

	@FXML
	public TextField textfield;

	@FXML
	public PasswordField passwordfield;

	@FXML
	public Label register;

	@FXML
	public Button button;

	public void handleRegister(){
		String username = textfield.getText();
		String password = passwordfield.getText();

		try {
		button.setOnAction(actionEvent -> {
			if (button.isArmed()){
				//System.out.println("Button is clicked");
				Platform.exit();
				System.exit(0);
			}
		});

			String query = "INSERT INTO register values('"+username+"', '"+password+"')";

			Alert alert;
			if (username.isEmpty() || password.isEmpty()) {
				alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Username or Password can't be empty");
			}else{
				alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("Account created successfully");
			}
			alert.show();
		}catch (Exception exception){
			exception.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}
}
