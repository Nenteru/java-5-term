package org.example.windowcalculartor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class ExpressionsManager {
    public static final int EASY_EXPRESSION = 2;
    public static final int MEDIUM_EXPRESSION = 4;
    public static final int HARD_EXPRESSION = 6;

    private static final String OPERATORS = "+-*";

    private StringBuilder expression;

    public static String generateExpression(int complexity) {
        StringBuilder expr;
        int termsCount = 0;

        expr = new StringBuilder("");
        while (complexity + 1 > termsCount) {
            String next = randomNumberOrOperator();
            expr.append(next).append(" ");
            termsCount++;
        }
        number = 0;
        return ExpressionTree.addBrackets(expr.toString());
    }

    private static short number = 0;

    private static String randomNumberOrOperator() {
        Random random = new Random();
        String result;
        if (number % 2 == 0) {
            result = String.valueOf(random.nextInt(20) + 1);
        } else {
            result = String.valueOf(OPERATORS.charAt(random.nextInt(OPERATORS.length())));
        }
        number++;
        return result;
    }
}

//---

class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class ExpressionTree {

    public static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 2;
        }
        if (op.equals("*") || op.equals("/")) {
            return 1;
        }
        return 0;
    }

    public static List<String> toPostfix(String expression) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {  // If token is a number
                output.add(token);
            } else {  // If token is an operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    public static Node buildExpressionTree(List<String> postfix) {
        Stack<Node> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+")) {  // If token is a number
                stack.push(new Node(token));
            } else {  // If token is an operator
                Node node = new Node(token);
                node.right = stack.pop();  // Right child
                node.left = stack.pop();  // Left child
                stack.push(node);
            }
        }

        return stack.peek();
    }

    public static String generateExpression(Node node) {
        if (node.left == null && node.right == null) {
            return node.value;
        }
        String leftExpr = generateExpression(node.left);
        String rightExpr = generateExpression(node.right);
        return "(" + leftExpr + " " + node.value + " " + rightExpr + ")";
    }

    public static String addBrackets(String expression) {
        List<String> postfix = toPostfix(expression);
        Node root = buildExpressionTree(postfix);
        String bracketedExpression = generateExpression(root);

        // Remove outer brackets if they exist
        if (bracketedExpression.startsWith("(") && bracketedExpression.endsWith(")")) {
            bracketedExpression = bracketedExpression.substring(1, bracketedExpression.length() - 1);
        }

        return bracketedExpression;
    }
}