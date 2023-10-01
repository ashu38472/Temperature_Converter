package com.tempconv.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TemperatureConverter extends Application {
    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("Temp_Convertor_Layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Temperature Converter Tool");
        stage.show();
    }
    private MenuBar  createMenu(){
        //file menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenu = new MenuItem("New");
        newMenu.setOnAction(actionEvent -> System.out.println("new is clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem quiteMenu = new MenuItem("Quite");
        quiteMenu.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenu,separatorMenuItem,quiteMenu);

        //help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenu = new MenuItem("About");
        aboutMenu.setOnAction(actionEvent -> aboutApp());


        helpMenu.getItems().addAll(aboutMenu);
        //menuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDilog = new Alert(Alert.AlertType.INFORMATION);
        alertDilog.setTitle("About me");
        alertDilog.setHeaderText("Learning JavaFX");
        alertDilog.setContentText("I am just a beginner but soon I will be pro");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDilog.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clikedBtn = alertDilog.showAndWait();

        if(clikedBtn.isPresent() && clikedBtn.get()==yesBtn){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }
}