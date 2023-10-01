module com.tempconv.javafx.temperature_converter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tempconv.javafx to javafx.fxml;
    exports com.tempconv.javafx;
}