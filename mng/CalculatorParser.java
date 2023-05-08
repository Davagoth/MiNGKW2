// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final int
			SQRT=1, INT=2, PLUS=3, MINUS=4, MULT=5, DIV=6, POW=7, WS=8;
	public static final int
			RULE_additionExpression = 0, RULE_multiplicationExpression = 1, RULE_exponentiationExpression = 2,
			RULE_negationExpression = 3, RULE_sqrtExpression = 4, RULE_atom = 5;
	private static String[] makeRuleNames() {
		return new String[] {
				"additionExpression", "multiplicationExpression", "exponentiationExpression",
				"negationExpression", "sqrtExpression", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'sqrt'", null, "'+'", "'-'", "'*'", "'/'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
				null, "SQRT", "INT", "PLUS", "MINUS", "MULT", "DIV", "POW", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditionExpressionContext extends ParserRuleContext {
		public List<MultiplicationExpressionContext> multiplicationExpression() {
			return getRuleContexts(MultiplicationExpressionContext.class);
		}
		public MultiplicationExpressionContext multiplicationExpression(int i) {
			return getRuleContext(MultiplicationExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CalculatorParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CalculatorParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CalculatorParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CalculatorParser.MINUS, i);
		}
		public AdditionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterAdditionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitAdditionExpression(this);
		}
	}

	public final AdditionExpressionContext additionExpression() throws RecognitionException {
		AdditionExpressionContext _localctx = new AdditionExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_additionExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(12);
				multiplicationExpression();
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS || _la==MINUS) {
					{
						{
							setState(13);
							_la = _input.LA(1);
							if ( !(_la==PLUS || _la==MINUS) ) {
								_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(14);
							multiplicationExpression();
						}
					}
					setState(19);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExpressionContext extends ParserRuleContext {
		public List<ExponentiationExpressionContext> exponentiationExpression() {
			return getRuleContexts(ExponentiationExpressionContext.class);
		}
		public ExponentiationExpressionContext exponentiationExpression(int i) {
			return getRuleContext(ExponentiationExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(CalculatorParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(CalculatorParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(CalculatorParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CalculatorParser.DIV, i);
		}
		public MultiplicationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitMultiplicationExpression(this);
		}
	}

	public final MultiplicationExpressionContext multiplicationExpression() throws RecognitionException {
		MultiplicationExpressionContext _localctx = new MultiplicationExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_multiplicationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(20);
				exponentiationExpression();
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MULT || _la==DIV) {
					{
						{
							setState(21);
							_la = _input.LA(1);
							if ( !(_la==MULT || _la==DIV) ) {
								_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(22);
							exponentiationExpression();
						}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExponentiationExpressionContext extends ParserRuleContext {
		public List<NegationExpressionContext> negationExpression() {
			return getRuleContexts(NegationExpressionContext.class);
		}
		public NegationExpressionContext negationExpression(int i) {
			return getRuleContext(NegationExpressionContext.class,i);
		}
		public List<TerminalNode> POW() { return getTokens(CalculatorParser.POW); }
		public TerminalNode POW(int i) {
			return getToken(CalculatorParser.POW, i);
		}
		public ExponentiationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentiationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterExponentiationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitExponentiationExpression(this);
		}
	}

	public final ExponentiationExpressionContext exponentiationExpression() throws RecognitionException {
		ExponentiationExpressionContext _localctx = new ExponentiationExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exponentiationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(28);
				negationExpression();
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==POW) {
					{
						{
							setState(29);
							match(POW);
							setState(30);
							negationExpression();
						}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NegationExpressionContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SqrtExpressionContext sqrtExpression() {
			return getRuleContext(SqrtExpressionContext.class,0);
		}
		public NegationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterNegationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitNegationExpression(this);
		}
	}

	public final NegationExpressionContext negationExpression() throws RecognitionException {
		NegationExpressionContext _localctx = new NegationExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_negationExpression);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case MINUS:
					enterOuterAlt(_localctx, 1);
				{
					setState(36);
					match(MINUS);
					setState(37);
					atom();
				}
				break;
				case INT:
					enterOuterAlt(_localctx, 2);
				{
					setState(38);
					atom();
				}
				break;
				case SQRT:
					enterOuterAlt(_localctx, 3);
				{
					setState(39);
					sqrtExpression();
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqrtExpressionContext extends ParserRuleContext {
		public TerminalNode SQRT() { return getToken(CalculatorParser.SQRT, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SqrtExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqrtExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterSqrtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitSqrtExpression(this);
		}
	}

	public final SqrtExpressionContext sqrtExpression() throws RecognitionException {
		SqrtExpressionContext _localctx = new SqrtExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sqrtExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(42);
				match(SQRT);
				setState(43);
				atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CalculatorParser.INT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(45);
				match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
			"\u0004\u0001\b0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
					"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
					"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0010"+
					"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
					"\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001\u0002\u0001"+
					"\u0002\u0001\u0002\u0005\u0002 \b\u0002\n\u0002\f\u0002#\t\u0002\u0001"+
					"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003)\b\u0003\u0001"+
					"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0000"+
					"\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0002\u0001\u0000\u0003"+
					"\u0004\u0001\u0000\u0005\u0006.\u0000\f\u0001\u0000\u0000\u0000\u0002"+
					"\u0014\u0001\u0000\u0000\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006"+
					"(\u0001\u0000\u0000\u0000\b*\u0001\u0000\u0000\u0000\n-\u0001\u0000\u0000"+
					"\u0000\f\u0011\u0003\u0002\u0001\u0000\r\u000e\u0007\u0000\u0000\u0000"+
					"\u000e\u0010\u0003\u0002\u0001\u0000\u000f\r\u0001\u0000\u0000\u0000\u0010"+
					"\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011"+
					"\u0012\u0001\u0000\u0000\u0000\u0012\u0001\u0001\u0000\u0000\u0000\u0013"+
					"\u0011\u0001\u0000\u0000\u0000\u0014\u0019\u0003\u0004\u0002\u0000\u0015"+
					"\u0016\u0007\u0001\u0000\u0000\u0016\u0018\u0003\u0004\u0002\u0000\u0017"+
					"\u0015\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019"+
					"\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a"+
					"\u0003\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c"+
					"!\u0003\u0006\u0003\u0000\u001d\u001e\u0005\u0007\u0000\u0000\u001e \u0003"+
					"\u0006\u0003\u0000\u001f\u001d\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000"+
					"\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0005"+
					"\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005\u0004\u0000"+
					"\u0000%)\u0003\n\u0005\u0000&)\u0003\n\u0005\u0000\')\u0003\b\u0004\u0000"+
					"($\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000"+
					"\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000+,\u0003"+
					"\n\u0005\u0000,\t\u0001\u0000\u0000\u0000-.\u0005\u0002\u0000\u0000.\u000b"+
					"\u0001\u0000\u0000\u0000\u0004\u0011\u0019!(";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}