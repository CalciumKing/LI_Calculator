package com.example.li_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;

public class MainController {
    @FXML
    private Label math_label;

    // region Mr Riley's Code
    /*double firstNum;
    boolean isNewNumber;
    String operator;
    void appendNumber(ActionEvent event) {
        Button button = (Button) event.getSource();
        int num = Integer.parseInt(button.getText());
        if (isNewNumber) {
            math_label.setText("");
            math_label.setText(String.valueOf(num));
            isNewNumber = false;
        } else
            math_label.setText(math_label.getText() + num);
    }
    void selectOperator(ActionEvent event) {
        Button button = (Button) event.getSource();
        operator = button.getText();
        firstNum = Double.parseDouble(math_label.getText());
        isNewNumber = true;
    }
    void calculate(ActionEvent event) {
        double secondNum = Double.parseDouble(math_label.getText());
        math_label.setText(firstNum + " " + operator + " " + secondNum);
        switch (operator) {
            case "+":
                firstNum += secondNum;
                break;
            case "-":
                firstNum -= secondNum;
                break;
            case "*":
                firstNum *= secondNum;
                break;
            case "/":
                if (secondNum != 0)
                    firstNum /= secondNum;
                else
                    math_label.setText("Error");
                break;
        }
        math_label.setText(String.valueOf(firstNum));
    }*/
    // endregion

    @FXML
    private void AddMath(ActionEvent event) {
        Button button = (Button) event.getSource();
        math_label.setText(math_label.getText() + button.getText());
        /*if("0123456789".contains(button.getText()))
            math_label.setText(math_label.getText() + button.getText());
        else
            math_label.setText(math_label.getText() + " " + button.getText() + " ");*/
    }

    @FXML
    private void Clear() {
        math_label.setText("");
    }

    @FXML
    private void Equals() {
        String[] equation = math_label.getText().split("");
        System.out.println("Length = " + equation.length);
        System.out.println(Arrays.toString(equation));
        String[] updated = new String[equation.length];

        int i = 0;
        while(updated.length > 1) {
            switch (equation[i].charAt(0)) {
                case '+':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) + Integer.parseInt(equation[i + 1]));
                    System.out.println(updated[i]);
//                    equation[i - 1] = "";
//                    equation[i] = "";
//                    equation[i + 1] = "";
                    break;
                case '-':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) - Integer.parseInt(equation[i + 1]));
                    break;
                case '*':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) * Integer.parseInt(equation[i + 1]));
                    break;
                case '/':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) / Integer.parseInt(equation[i + 1]));
                    break;
            }
            i++;
        }

        Clear();
        for (String s : updated) {
            System.out.println(s);
            if(s != null)
                math_label.setText(math_label.getText() + s);
        }

        /*if(numSymbols >= 0)
            Equals();
        int[] nums = new int[equation.length];
        char[] symbols = new char[equation.length];
        for(int i = 0; i < equation.length; i++) {
            if("0123456789".contains(equation[i]))
                nums[i] = Integer.parseInt(equation[i]);
            else
                symbols[i] = equation[i].charAt(0);
        }*/
    }
}