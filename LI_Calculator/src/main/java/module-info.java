module com.example.li_calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.li_calculator to javafx.fxml;
    exports com.example.li_calculator;
}