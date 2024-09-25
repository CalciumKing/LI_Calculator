module com.example.li_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.li_calculator to javafx.fxml;
    exports com.example.li_calculator;
}