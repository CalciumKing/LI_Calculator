package com.example.li_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class OtherCalculatorController {
    private final String Parenthasis_A = "(";
    private final String Parenthasis_B = ")";
    private final String Exponent = "^";
    private final String Multiply = "*";
    private final String Divide = "/";
    private final String Add = "+";
    private final String Subtract = "-";

    private boolean newInput = true;

    @FXML
    private Label math_label, currentEquationLabel;

    private double firstNumber;
    private String operator = "";
    private ArrayList<String> equation = new ArrayList<>();

    @FXML
    private void HandleNumber(ActionEvent event) {
        String number = ((Button) event.getSource()).getText();
        if (newInput) {
            math_label.setText(number);
            newInput = false;
        } else {
            math_label.setText(math_label.getText() + number);
        }
    }

    @FXML
    private void HandleOperation(ActionEvent event) {
        String operation = ((Button) event.getSource()).getText();
        if (!math_label.getText().isEmpty()) {
            firstNumber = Double.parseDouble(math_label.getText());
            operator = operation;
            newInput = true;
            AddToRunningEquation(firstNumber + String.valueOf(operator));
        }
    }

    @FXML
    private void HandleEquals(ActionEvent event) {
        double secondOperand = Double.parseDouble(math_label.getText());
        AddToRunningEquation(String.valueOf(secondOperand));
        SplitEquation();
        double result = SolveEquation(equation);
        math_label.setText(String.valueOf(result));
    }

    @FXML
    private void AddToRunningEquation(String toAdd) {
        currentEquationLabel.setText(currentEquationLabel.getText() + toAdd);
    }

    private void SplitEquation() {
        String stringEquation = currentEquationLabel.getText();
        StringBuilder currNumber = new StringBuilder();

        for (int i = 0; i < stringEquation.length(); i++) {
            char currentChar = stringEquation.charAt(i);
            if (Character.isDigit(currentChar) || currentChar == '.') {
                currNumber.append(currentChar);
            } else {
                if (!currNumber.isEmpty()) {
                    equation.add(currNumber.toString());
                    currNumber.setLength(0);
                }
                equation.add(String.valueOf(currentChar));
            }
        }
        if (!currNumber.isEmpty()) {
            equation.add(currNumber.toString());
        }
    }
    private double SolveEquation(ArrayList<String> equation) {
        PrintCurrentEquation(equation);
        SolveByOperator(equation, Exponent, "");
        SolveByOperator(equation, Multiply, Divide);
        SolveByOperator(equation, Add, Subtract);
        return Double.parseDouble(equation.get(0));
    }
    private void SolveByOperator(ArrayList<String> equation, String operator1, String operator2) {
        for (int i = 0; i < equation.size(); i++) {
            String currentElement = equation.get(i);
            if(currentElement.equals(operator1) || currentElement.equals(operator2)) {
                Double leftNum = Double.parseDouble(equation.get(i - 1));
                Double rightNum = Double.parseDouble(equation.get(i + 1));
                double result = 0;

                result = switch(currentElement) {
                    case Exponent -> Math.pow(leftNum, rightNum);
                    case Multiply -> leftNum * rightNum;
                    case Divide -> leftNum / rightNum;
                    case Add -> leftNum + rightNum;
                    case Subtract -> leftNum - rightNum;
                    default -> result;
                };
                equation.set(i - 1, String.valueOf(result));
                equation.remove(i + 1);
                equation.remove(i);
                i--;
            }
        }
    }
    private void PrintCurrentEquation(ArrayList<String> equation) {
        for(String s : equation) {
            System.out.print(s);
        }
    }

    private void ShowAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void Close() {
        System.exit(0);
    }
    @FXML
    private void Minimize() {
        Pane topPane = null;
        Stage stage = (Stage) topPane.getScene().getWindow();
        stage.setIconified(true);
    }
}