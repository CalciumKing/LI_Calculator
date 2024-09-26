package com.example.li_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
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
        String[] temp = math_label.getText().split("");
        ArrayList<String> equation = new ArrayList<>(Arrays.asList(temp));
        System.out.println("Length = " + equation.size());
//        System.out.println(Arrays.toString(equation));

        int i = 1;
        int equationLength = equation.size();
        String firstNum = "";
        String secondNum = "";

        for(int j = 0; j < equationLength; j++) {
            if(!equation.get(j).contains("+") &&
                !equation.get(j).contains("-") &&
                !equation.get(j).contains("*") &&
                !equation.get(j).contains("/"))
                firstNum += equation.get(j);
            else
                break;
        }

        while(equationLength >= 1) {
/*            for(String s : equation)
                if(s != null && !s.isEmpty())
                    equationLength++;

            if(equation[i] == null || equation[i].isEmpty())
                continue;*/

            System.out.println(equationLength + " Length: " + equation);
//            for(int j = 0; j < equation.length - 1; j++) {
//                if(equation[j] != null && !equation[j].isEmpty() && "0123456789".contains(equation[j])) {
//                    firstNum = equation[j];
//                    for (int k = j + 1; k < equationLength; k++) {
//                        if (equation[k] != null && !equation[k].isEmpty() && "0123456789".contains(equation[k])) {
//                            secondNum = equation[k];
//                            break;
//                        }
//                    }
//                    break;
//                }
//            }
//            System.out.println("First: " + firstNum + ", Second: " + secondNum);

            switch (equation.get(i).charAt(0)) {
                case '+':
//                    firstNum = String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
//                    secondNum = "";
                    for(int j = i + 1; j < equationLength; j++) {
                        if(!equation.get(j).contains("+"))
                            secondNum += equation.get(j);
                        else
                            break;
                    }
//                    for(int j = i - 1; j >= 0; j--) {
//                        if(!equation.get(j).contains("+") && !equation.get(j).isEmpty() && equation.get(j) != null) {
//                            secondNum += equation.get(j) + secondNum;
//                        }
//                    }

                    System.out.println(firstNum + " " + secondNum);
                    equation.remove(equation.get(i - 1));
                    equation.remove(equation.get(i));
                    equation.set(i + 1, String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum)));
                    break;
/*                case '-':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) - Integer.parseInt(equation[i + 1]));
                    break;
                case '*':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) * Integer.parseInt(equation[i + 1]));
                    break;
                case '/':
                    updated[i] = String.valueOf(Integer.parseInt(equation[i - 1]) / Integer.parseInt(equation[i + 1]));
                    break;*/
            }
            equationLength -= 2;
            i++;
        }

        Clear();
        for (String s : equation) {
            System.out.println(s);
            if(s != null && !s.isEmpty())
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