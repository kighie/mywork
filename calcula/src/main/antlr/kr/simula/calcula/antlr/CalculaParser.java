// Generated from Calcula.g4 by ANTLR 4.4

	package kr.simula.calcula.antlr;
	
	import java.util.List;
	import java.util.LinkedList;
	
	import kr.simula.calcula.core.*;
	import kr.simula.calcula.core.builder.*;
	import kr.simula.calcula.def.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, NUMBER=21, STRING_LITERAL=22, BOOLEAN=23, 
		IDENT=24, WS=25, COMMENT=26, MULTILINE_COMMENT=27, NEGATION=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "'>='", "'<'", "'='", "'>'", "'or'", "'<='", 
		"'<>'", "'%'", "'&'", "'('", "')'", "'and'", "'*'", "'+'", "'not'", "','", 
		"'-'", "'.'", "NUMBER", "STRING_LITERAL", "BOOLEAN", "IDENT", "WS", "COMMENT", 
		"MULTILINE_COMMENT", "NEGATION"
	};
	public static final int
		RULE_formulaExpression = 0, RULE_formulaExpressionBase = 1, RULE_funcCallExp = 2, 
		RULE_methodCallExp = 3, RULE_arguments = 4, RULE_formulaTerm = 5, RULE_qualifiedName = 6, 
		RULE_unary = 7, RULE_multiplicative = 8, RULE_additiveExpression = 9, 
		RULE_stringExpression = 10, RULE_comparison = 11, RULE_notExpression = 12, 
		RULE_logicalExpression = 13, RULE_operatorExpression = 14;
	public static final String[] ruleNames = {
		"formulaExpression", "formulaExpressionBase", "funcCallExp", "methodCallExp", 
		"arguments", "formulaTerm", "qualifiedName", "unary", "multiplicative", 
		"additiveExpression", "stringExpression", "comparison", "notExpression", 
		"logicalExpression", "operatorExpression"
	};

	@Override
	public String getGrammarFileName() { return "Calcula.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  	private CalculaHandler handler;
	  	
	  	public CalculaParser(TokenStream input, CalculaHandler calculaHandler){
	  		this(input);
	  		setBuilder(calculaHandler);
	  	}
	  	
	  	public void setBuilder(CalculaHandler calculaHandler){
	  		this.handler = calculaHandler;
	  	}
	  	

		public String strip( String text ) {
	    	if( text != null && text.length() >= 4 ) {
	    		text = text.substring( 1, text.length() - 1 );
	    		text = text.replaceAll( "\'", "'" );
	    		text = text.replaceAll( "\"", "\\\"" );
	    	}
	    	return text;
		}

	public CalculaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormulaExpressionContext extends ParserRuleContext {
		public Node result;
		public FormulaExpressionBaseContext formulaExpressionBase;
		public FormulaExpressionBaseContext formulaExpressionBase() {
			return getRuleContext(FormulaExpressionBaseContext.class,0);
		}
		public FormulaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterFormulaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitFormulaExpression(this);
		}
	}

	public final FormulaExpressionContext formulaExpression() throws RecognitionException {
		FormulaExpressionContext _localctx = new FormulaExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formulaExpression);
		try {
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(30); match(T__15);
				setState(31); match(T__8);
				setState(32); ((FormulaExpressionContext)_localctx).formulaExpressionBase = formulaExpressionBase();
				setState(33); match(T__7);
				 ((FormulaExpressionContext)_localctx).result =  ((FormulaExpressionContext)_localctx).formulaExpressionBase.result ; 
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(36); match(T__15);
				setState(37); ((FormulaExpressionContext)_localctx).formulaExpressionBase = formulaExpressionBase();
				 ((FormulaExpressionContext)_localctx).result =  ((FormulaExpressionContext)_localctx).formulaExpressionBase.result ; 
				}
				}
				break;
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

	public static class FormulaExpressionBaseContext extends ParserRuleContext {
		public Node result;
		public OperatorExpressionContext operatorExpression;
		public FuncCallExpContext funcCallExp;
		public MethodCallExpContext methodCallExp;
		public MethodCallExpContext methodCallExp() {
			return getRuleContext(MethodCallExpContext.class,0);
		}
		public FuncCallExpContext funcCallExp() {
			return getRuleContext(FuncCallExpContext.class,0);
		}
		public OperatorExpressionContext operatorExpression() {
			return getRuleContext(OperatorExpressionContext.class,0);
		}
		public FormulaExpressionBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulaExpressionBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterFormulaExpressionBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitFormulaExpressionBase(this);
		}
	}

	public final FormulaExpressionBaseContext formulaExpressionBase() throws RecognitionException {
		FormulaExpressionBaseContext _localctx = new FormulaExpressionBaseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formulaExpressionBase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(42); ((FormulaExpressionBaseContext)_localctx).operatorExpression = operatorExpression();
				 ((FormulaExpressionBaseContext)_localctx).result =  ((FormulaExpressionBaseContext)_localctx).operatorExpression.result ; 
				}
				break;
			case 2:
				{
				setState(45); ((FormulaExpressionBaseContext)_localctx).funcCallExp = funcCallExp();
				 ((FormulaExpressionBaseContext)_localctx).result =   ((FormulaExpressionBaseContext)_localctx).funcCallExp.result ; 
				}
				break;
			case 3:
				{
				setState(48); ((FormulaExpressionBaseContext)_localctx).methodCallExp = methodCallExp();
				 ((FormulaExpressionBaseContext)_localctx).result =   ((FormulaExpressionBaseContext)_localctx).methodCallExp.result ; 
				}
				break;
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

	public static class FuncCallExpContext extends ParserRuleContext {
		public Gettable result;
		public Token IDENT;
		public ArgumentsContext arguments;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(CalculaParser.IDENT, 0); }
		public FuncCallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterFuncCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitFuncCallExp(this);
		}
	}

	public final FuncCallExpContext funcCallExp() throws RecognitionException {
		FuncCallExpContext _localctx = new FuncCallExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcCallExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); ((FuncCallExpContext)_localctx).IDENT = match(IDENT);
			setState(54); match(T__8);
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(55); ((FuncCallExpContext)_localctx).arguments = arguments();
				}
				break;
			}
			setState(58); match(T__7);
			 ((FuncCallExpContext)_localctx).result =  handler.functionCall((((FuncCallExpContext)_localctx).IDENT!=null?((FuncCallExpContext)_localctx).IDENT.getText():null), ((FuncCallExpContext)_localctx).arguments.nodeList) ;
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

	public static class MethodCallExpContext extends ParserRuleContext {
		public Node result;
		public QualifiedNameContext qualifiedName;
		public Token IDENT;
		public ArgumentsContext arguments;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(CalculaParser.IDENT, 0); }
		public MethodCallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterMethodCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitMethodCallExp(this);
		}
	}

	public final MethodCallExpContext methodCallExp() throws RecognitionException {
		MethodCallExpContext _localctx = new MethodCallExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodCallExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); ((MethodCallExpContext)_localctx).qualifiedName = qualifiedName();
			 Ref parent = ((MethodCallExpContext)_localctx).qualifiedName.result; 
			setState(63); match(T__0);
			setState(64); ((MethodCallExpContext)_localctx).IDENT = match(IDENT);
			 String methodName = (((MethodCallExpContext)_localctx).IDENT!=null?((MethodCallExpContext)_localctx).IDENT.getText():null); 
			setState(66); match(T__8);
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(67); ((MethodCallExpContext)_localctx).arguments = arguments();
				 ((MethodCallExpContext)_localctx).result =  handler.methodCall(parent, methodName, ((MethodCallExpContext)_localctx).arguments.nodeList) ; 
				}
				break;
			}
			setState(72); match(T__7);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Node> nodeList;
		public OperatorExpressionContext operatorExpression;
		public OperatorExpressionContext arg2;
		public OperatorExpressionContext operatorExpression(int i) {
			return getRuleContext(OperatorExpressionContext.class,i);
		}
		public List<OperatorExpressionContext> operatorExpression() {
			return getRuleContexts(OperatorExpressionContext.class);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentsContext)_localctx).nodeList =  new LinkedList<Node>(); 
			setState(86);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__3) | (1L << T__1) | (1L << NUMBER) | (1L << STRING_LITERAL) | (1L << BOOLEAN) | (1L << IDENT))) != 0)) {
				{
				setState(75); ((ArgumentsContext)_localctx).operatorExpression = operatorExpression();
				 _localctx.nodeList.add(((ArgumentsContext)_localctx).operatorExpression.result); 
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(77); match(T__2);
					setState(78); ((ArgumentsContext)_localctx).arg2 = ((ArgumentsContext)_localctx).operatorExpression = operatorExpression();
					 _localctx.nodeList.add(((ArgumentsContext)_localctx).arg2.result); 
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class FormulaTermContext extends ParserRuleContext {
		public Node result;
		public Token BOOLEAN;
		public Token STRING_LITERAL;
		public Token NUMBER;
		public Token IDENT;
		public QualifiedNameContext qualifiedName;
		public FuncCallExpContext funcCallExp;
		public MethodCallExpContext methodCallExp;
		public MethodCallExpContext methodCallExp() {
			return getRuleContext(MethodCallExpContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public FuncCallExpContext funcCallExp() {
			return getRuleContext(FuncCallExpContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(CalculaParser.STRING_LITERAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(CalculaParser.BOOLEAN, 0); }
		public TerminalNode NUMBER() { return getToken(CalculaParser.NUMBER, 0); }
		public TerminalNode IDENT() { return getToken(CalculaParser.IDENT, 0); }
		public FormulaTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulaTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterFormulaTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitFormulaTerm(this);
		}
	}

	public final FormulaTermContext formulaTerm() throws RecognitionException {
		FormulaTermContext _localctx = new FormulaTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formulaTerm);
		try {
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88); ((FormulaTermContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((FormulaTermContext)_localctx).result =  handler.literal( ExprTokens.LIT_BOOLEAN, (((FormulaTermContext)_localctx).BOOLEAN!=null?((FormulaTermContext)_localctx).BOOLEAN.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90); ((FormulaTermContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((FormulaTermContext)_localctx).result =  handler.literal( ExprTokens.LIT_STRING,  strip((((FormulaTermContext)_localctx).STRING_LITERAL!=null?((FormulaTermContext)_localctx).STRING_LITERAL.getText():null))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92); ((FormulaTermContext)_localctx).NUMBER = match(NUMBER);
				 ((FormulaTermContext)_localctx).result =  handler.literal( ExprTokens.LIT_NUMBER, (((FormulaTermContext)_localctx).NUMBER!=null?((FormulaTermContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94); ((FormulaTermContext)_localctx).IDENT = match(IDENT);
				 ((FormulaTermContext)_localctx).result =  handler.refer( (((FormulaTermContext)_localctx).IDENT!=null?((FormulaTermContext)_localctx).IDENT.getText():null)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(96); ((FormulaTermContext)_localctx).qualifiedName = qualifiedName();
				 ((FormulaTermContext)_localctx).result =  ((FormulaTermContext)_localctx).qualifiedName.result; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(99); ((FormulaTermContext)_localctx).funcCallExp = funcCallExp();
				 ((FormulaTermContext)_localctx).result =  ((FormulaTermContext)_localctx).funcCallExp.result; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(102); ((FormulaTermContext)_localctx).methodCallExp = methodCallExp();
				 ((FormulaTermContext)_localctx).result =  ((FormulaTermContext)_localctx).methodCallExp.result; 
				}
				break;
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public Ref result;
		public Token IDENT;
		public TerminalNode IDENT(int i) {
			return getToken(CalculaParser.IDENT, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(CalculaParser.IDENT); }
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitQualifiedName(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107); ((QualifiedNameContext)_localctx).IDENT = match(IDENT);
			 ((QualifiedNameContext)_localctx).result =  handler.refer( (((QualifiedNameContext)_localctx).IDENT!=null?((QualifiedNameContext)_localctx).IDENT.getText():null)); 
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(109); match(T__0);
					setState(110); ((QualifiedNameContext)_localctx).IDENT = match(IDENT);
					 ((QualifiedNameContext)_localctx).result =  handler.refer( _localctx.result, (((QualifiedNameContext)_localctx).IDENT!=null?((QualifiedNameContext)_localctx).IDENT.getText():null)); 
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class UnaryContext extends ParserRuleContext {
		public Node result;
		public FormulaTermContext formulaTerm;
		public OperatorExpressionContext operatorExpression;
		public FormulaTermContext formulaTerm() {
			return getRuleContext(FormulaTermContext.class,0);
		}
		public OperatorExpressionContext operatorExpression() {
			return getRuleContext(OperatorExpressionContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean negative = false; 
			setState(120);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(118); match(T__1);
				 negative = true; 
				}
			}

			setState(130);
			switch (_input.LA(1)) {
			case NUMBER:
			case STRING_LITERAL:
			case BOOLEAN:
			case IDENT:
				{
				setState(122); ((UnaryContext)_localctx).formulaTerm = formulaTerm();
				 ((UnaryContext)_localctx).result =  ((UnaryContext)_localctx).formulaTerm.result;  
				}
				break;
			case T__8:
				{
				setState(125); match(T__8);
				setState(126); ((UnaryContext)_localctx).operatorExpression = operatorExpression();
				setState(127); match(T__7);
				 ((UnaryContext)_localctx).result =  ((UnaryContext)_localctx).operatorExpression.result;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 
						if(negative){
							((UnaryContext)_localctx).result =  handler.operator(ExprTokens.OP_NUM_NEGATION, _localctx.result );
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

	public static class MultiplicativeContext extends ParserRuleContext {
		public Node result;
		public UnaryContext unary;
		public UnaryContext op2;
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitMultiplicative(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiplicative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); ((MultiplicativeContext)_localctx).unary = unary();
			 ((MultiplicativeContext)_localctx).result =  ((MultiplicativeContext)_localctx).unary.result;  
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__10) | (1L << T__5))) != 0)) {
				{
				setState(148);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(136); match(T__5);
					setState(137); ((MultiplicativeContext)_localctx).op2 = ((MultiplicativeContext)_localctx).unary = unary();
					((MultiplicativeContext)_localctx).result =  handler.operator(ExprTokens.OP_MULTI, _localctx.result, ((MultiplicativeContext)_localctx).op2.result); 
					}
					break;
				case T__19:
					{
					setState(140); match(T__19);
					setState(141); ((MultiplicativeContext)_localctx).op2 = ((MultiplicativeContext)_localctx).unary = unary();
					((MultiplicativeContext)_localctx).result =  handler.operator(ExprTokens.OP_DIVIDE, _localctx.result, ((MultiplicativeContext)_localctx).op2.result); 
					}
					break;
				case T__10:
					{
					setState(144); match(T__10);
					setState(145); ((MultiplicativeContext)_localctx).op2 = ((MultiplicativeContext)_localctx).unary = unary();
					((MultiplicativeContext)_localctx).result =  handler.operator(ExprTokens.OP_MOD, _localctx.result, ((MultiplicativeContext)_localctx).op2.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(152);
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Node result;
		public MultiplicativeContext multiplicative;
		public MultiplicativeContext op2;
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); ((AdditiveExpressionContext)_localctx).multiplicative = multiplicative();
			 ((AdditiveExpressionContext)_localctx).result =  ((AdditiveExpressionContext)_localctx).multiplicative.result;  
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==T__1) {
				{
				setState(163);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(155); match(T__4);
					setState(156); ((AdditiveExpressionContext)_localctx).op2 = ((AdditiveExpressionContext)_localctx).multiplicative = multiplicative();
					((AdditiveExpressionContext)_localctx).result =  handler.operator(ExprTokens.OP_PLUS, _localctx.result, ((AdditiveExpressionContext)_localctx).op2.result); 
					}
					break;
				case T__1:
					{
					setState(159); match(T__1);
					setState(160); ((AdditiveExpressionContext)_localctx).op2 = ((AdditiveExpressionContext)_localctx).multiplicative = multiplicative();
					((AdditiveExpressionContext)_localctx).result =  handler.operator(ExprTokens.OP_MINUS, _localctx.result, ((AdditiveExpressionContext)_localctx).op2.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(167);
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

	public static class StringExpressionContext extends ParserRuleContext {
		public Node result;
		public AdditiveExpressionContext additiveExpression;
		public AdditiveExpressionContext op2;
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public StringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitStringExpression(this);
		}
	}

	public final StringExpressionContext stringExpression() throws RecognitionException {
		StringExpressionContext _localctx = new StringExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stringExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); ((StringExpressionContext)_localctx).additiveExpression = additiveExpression();
			 ((StringExpressionContext)_localctx).result =  ((StringExpressionContext)_localctx).additiveExpression.result;  
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(170); match(T__9);
				setState(171); ((StringExpressionContext)_localctx).op2 = ((StringExpressionContext)_localctx).additiveExpression = additiveExpression();
				((StringExpressionContext)_localctx).result =  handler.operator(ExprTokens.OP_CONCAT, _localctx.result, ((StringExpressionContext)_localctx).op2.result); 
				}
				}
				setState(178);
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

	public static class ComparisonContext extends ParserRuleContext {
		public Node result;
		public StringExpressionContext stringExpression;
		public StringExpressionContext op2;
		public List<StringExpressionContext> stringExpression() {
			return getRuleContexts(StringExpressionContext.class);
		}
		public StringExpressionContext stringExpression(int i) {
			return getRuleContext(StringExpressionContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitComparison(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); ((ComparisonContext)_localctx).stringExpression = stringExpression();
			 ((ComparisonContext)_localctx).result =  ((ComparisonContext)_localctx).stringExpression.result;  
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__15) | (1L << T__14) | (1L << T__12) | (1L << T__11))) != 0)) {
				{
				setState(209);
				switch (_input.LA(1)) {
				case T__15:
					{
					setState(181); match(T__15);
					setState(182); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_EQ, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				case T__18:
					{
					setState(185); match(T__18);
					setState(186); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_NOT_EQ, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				case T__11:
					{
					setState(189); match(T__11);
					setState(190); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_NOT_EQ, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				case T__14:
					{
					setState(193); match(T__14);
					setState(194); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_GT, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				case T__17:
					{
					setState(197); match(T__17);
					setState(198); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_EQ_GT, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				case T__16:
					{
					setState(201); match(T__16);
					setState(202); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_LT, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				case T__12:
					{
					setState(205); match(T__12);
					setState(206); ((ComparisonContext)_localctx).op2 = ((ComparisonContext)_localctx).stringExpression = stringExpression();
					((ComparisonContext)_localctx).result =  handler.operator(ExprTokens.OP_EQ_LT, _localctx.result, ((ComparisonContext)_localctx).op2.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(213);
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

	public static class NotExpressionContext extends ParserRuleContext {
		public Node result;
		public ComparisonContext comparison;
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitNotExpression(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_notExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			switch (_input.LA(1)) {
			case T__8:
			case T__1:
			case NUMBER:
			case STRING_LITERAL:
			case BOOLEAN:
			case IDENT:
				{
				setState(214); ((NotExpressionContext)_localctx).comparison = comparison();
				 ((NotExpressionContext)_localctx).result =  ((NotExpressionContext)_localctx).comparison.result;  
				}
				break;
			case T__3:
				{
				setState(217); match(T__3);
				setState(218); ((NotExpressionContext)_localctx).comparison = comparison();
				((NotExpressionContext)_localctx).result =  handler.operator(ExprTokens.OP_NOT, ((NotExpressionContext)_localctx).comparison.result); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LogicalExpressionContext extends ParserRuleContext {
		public Node result;
		public NotExpressionContext notExpression;
		public OperatorExpressionContext op2;
		public OperatorExpressionContext operatorExpression(int i) {
			return getRuleContext(OperatorExpressionContext.class,i);
		}
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public List<OperatorExpressionContext> operatorExpression() {
			return getRuleContexts(OperatorExpressionContext.class);
		}
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitLogicalExpression(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_logicalExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223); ((LogicalExpressionContext)_localctx).notExpression = notExpression();
			 ((LogicalExpressionContext)_localctx).result =  ((LogicalExpressionContext)_localctx).notExpression.result;  
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(233);
					switch (_input.LA(1)) {
					case T__6:
						{
						setState(225); match(T__6);
						setState(226); ((LogicalExpressionContext)_localctx).op2 = operatorExpression();
						((LogicalExpressionContext)_localctx).result =  handler.operator(ExprTokens.OP_AND, _localctx.result, ((LogicalExpressionContext)_localctx).op2.result); 
						}
						break;
					case T__13:
						{
						setState(229); match(T__13);
						setState(230); ((LogicalExpressionContext)_localctx).op2 = operatorExpression();
						((LogicalExpressionContext)_localctx).result =  handler.operator(ExprTokens.OP_OR, _localctx.result, ((LogicalExpressionContext)_localctx).op2.result); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class OperatorExpressionContext extends ParserRuleContext {
		public Node result;
		public LogicalExpressionContext logicalExpression;
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public OperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitOperatorExpression(this);
		}
	}

	public final OperatorExpressionContext operatorExpression() throws RecognitionException {
		OperatorExpressionContext _localctx = new OperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operatorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); ((OperatorExpressionContext)_localctx).logicalExpression = logicalExpression();
			 ((OperatorExpressionContext)_localctx).result =  ((OperatorExpressionContext)_localctx).logicalExpression.result;  
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u00f4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2+\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\66\n\3\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5I\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6T\n\6\f\6\16"+
		"\6W\13\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7l\n\7\3\b\3\b\3\b\3\b\3\b\7\bs\n\b\f\b\16\bv\13\b"+
		"\3\t\3\t\3\t\5\t{\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0085\n\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0097"+
		"\n\n\f\n\16\n\u009a\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00a6\n\13\f\13\16\13\u00a9\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00b1\n\f\f\f\16\f\u00b4\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u00d4\n\r\f\r\16\r\u00d7\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00e0\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u00ec\n\17\f\17\16\17\u00ef\13\17\3\20\3\20\3\20\3\20\2\2\21"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u0104\2*\3\2\2\2\4\65\3\2"+
		"\2\2\6\67\3\2\2\2\b?\3\2\2\2\nL\3\2\2\2\fk\3\2\2\2\16m\3\2\2\2\20w\3\2"+
		"\2\2\22\u0088\3\2\2\2\24\u009b\3\2\2\2\26\u00aa\3\2\2\2\30\u00b5\3\2\2"+
		"\2\32\u00df\3\2\2\2\34\u00e1\3\2\2\2\36\u00f0\3\2\2\2 !\7\7\2\2!\"\7\16"+
		"\2\2\"#\5\4\3\2#$\7\17\2\2$%\b\2\1\2%+\3\2\2\2&\'\7\7\2\2\'(\5\4\3\2("+
		")\b\2\1\2)+\3\2\2\2* \3\2\2\2*&\3\2\2\2+\3\3\2\2\2,-\5\36\20\2-.\b\3\1"+
		"\2.\66\3\2\2\2/\60\5\6\4\2\60\61\b\3\1\2\61\66\3\2\2\2\62\63\5\b\5\2\63"+
		"\64\b\3\1\2\64\66\3\2\2\2\65,\3\2\2\2\65/\3\2\2\2\65\62\3\2\2\2\66\5\3"+
		"\2\2\2\678\7\32\2\28:\7\16\2\29;\5\n\6\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2"+
		"<=\7\17\2\2=>\b\4\1\2>\7\3\2\2\2?@\5\16\b\2@A\b\5\1\2AB\7\26\2\2BC\7\32"+
		"\2\2CD\b\5\1\2DH\7\16\2\2EF\5\n\6\2FG\b\5\1\2GI\3\2\2\2HE\3\2\2\2HI\3"+
		"\2\2\2IJ\3\2\2\2JK\7\17\2\2K\t\3\2\2\2LX\b\6\1\2MN\5\36\20\2NU\b\6\1\2"+
		"OP\7\24\2\2PQ\5\36\20\2QR\b\6\1\2RT\3\2\2\2SO\3\2\2\2TW\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2VY\3\2\2\2WU\3\2\2\2XM\3\2\2\2XY\3\2\2\2Y\13\3\2\2\2Z[\7"+
		"\31\2\2[l\b\7\1\2\\]\7\30\2\2]l\b\7\1\2^_\7\27\2\2_l\b\7\1\2`a\7\32\2"+
		"\2al\b\7\1\2bc\5\16\b\2cd\b\7\1\2dl\3\2\2\2ef\5\6\4\2fg\b\7\1\2gl\3\2"+
		"\2\2hi\5\b\5\2ij\b\7\1\2jl\3\2\2\2kZ\3\2\2\2k\\\3\2\2\2k^\3\2\2\2k`\3"+
		"\2\2\2kb\3\2\2\2ke\3\2\2\2kh\3\2\2\2l\r\3\2\2\2mn\7\32\2\2nt\b\b\1\2o"+
		"p\7\26\2\2pq\7\32\2\2qs\b\b\1\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2"+
		"\2u\17\3\2\2\2vt\3\2\2\2wz\b\t\1\2xy\7\25\2\2y{\b\t\1\2zx\3\2\2\2z{\3"+
		"\2\2\2{\u0084\3\2\2\2|}\5\f\7\2}~\b\t\1\2~\u0085\3\2\2\2\177\u0080\7\16"+
		"\2\2\u0080\u0081\5\36\20\2\u0081\u0082\7\17\2\2\u0082\u0083\b\t\1\2\u0083"+
		"\u0085\3\2\2\2\u0084|\3\2\2\2\u0084\177\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\b\t\1\2\u0087\21\3\2\2\2\u0088\u0089\5\20\t\2\u0089\u0098\b\n\1"+
		"\2\u008a\u008b\7\21\2\2\u008b\u008c\5\20\t\2\u008c\u008d\b\n\1\2\u008d"+
		"\u0097\3\2\2\2\u008e\u008f\7\3\2\2\u008f\u0090\5\20\t\2\u0090\u0091\b"+
		"\n\1\2\u0091\u0097\3\2\2\2\u0092\u0093\7\f\2\2\u0093\u0094\5\20\t\2\u0094"+
		"\u0095\b\n\1\2\u0095\u0097\3\2\2\2\u0096\u008a\3\2\2\2\u0096\u008e\3\2"+
		"\2\2\u0096\u0092\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\23\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\5\22\n"+
		"\2\u009c\u00a7\b\13\1\2\u009d\u009e\7\22\2\2\u009e\u009f\5\22\n\2\u009f"+
		"\u00a0\b\13\1\2\u00a0\u00a6\3\2\2\2\u00a1\u00a2\7\25\2\2\u00a2\u00a3\5"+
		"\22\n\2\u00a3\u00a4\b\13\1\2\u00a4\u00a6\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5"+
		"\u00a1\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\25\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\5\24\13\2\u00ab"+
		"\u00b2\b\f\1\2\u00ac\u00ad\7\r\2\2\u00ad\u00ae\5\24\13\2\u00ae\u00af\b"+
		"\f\1\2\u00af\u00b1\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\27\3\2\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\u00b6\5\26\f\2\u00b6\u00d5\b\r\1\2\u00b7\u00b8\7\7\2\2\u00b8"+
		"\u00b9\5\26\f\2\u00b9\u00ba\b\r\1\2\u00ba\u00d4\3\2\2\2\u00bb\u00bc\7"+
		"\4\2\2\u00bc\u00bd\5\26\f\2\u00bd\u00be\b\r\1\2\u00be\u00d4\3\2\2\2\u00bf"+
		"\u00c0\7\13\2\2\u00c0\u00c1\5\26\f\2\u00c1\u00c2\b\r\1\2\u00c2\u00d4\3"+
		"\2\2\2\u00c3\u00c4\7\b\2\2\u00c4\u00c5\5\26\f\2\u00c5\u00c6\b\r\1\2\u00c6"+
		"\u00d4\3\2\2\2\u00c7\u00c8\7\5\2\2\u00c8\u00c9\5\26\f\2\u00c9\u00ca\b"+
		"\r\1\2\u00ca\u00d4\3\2\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\5\26\f\2\u00cd"+
		"\u00ce\b\r\1\2\u00ce\u00d4\3\2\2\2\u00cf\u00d0\7\n\2\2\u00d0\u00d1\5\26"+
		"\f\2\u00d1\u00d2\b\r\1\2\u00d2\u00d4\3\2\2\2\u00d3\u00b7\3\2\2\2\u00d3"+
		"\u00bb\3\2\2\2\u00d3\u00bf\3\2\2\2\u00d3\u00c3\3\2\2\2\u00d3\u00c7\3\2"+
		"\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\31\3\2\2\2\u00d7\u00d5\3\2\2"+
		"\2\u00d8\u00d9\5\30\r\2\u00d9\u00da\b\16\1\2\u00da\u00e0\3\2\2\2\u00db"+
		"\u00dc\7\23\2\2\u00dc\u00dd\5\30\r\2\u00dd\u00de\b\16\1\2\u00de\u00e0"+
		"\3\2\2\2\u00df\u00d8\3\2\2\2\u00df\u00db\3\2\2\2\u00e0\33\3\2\2\2\u00e1"+
		"\u00e2\5\32\16\2\u00e2\u00ed\b\17\1\2\u00e3\u00e4\7\20\2\2\u00e4\u00e5"+
		"\5\36\20\2\u00e5\u00e6\b\17\1\2\u00e6\u00ec\3\2\2\2\u00e7\u00e8\7\t\2"+
		"\2\u00e8\u00e9\5\36\20\2\u00e9\u00ea\b\17\1\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e3\3\2\2\2\u00eb\u00e7\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\35\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1"+
		"\5\34\17\2\u00f1\u00f2\b\20\1\2\u00f2\37\3\2\2\2\26*\65:HUXktz\u0084\u0096"+
		"\u0098\u00a5\u00a7\u00b2\u00d3\u00d5\u00df\u00eb\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}