import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class CalculatorMainListener extends CalculatorBaseListener {

    Deque<Double> numbers = new ArrayDeque<>();

    @Override
    public void exitExpression(CalculatorParser.ExpressionContext ctx) {
        System.out.println("exitExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            if (Objects.equals(ctx.getChild(i).getText(), "+")) {
                value += numbers.pop();
            } else {
                value -= numbers.pop();
            }
        }
        numbers.push(value);
        super.exitExpression(ctx);
    }


    @Override
    public void exitMultiplicationExpression(CalculatorParser.MultiplicationExpressionContext ctx) {
        System.out.println("exitMultiplicationExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            if (Objects.equals(ctx.getChild(i).getText(), "*")) {
                value *= numbers.pop();
            } else {
                value /= numbers.pop();
            }
        }
        numbers.push(value);
        super.exitMultiplicationExpression(ctx);
    }

    @Override
    public void exitPowExpression(CalculatorParser.PowExpressionContext ctx) {
        System.out.println("exitPowExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            value = Math.pow(value, numbers.pop());
        }
        numbers.push(value);
        super.exitPowExpression(ctx);
    }

    @Override
    public void exitIntegralExpression(CalculatorParser.IntegralExpressionContext ctx) {
        System.out.println("exitIntegralExpression: " + ctx.getText());
        if (ctx.MINUS() != null) {
            numbers.add(-1 * Double.parseDouble(ctx.getChild(1).getText()));
        } else if (ctx.getChildCount() == 1) {
            numbers.add(Double.valueOf(ctx.getChild(0).getText()));
        } else {
            numbers.add(Math.sqrt(numbers.pop()));
        }
        super.exitIntegralExpression(ctx);
    }

    private Double getResult() {
        return numbers.peek();
    }

    public static void main(String[] args) {
        Double result = calc("2 * 3 - 1 / 2");
        System.out.println("Result = " + result);
        Double result1 = calc("2 + 9");
        System.out.println("Result = " + result1);
        Double result2 = calc("9 - 3");
        System.out.println("Result = " + result2);
        Double result3 = calc("3 * 2");
        System.out.println("Result = " + result3);
        Double result4 = calc("8 / 4");
        System.out.println("Result = " + result4);
        Double result5 = calc("3 ^ 2");
        System.out.println("Result = " + result5);
        Double result6 = calc("sqrt5");
        System.out.println("Result = " + result6);
    }

    public static Double calc(String expression) {
        return calc(CharStreams.fromString(expression));
    }

    public static Double calc(CharStream charStream) {
        CalculatorLexer lexer = new CalculatorLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expression();

        ParseTreeWalker walker = new ParseTreeWalker();
        CalculatorMainListener mainListener = new CalculatorMainListener();
        walker.walk(mainListener, tree);
        return mainListener.getResult();
    }
}