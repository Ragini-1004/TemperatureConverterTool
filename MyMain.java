package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args){
		System.out.println("Main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		//rootNode.getChildren().addAll(menuBar);
		rootNode.getChildren().add(0,menuBar); //add menubar to vbox
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}

	private  MenuBar createMenu(){
		//File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(actionEvent -> System.out.println("New menu item clicked.."));  //lambda expression
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});
		/*
			quitMenuItem.setOnAction(actionEvent -> {
			Platform.exit();  //shut down current application
			System.exit(0);   //shut down virtual machine
		});
		*/
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(actionEvent -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);
		//Menubar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);//add menu to menu bar
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop Application");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon i will be pro and start developing awesome java games.");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);//set buttons to alert dialog box
		Optional<ButtonType> clickedBtn  = alertDialog.showAndWait();//to visible the dialog box on screen

		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
			System.out.println("Yes Button Clicked !");
		} else if (clickedBtn.isPresent() && clickedBtn.get() == noBtn)
			System.out.println("No Button Clicked !");


	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}
