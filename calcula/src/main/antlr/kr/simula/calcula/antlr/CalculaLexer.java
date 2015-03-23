// Generated from Calcula.g4 by ANTLR 4.4

	package kr.simula.calcula.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, NUMBER=4, STRING_LITERAL=5, BOOLEAN=6, IDENT=7, 
		WS=8, COMMENT=9, MULTILINE_COMMENT=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "DIGIT", "LETTER", "NUMBER", "STRING_LITERAL", 
		"BOOLEAN", "IDENT", "WS", "COMMENT", "MULTILINE_COMMENT", "EOL"
	};


	public CalculaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calcula.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\u0089\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\6\7)\n\7\r\7\16\7*\3\7\3\7\6\7/\n\7\r\7\16\7\60\5\7\63\n\7\3\b"+
		"\3\b\7\b\67\n\b\f\b\16\b:\13\b\3\b\3\b\3\b\7\b?\n\b\f\b\16\bB\13\b\3\b"+
		"\5\bE\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\tY\n\t\3\n\3\n\3\n\7\n^\n\n\f\n\16\na\13\n\3\13\6\13d\n"+
		"\13\r\13\16\13e\3\13\3\13\3\f\3\f\3\f\3\f\7\fn\n\f\f\f\16\fq\13\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r{\n\r\f\r\16\r~\13\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\5\16\u0088\n\16\2\2\17\3\3\5\4\7\5\t\2\13\2\r\6\17\7"+
		"\21\b\23\t\25\n\27\13\31\f\33\2\3\2\7\b\2&&C\\aac|\u3132\u3191\uac02\ud7b1"+
		"\5\2\f\f\17\17$$\5\2\f\f\17\17))\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0094"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\35\3\2\2\2"+
		"\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r(\3\2\2\2\17D\3\2\2\2"+
		"\21X\3\2\2\2\23Z\3\2\2\2\25c\3\2\2\2\27i\3\2\2\2\31v\3\2\2\2\33\u0087"+
		"\3\2\2\2\35\36\7*\2\2\36\4\3\2\2\2\37 \7+\2\2 \6\3\2\2\2!\"\7.\2\2\"\b"+
		"\3\2\2\2#$\4\62;\2$\n\3\2\2\2%&\t\2\2\2&\f\3\2\2\2\')\5\t\5\2(\'\3\2\2"+
		"\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\62\3\2\2\2,.\7\60\2\2-/\5\t\5\2.-\3"+
		"\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62,\3\2\2\2"+
		"\62\63\3\2\2\2\63\16\3\2\2\2\648\7$\2\2\65\67\n\3\2\2\66\65\3\2\2\2\67"+
		":\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;E\7$\2\2<@\7)\2\2"+
		"=?\n\4\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2"+
		"CE\7)\2\2D\64\3\2\2\2D<\3\2\2\2E\20\3\2\2\2FG\7v\2\2GH\7t\2\2HI\7w\2\2"+
		"IY\7g\2\2JK\7h\2\2KL\7c\2\2LM\7n\2\2MN\7u\2\2NY\7g\2\2OP\7V\2\2PQ\7T\2"+
		"\2QR\7W\2\2RY\7G\2\2ST\7H\2\2TU\7C\2\2UV\7N\2\2VW\7U\2\2WY\7G\2\2XF\3"+
		"\2\2\2XJ\3\2\2\2XO\3\2\2\2XS\3\2\2\2Y\22\3\2\2\2Z_\5\13\6\2[^\5\13\6\2"+
		"\\^\5\t\5\2][\3\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\24\3\2"+
		"\2\2a_\3\2\2\2bd\t\5\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2"+
		"\2\2gh\b\13\2\2h\26\3\2\2\2ij\7\61\2\2jk\7\61\2\2ko\3\2\2\2ln\13\2\2\2"+
		"ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\t\6\2\2"+
		"st\3\2\2\2tu\b\f\2\2u\30\3\2\2\2vw\7\61\2\2wx\7,\2\2x|\3\2\2\2y{\13\2"+
		"\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177"+
		"\u0080\7,\2\2\u0080\u0081\7\61\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\r"+
		"\2\2\u0083\32\3\2\2\2\u0084\u0085\7\17\2\2\u0085\u0088\7\f\2\2\u0086\u0088"+
		"\t\6\2\2\u0087\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088\34\3\2\2\2\20\2"+
		"*\60\628@DX]_eo|\u0087\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}