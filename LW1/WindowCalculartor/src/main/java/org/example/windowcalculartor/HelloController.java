package org.example.windowcalculartor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Label expressionText;
    @FXML
    public TextField answerTextField;
    @FXML
    private Label welcomeText;

    private List<String> answers = new ArrayList<>();

    @FXML
    protected void checkAnswerButtonClick() {
        String stringAnswer = answerTextField.getText();

        int intAnswer = 0;
        try {
            intAnswer = Integer.parseInt(stringAnswer);
        }
        catch(NumberFormatException exception) {
            welcomeText.setText("Не верно");
            //return;
        }

        // Check expression
        String stringCorrectAnswer = expressionText.getText();
        int correctAnswer = (int) Calculator.evaluate(stringCorrectAnswer);

        String answer;
        if(intAnswer == correctAnswer)
            answer = "Верно";
        else
            answer = "Не верно";

        welcomeText.setText(answer);
        answers.add("");

        genNextExpressionButtonClick();
    }

    @FXML
    protected void genNextExpressionButtonClick() {
        // Generate new expression
        String expression = ExpressionsManager.generateExpression(6);
        expressionText.setText(expression);
    }
}