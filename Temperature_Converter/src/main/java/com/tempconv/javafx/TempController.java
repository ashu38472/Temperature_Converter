package com.tempconv.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TempController implements Initializable {

    @FXML
    public Label wlcamLabel;
    @FXML
    public TextField textField;
    @FXML
    public ChoiceBox choiceBox;
    @FXML
    public Button convertBtn;

    private static final String C_To_F = "Celsius to Fahrenheit";
    private static final String F_To_C ="Fahrenheit to Celsius";
    private boolean isC_To_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().addAll(C_To_F,F_To_C);
        choiceBox.setValue(C_To_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            if(t1!=C_To_F){
                isC_To_F=false;
            }
        });

        convertBtn.setOnAction(actionEvent ->{
            Convert();
        });

    }

    private void Convert() {
        String input = textField.getText();
        float enterdTemp = 0.0f;
        try {
            enterdTemp = Float.parseFloat(input);
        }catch (Exception ex){
            warning();
            return;
        }
        float newTemp = 0.0f;

        if(isC_To_F){
            newTemp= (enterdTemp*9/5)+32;
        }else {
            newTemp= (enterdTemp-32)*5/9;
        }
        display(newTemp);

    }

    private void warning() {
        Alert warn = new Alert(Alert.AlertType.ERROR);
        warn.setTitle("ERROR");
        warn.setHeaderText("Invalid Temperature Entered");
        warn.setContentText("Please enter a valid temperature");
        warn.show();
    }

    private void display(float newTemp) {
        String unit = isC_To_F? " F":" C";
        System.out.println("The new temp is "+newTemp+unit);

        Alert output = new Alert(Alert.AlertType.INFORMATION);
        output.setTitle("Result");
        output.setContentText("The new temp is "+newTemp+unit);
        output.show();
    }


    public void createPlayground() {
    }


}