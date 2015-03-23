// Generated from Calcula.g4 by ANTLR 4.4

	package kr.simula.calcula.antlr;
	
	import java.util.List;
	import java.util.LinkedList;
	
	import kr.simula.calcula.core.*;
	import kr.simula.calcula.builder.*;

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
		T__2=1, T__1=2, T__0=3, NUMBER=4, STRING_LITERAL=5, BOOLEAN=6, IDENT=7, 
		WS=8, COMMENT=9, MULTILINE_COMMENT=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "','", "NUMBER", "STRING_LITERAL", "BOOLEAN", 
		"IDENT", "WS", "COMMENT", "MULTILINE_COMMENT"
	};
	public static final int
		RULE_funcExp = 0, RULE_term = 1;
	public static final String[] ruleNames = {
		"funcExp", "term"
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


	  	private CalculaBuilder calculaBuilder;
	  	
	  	public CalculaParser(TokenStream input, CalculaBuilder calculaBuilder){
	  		this(input);
	  		setBuilder(calculaBuilder);
	  	}
	  	
	  	public void setBuilder(CalculaBuilder calculaBuilder){
	  		this.calculaBuilder = calculaBuilder;
	  	}
	  	

		public String stripString( String text ) {
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
	public static class FuncExpContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(CalculaParser.IDENT, 0); }
		public FuncExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterFuncExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitFuncExp(this);
		}
	}

	public final FuncExpContext funcExp() throws RecognitionException {
		FuncExpContext _localctx = new FuncExpContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_funcExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4); match(IDENT);
			setState(5); match(T__2);
			setState(6); term();
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7); match(T__0);
				setState(8); term();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(13); match(T__1);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(CalculaParser.STRING_LITERAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(CalculaParser.BOOLEAN, 0); }
		public TerminalNode NUMBER() { return getToken(CalculaParser.NUMBER, 0); }
		public TerminalNode IDENT() { return getToken(CalculaParser.IDENT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculaListener ) ((CalculaListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << STRING_LITERAL) | (1L << BOOLEAN) | (1L << IDENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f\24\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\2\3\2\3\3\3\3\3\3\2\2"+
		"\4\2\4\2\3\3\2\6\t\22\2\6\3\2\2\2\4\21\3\2\2\2\6\7\7\t\2\2\7\b\7\3\2\2"+
		"\b\13\5\4\3\2\t\n\7\5\2\2\n\f\5\4\3\2\13\t\3\2\2\2\f\r\3\2\2\2\r\13\3"+
		"\2\2\2\r\16\3\2\2\2\16\17\3\2\2\2\17\20\7\4\2\2\20\3\3\2\2\2\21\22\t\2"+
		"\2\2\22\5\3\2\2\2\3\r";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}