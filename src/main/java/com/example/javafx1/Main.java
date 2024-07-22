package com.example.javafx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main extends Application {

	private ConfigurableApplicationContext applicationContext;
	@Autowired
	private Controller controller;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));

		controller = loader.getController();


		AnchorPane rootAnchorPane = loader.load();
		Scene scene = new Scene(rootAnchorPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Manoj Gurjar");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
