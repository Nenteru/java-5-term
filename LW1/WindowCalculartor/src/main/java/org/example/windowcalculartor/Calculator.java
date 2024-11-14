package org.example.windowcalculartor;

import java.util.Stack;

public class Calculator {
    public static double evaluate(String input) {
        /*
         * evaluate method takes a string input and evaluates it as a mathematical
         * expression
         * using two stacks, one for operands and one for operators.
         * It uses the Shunting Yard algorithm to convert the input string from infix
         * notation to postfix notation
         * and then evaluates it.
         */
        double result = 0;
        char[] inputArr = input.toCharArray();
        // Create two stacks, one for operands and one for operators
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        // Iterate through the input array
        for (int i = 0; i < inputArr.length; i++) {
            // If the current character is a digit, add it to the operands stack, otherwise
            // add it to the operators stack
            if (inputArr[i] == ' ') {
                continue;
            }
            if (inputArr[i] >= '0' && inputArr[i] <= '9') {
                // if the character is a digit, push it onto the operands stack
                StringBuilder sb = new StringBuilder();
                while (i < inputArr.length && (inputArr[i] >= '0' && inputArr[i] <= '9' || inputArr[i] == '.')) {
                    sb.append(inputArr[i++]);
                }
                operands.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (inputArr[i] == '(') {
                // if the character is an open parenthesis, push it onto the operators stack
                operators.push(inputArr[i]);
            } else if (inputArr[i] == ')') {
                // if the character is a close parenthesis, pop operators and operands from
                // their stacks and apply them until an open parenthesis is found
                while (operators.peek() != '(') {
                    operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop();
            } else if (inputArr[i] == '+' || inputArr[i] == '-' || inputArr[i] == '*' || inputArr[i] == '/') {
                // if the character is an operator, pop operators and operands from their stacks
                // and apply them until the current operator has higher precedence
                while (!operators.empty() && hasPrecedence(inputArr[i], operators.peek())) {
                    operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(inputArr[i]);
            }
        }
        // pop remaining operators and operands from their stacks and apply them
        while (!operators.empty()) {
            operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
        }
        result = operands.pop();
        return result;
    }

    // hasPrecedence method checks the precedence of the operators
    // It returns true if the operator passed as the first argument has higher or
    // equal precedence than the operator passed as the second argument
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    // applyOp method applies the operator passed as the first argument to the
    // operands passed as the second and third arguments.
    // It returns the result of the operation
    private static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

}