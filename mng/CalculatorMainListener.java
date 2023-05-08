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
        super.exitAdditionExpression(ctx);
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
        super.exitMultiplicationExpression(ctx);
    }

    @Override
    public void exitExponentiationExpression(CalculatorParser.ExponentiationExpressionContext ctx) {
        System.out.println("exitExponentiationExpression: " + ctx.getText());
        Double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            value = Math.pow(numbers.pop(), value);
        }
        numbers.push(value);
        super.exitExponentiationExpression(ctx);
    }

    @Override
    public void exitNegationExpression(CalculatorParser.NegationExpressionContext ctx) {
        System.out.println("exitNegationExpression: " + ctx.getText());
        if (ctx.MINUS() != null) {
            numbers.push(-numbers.pop());
        }
        super.exitNegationExpression(ctx);
    }

    @Override
    public void exitSqrtExpression(CalculatorParser.SqrtExpressionContext ctx) {
        System.out.println("exitSqrtExpression: " + ctx.getText());
        numbers.push(Math.sqrt(numbers.pop()));
        super.exitSqrtExpression(ctx);
    }

    @Override
    public void exitAtom(CalculatorParser.AtomContext ctx) {
        System.out.println("exitAtom: " + ctx.getText());
        numbers.push(Double.parseDouble(ctx.INT().getText()));
        super.exitAtom(ctx);
    }

    private Double getResult() {
        return numbers.pop();
    }

    public static void main(String[] args) {
        Double result1 = calc("2 + 4");
        System.out.println("Result1 = " + result1);

        Double result2 = calc("1 - 2");
        System.out.println("Result2 = " + result2);

        Double result3 = calc("4 * 3");
        System.out.println("Result3 = " + result3);

        Double result4 = calc("2 / 3");
        System.out.println("Result4 = " + result4);

        Double result5 = calc("sqrt9");
        System.out.println("Result5 = " + result5);

        Double result6 = calc("2 ^ 3");
        System.out.println("Result6 = " + result6);

        Double resultA = calc("-2 + sqrt3 + 2 ^ 3 * 10");
        System.out.println("ResultA = " + resultA);// -3 + 1,732 + 8 * 10 = -0,268 + 80 = 79,732

        Double resultB = calc("2 * 3 - 1 / -2 ^ 3");
        System.out.println("ResultB = " + resultB);// 6 - 1 / -8 = 6 + 0,125 = 6,125
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