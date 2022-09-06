package GeneratedOutput;// Generated from /Users/sooryasrajan/AntlrCompilerDesign/src/CompilerDesignProject.Lexar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lexar extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, PLUS=2, MINUS=3, MULTIPLICATION=4, DIVISION=5, ASSIGNMENT=6, EQUAL=7, 
		GTE=8, LTE=9, GT=10, LT=11, NOTEQUAL=12, DIGIT=13, SPACE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "ASSIGNMENT", "EQUAL", 
			"GTE", "LTE", "GT", "LT", "NOTEQUAL", "DIGIT", "SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'+'", "'-'", "'*'", "'/'", "':='", "'='", "'>='", "'<='", 
			"'>'", "'<'", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "ASSIGNMENT", 
			"EQUAL", "GTE", "LTE", "GT", "LT", "NOTEQUAL", "DIGIT", "SPACE"
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


	public Lexar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000eH\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0005"+
		"\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\f@\b\f\u000b\f\f"+
		"\fA\u0001\r\u0004\rE\b\r\u000b\r\f\rF\u0000\u0000\u000e\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000\u0003\u0002"+
		"\u0000AZaz\u0003\u000009AZaz\u0001\u000009J\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003"+
		"$\u0001\u0000\u0000\u0000\u0005&\u0001\u0000\u0000\u0000\u0007(\u0001"+
		"\u0000\u0000\u0000\t*\u0001\u0000\u0000\u0000\u000b,\u0001\u0000\u0000"+
		"\u0000\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000\u0000\u0011"+
		"4\u0001\u0000\u0000\u0000\u00137\u0001\u0000\u0000\u0000\u00159\u0001"+
		"\u0000\u0000\u0000\u0017;\u0001\u0000\u0000\u0000\u0019?\u0001\u0000\u0000"+
		"\u0000\u001bD\u0001\u0000\u0000\u0000\u001d!\u0007\u0000\u0000\u0000\u001e"+
		" \u0007\u0001\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"\u0002\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005"+
		"+\u0000\u0000%\u0004\u0001\u0000\u0000\u0000&\'\u0005-\u0000\u0000\'\u0006"+
		"\u0001\u0000\u0000\u0000()\u0005*\u0000\u0000)\b\u0001\u0000\u0000\u0000"+
		"*+\u0005/\u0000\u0000+\n\u0001\u0000\u0000\u0000,-\u0005:\u0000\u0000"+
		"-.\u0005=\u0000\u0000.\f\u0001\u0000\u0000\u0000/0\u0005=\u0000\u0000"+
		"0\u000e\u0001\u0000\u0000\u000012\u0005>\u0000\u000023\u0005=\u0000\u0000"+
		"3\u0010\u0001\u0000\u0000\u000045\u0005<\u0000\u000056\u0005=\u0000\u0000"+
		"6\u0012\u0001\u0000\u0000\u000078\u0005>\u0000\u00008\u0014\u0001\u0000"+
		"\u0000\u00009:\u0005<\u0000\u0000:\u0016\u0001\u0000\u0000\u0000;<\u0005"+
		"<\u0000\u0000<=\u0005>\u0000\u0000=\u0018\u0001\u0000\u0000\u0000>@\u0007"+
		"\u0002\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\u001a\u0001\u0000"+
		"\u0000\u0000CE\u0005 \u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u001c"+
		"\u0001\u0000\u0000\u0000\u0004\u0000!AF\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}