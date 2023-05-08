// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(CalculatorParser.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(CalculatorParser.AdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(CalculatorParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(CalculatorParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#exponentiationExpression}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpression(CalculatorParser.ExponentiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#exponentiationExpression}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpression(CalculatorParser.ExponentiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#negationExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpression(CalculatorParser.NegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#negationExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpression(CalculatorParser.NegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#sqrtExpression}.
	 * @param ctx the parse tree
	 */
	void enterSqrtExpression(CalculatorParser.SqrtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#sqrtExpression}.
	 * @param ctx the parse tree
	 */
	void exitSqrtExpression(CalculatorParser.SqrtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CalculatorParser.AtomContext ctx);
}