import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class CalculatorMainListener extends CalculatorBaseListener{

    Deque<Double> numbers = new ArrayDeque<>();

    @Override
    public void exitAdditionExpression(CalculatorParser.AdditionExpressionContext ctx) {
        System.out.println("exitAdditionExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            if (Objects.equals(ctx.getChild(i).getText(), "+")) {
                value += numbers.pop();
            } else {
                value = numbers.pop() - value;
            }
        }
        numbers.push(value);
    }

    @Override
    public void exitMultiplicationExpression(CalculatorParser.MultiplicationExpressionContext ctx) {
        System.out.println("exitMultiplicationExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            if (Objects.equals(ctx.getChild(i).getText(), "*")) {
                value *= numbers.pop();
            } else {
                value = numbers.pop() / value;
            }
        }
        numbers.push(value);
    }

    @Override
    public void exitExponentiationExpression(CalculatorParser.ExponentiationExpressionContext ctx) {
        System.out.println("exitExponentiationExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = ctx.getChildCount() - 2; i >= 1; i -= 2) {
            value = Math.pow(numbers.pop(), value);
        }
        numbers.push(value);
    }

    @Override
    public void exitNegationExpression(CalculatorParser.NegationExpressionContext ctx) {
        System.out.println("exitNegationExpression: " + ctx.getText());
        if (ctx.MINUS() != null) {
            numbers.push(-numbers.pop());
        }
    }

    @Override
    public void exitSqrtExpression(CalculatorParser.SqrtExpressionContext ctx) {
        System.out.println("exitSqrtExpression: " + ctx.getText());
        numbers.push(Math.sqrt(numbers.pop()));
    }

    @Override
    public void exitAtom(CalculatorParser.AtomContext ctx) {
        System.out.println("exitAtom: " + ctx.getText());
        numbers.push(Double.parseDouble(ctx.INT().getText()));
    }

    private Double getResult() {
        return numbers.pop();
    }

    public static void main(String[] args) {
        Double result = calc("1 - 2");
        System.out.println("Result = " + result);

        Double result1 = calc("2 + 4");
        System.out.println("Result = " + result1);

        Double result2 = calc("4 * 3");
        System.out.println("Result = " + result2);

        Double result3 = calc("4 / 2");
        System.out.println("Result = " + result3);

        Double result4 = calc("sqrt9");
        System.out.println("Result = " + result4);

        Double result5 = calc("2 ^ 3");
        System.out.println("Result = " + result5);

        Double resultX = calc("-2 + sqrt9 + 2 ^ 3 * 10");
        System.out.println("Result = " + resultX);

        Double resultY = calc("2 * 3 - 1 / -2");
        System.out.println("Result = " + resultY);

        Double resultZ = calc("3 ^ 2 - 7 * sqrt4 + sqrt5");
        System.out.println("Result = " + resultZ);

        Double resultQ = calc("sqrt16 - 3 * 4 / sqrt1 - 9 + -2");
        System.out.println("Result = " + resultQ);

        Double resultP = calc("4 + 3 * 4 - 9");
        System.out.println("Result = " + resultP);
    }

    public static Double calc(String expression) {
        CharStream input = CharStreams.fromString(expression);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.additionExpression();
        ParseTreeWalker walker = new ParseTreeWalker();
        CalculatorMainListener calculator = new CalculatorMainListener();
        walker.walk(calculator, tree);
        return calculator.getResult();
    }

}