import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Random;

public class ExpressionsManager {
    public static final int EASY_EXPRESSION = 2;
    public static final int MEDIUM_EXPRESSION = 4;
    public static final int HARD_EXPRESSION = 6;

    private static final String OPERATORS = "+-*";

    private StringBuilder expression;

    public static StringBuilder generateExpression(int complexity) {
        StringBuilder expr;
        int termsCount = 0;

        expr = new StringBuilder("");
        while (complexity + 1 > termsCount) {
            String next = randomNumberOrOperator();
            expr.append(next).append(" ");
            termsCount++;
        }
        return expr;
    }

    private static short number = 0;

    private static String randomNumberOrOperator() {
        Random random = new Random();
        String result;
        if (number % 2 == 0) {
            result = String.valueOf(random.nextInt(100) + 1);
        } else {
            result = String.valueOf(OPERATORS.charAt(random.nextInt(OPERATORS.length())));
        }
        number++;
        return result;
    }
}
