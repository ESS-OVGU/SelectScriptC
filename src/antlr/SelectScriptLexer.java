// Generated from SelectScript.g4 by ANTLR 4.5.3
package S2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SelectScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, DOT=3, SEP=4, END=5, COLON=6, AD=7, AND=8, XOR=9, OR=10, 
		NOT=11, IN=12, SHIFTR=13, SHIFTL=14, IAND=15, IXOR=16, IOR=17, INV=18, 
		ASSIGN=19, EQ=20, NE=21, LE=22, GE=23, LT=24, GT=25, ADD=26, SUB=27, MUL=28, 
		DIV=29, MOD=30, POW=31, PIPE=32, IF=33, SQ=34, DQ=35, LIST_BEGIN=36, LIST_END=37, 
		DICT_BEGIN=38, DICT_END=39, PROCEDURE=40, SELECT=41, FROM=42, WHERE=43, 
		ORDER=44, GROUP=45, HAVING=46, BY=47, LIMIT=48, AS=49, LOC=50, CONNECT=51, 
		START=52, STOP=53, WITH=54, NO=55, CYCLE=56, UNIQUE=57, MEMORIZE=58, COST=59, 
		ASC=60, DESC=61, DEL_F=62, MEM_F=63, EVAL_F=64, LOOP=65, EXIT=66, TRY=67, 
		RECUR=68, REF=69, IMPORT=70, YIELD=71, NEWLINE=72, WS=73, COMMENT=74, 
		LINE_COMMENT=75, STRING=76, FLOAT=77, INTEGER=78, TRUE=79, FALSE=80, NONE=81, 
		IDENTIFIER=82;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "DOT", "SEP", "END", "COLON", "AD", "AND", "XOR", "OR", 
		"NOT", "IN", "SHIFTR", "SHIFTL", "IAND", "IXOR", "IOR", "INV", "ASSIGN", 
		"EQ", "NE", "LE", "GE", "LT", "GT", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"POW", "PIPE", "IF", "SQ", "DQ", "LIST_BEGIN", "LIST_END", "DICT_BEGIN", 
		"DICT_END", "PROCEDURE", "SELECT", "FROM", "WHERE", "ORDER", "GROUP", 
		"HAVING", "BY", "LIMIT", "AS", "LOC", "CONNECT", "START", "STOP", "WITH", 
		"NO", "CYCLE", "UNIQUE", "MEMORIZE", "COST", "ASC", "DESC", "DEL_F", "MEM_F", 
		"EVAL_F", "LOOP", "EXIT", "TRY", "RECUR", "REF", "IMPORT", "YIELD", "NEWLINE", 
		"WS", "COMMENT", "LINE_COMMENT", "STRING", "FLOAT", "INTEGER", "TRUE", 
		"FALSE", "NONE", "IDENTIFIER", "DIGIT", "CHARACTER", "SPECIAL", "A", "N", 
		"B", "O", "C", "P", "D", "Q", "E", "R", "F", "S", "G", "T", "H", "U", 
		"I", "V", "J", "W", "K", "X", "L", "Y", "M", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "','", "';'", "':'", "'@'", null, null, null, 
		null, null, "'>>'", "'<<'", "'&'", "'^'", "'|'", "'~'", "'='", "'=='", 
		"'!='", "'<='", "'>='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'**'", "'|>'", null, "'''", "'\"'", "'['", "']'", "'{'", "'}'", null, 
		null, null, null, null, null, null, null, null, null, "'$'", null, null, 
		null, null, null, null, null, null, null, null, null, "'del'", "'mem'", 
		"'eval'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "DOT", "SEP", "END", "COLON", "AD", "AND", "XOR", "OR", 
		"NOT", "IN", "SHIFTR", "SHIFTL", "IAND", "IXOR", "IOR", "INV", "ASSIGN", 
		"EQ", "NE", "LE", "GE", "LT", "GT", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"POW", "PIPE", "IF", "SQ", "DQ", "LIST_BEGIN", "LIST_END", "DICT_BEGIN", 
		"DICT_END", "PROCEDURE", "SELECT", "FROM", "WHERE", "ORDER", "GROUP", 
		"HAVING", "BY", "LIMIT", "AS", "LOC", "CONNECT", "START", "STOP", "WITH", 
		"NO", "CYCLE", "UNIQUE", "MEMORIZE", "COST", "ASC", "DESC", "DEL_F", "MEM_F", 
		"EVAL_F", "LOOP", "EXIT", "TRY", "RECUR", "REF", "IMPORT", "YIELD", "NEWLINE", 
		"WS", "COMMENT", "LINE_COMMENT", "STRING", "FLOAT", "INTEGER", "TRUE", 
		"FALSE", "NONE", "IDENTIFIER"
	};
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


	public SelectScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SelectScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2T\u02c5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u014b\n)\3*"+
		"\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-"+
		"\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		"=\5=\u01c0\n=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u01cd\n>\3?\3?\3?\3"+
		"?\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3D\3D\3D\3"+
		"D\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3"+
		"H\3I\5I\u0202\nI\3I\3I\3I\3I\3J\6J\u0209\nJ\rJ\16J\u020a\3J\3J\3K\3K\3"+
		"K\3K\7K\u0213\nK\fK\16K\u0216\13K\3K\3K\3K\3K\3K\3L\3L\7L\u021f\nL\fL"+
		"\16L\u0222\13L\3L\5L\u0225\nL\3L\5L\u0228\nL\3L\3L\3M\3M\7M\u022e\nM\f"+
		"M\16M\u0231\13M\3M\3M\3M\3M\7M\u0237\nM\fM\16M\u023a\13M\3M\3M\5M\u023e"+
		"\nM\3N\7N\u0241\nN\fN\16N\u0244\13N\3N\3N\7N\u0248\nN\fN\16N\u024b\13"+
		"N\3O\6O\u024e\nO\rO\16O\u024f\3O\3O\3O\3O\6O\u0256\nO\rO\16O\u0257\3O"+
		"\3O\3O\3O\6O\u025e\nO\rO\16O\u025f\3O\3O\3O\3O\3O\6O\u0267\nO\rO\16O\u0268"+
		"\5O\u026b\nO\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3S\5S\u027e"+
		"\nS\3S\3S\5S\u0282\nS\3S\3S\3S\7S\u0287\nS\fS\16S\u028a\13S\3T\3T\3U\3"+
		"U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`"+
		"\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3l"+
		"\3l\3m\3m\3n\3n\3o\3o\3p\3p\5\u0214\u022f\u0238\2q\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093"+
		"K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7"+
		"\2\u00a9\2\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\u00b7\2\u00b9"+
		"\2\u00bb\2\u00bd\2\u00bf\2\u00c1\2\u00c3\2\u00c5\2\u00c7\2\u00c9\2\u00cb"+
		"\2\u00cd\2\u00cf\2\u00d1\2\u00d3\2\u00d5\2\u00d7\2\u00d9\2\u00db\2\u00dd"+
		"\2\u00df\2\3\2\"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2\62\63aa\4\2CHch"+
		"\4\2VVvv\4\2TTtt\4\2WWww\4\2GGgg\4\2HHhh\4\2CCcc\4\2NNnn\4\2UUuu\4\2P"+
		"Ppp\4\2QQqq\4\2C\\c|\4\2AAaa\4\2DDdd\4\2EEee\4\2RRrr\4\2FFff\4\2SSss\4"+
		"\2IIii\4\2JJjj\4\2KKkk\4\2XXxx\4\2LLll\4\2YYyy\4\2MMmm\4\2ZZzz\4\2[[{"+
		"{\4\2OOoo\4\2\\\\||\u02c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2"+
		"\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\3\u00e1\3\2\2\2\5\u00e3\3\2\2\2\7\u00e5\3\2\2\2\t\u00e7\3\2\2"+
		"\2\13\u00e9\3\2\2\2\r\u00eb\3\2\2\2\17\u00ed\3\2\2\2\21\u00ef\3\2\2\2"+
		"\23\u00f3\3\2\2\2\25\u00f7\3\2\2\2\27\u00fa\3\2\2\2\31\u00fe\3\2\2\2\33"+
		"\u0101\3\2\2\2\35\u0104\3\2\2\2\37\u0107\3\2\2\2!\u0109\3\2\2\2#\u010b"+
		"\3\2\2\2%\u010d\3\2\2\2\'\u010f\3\2\2\2)\u0111\3\2\2\2+\u0114\3\2\2\2"+
		"-\u0117\3\2\2\2/\u011a\3\2\2\2\61\u011d\3\2\2\2\63\u011f\3\2\2\2\65\u0121"+
		"\3\2\2\2\67\u0123\3\2\2\29\u0125\3\2\2\2;\u0127\3\2\2\2=\u0129\3\2\2\2"+
		"?\u012b\3\2\2\2A\u012e\3\2\2\2C\u0131\3\2\2\2E\u0134\3\2\2\2G\u0136\3"+
		"\2\2\2I\u0138\3\2\2\2K\u013a\3\2\2\2M\u013c\3\2\2\2O\u013e\3\2\2\2Q\u0140"+
		"\3\2\2\2S\u014c\3\2\2\2U\u0153\3\2\2\2W\u0158\3\2\2\2Y\u015e\3\2\2\2["+
		"\u0164\3\2\2\2]\u016a\3\2\2\2_\u0171\3\2\2\2a\u0174\3\2\2\2c\u017a\3\2"+
		"\2\2e\u017d\3\2\2\2g\u017f\3\2\2\2i\u0187\3\2\2\2k\u018d\3\2\2\2m\u0192"+
		"\3\2\2\2o\u0197\3\2\2\2q\u019a\3\2\2\2s\u01a0\3\2\2\2u\u01a7\3\2\2\2w"+
		"\u01b0\3\2\2\2y\u01b5\3\2\2\2{\u01c1\3\2\2\2}\u01ce\3\2\2\2\177\u01d2"+
		"\3\2\2\2\u0081\u01d6\3\2\2\2\u0083\u01db\3\2\2\2\u0085\u01e0\3\2\2\2\u0087"+
		"\u01e5\3\2\2\2\u0089\u01e9\3\2\2\2\u008b\u01ef\3\2\2\2\u008d\u01f3\3\2"+
		"\2\2\u008f\u01fa\3\2\2\2\u0091\u0201\3\2\2\2\u0093\u0208\3\2\2\2\u0095"+
		"\u020e\3\2\2\2\u0097\u021c\3\2\2\2\u0099\u023d\3\2\2\2\u009b\u0242\3\2"+
		"\2\2\u009d\u026a\3\2\2\2\u009f\u026c\3\2\2\2\u00a1\u0271\3\2\2\2\u00a3"+
		"\u0277\3\2\2\2\u00a5\u027d\3\2\2\2\u00a7\u028b\3\2\2\2\u00a9\u028d\3\2"+
		"\2\2\u00ab\u028f\3\2\2\2\u00ad\u0291\3\2\2\2\u00af\u0293\3\2\2\2\u00b1"+
		"\u0295\3\2\2\2\u00b3\u0297\3\2\2\2\u00b5\u0299\3\2\2\2\u00b7\u029b\3\2"+
		"\2\2\u00b9\u029d\3\2\2\2\u00bb\u029f\3\2\2\2\u00bd\u02a1\3\2\2\2\u00bf"+
		"\u02a3\3\2\2\2\u00c1\u02a5\3\2\2\2\u00c3\u02a7\3\2\2\2\u00c5\u02a9\3\2"+
		"\2\2\u00c7\u02ab\3\2\2\2\u00c9\u02ad\3\2\2\2\u00cb\u02af\3\2\2\2\u00cd"+
		"\u02b1\3\2\2\2\u00cf\u02b3\3\2\2\2\u00d1\u02b5\3\2\2\2\u00d3\u02b7\3\2"+
		"\2\2\u00d5\u02b9\3\2\2\2\u00d7\u02bb\3\2\2\2\u00d9\u02bd\3\2\2\2\u00db"+
		"\u02bf\3\2\2\2\u00dd\u02c1\3\2\2\2\u00df\u02c3\3\2\2\2\u00e1\u00e2\7*"+
		"\2\2\u00e2\4\3\2\2\2\u00e3\u00e4\7+\2\2\u00e4\6\3\2\2\2\u00e5\u00e6\7"+
		"\60\2\2\u00e6\b\3\2\2\2\u00e7\u00e8\7.\2\2\u00e8\n\3\2\2\2\u00e9\u00ea"+
		"\7=\2\2\u00ea\f\3\2\2\2\u00eb\u00ec\7<\2\2\u00ec\16\3\2\2\2\u00ed\u00ee"+
		"\7B\2\2\u00ee\20\3\2\2\2\u00ef\u00f0\5\u00adW\2\u00f0\u00f1\5\u00afX\2"+
		"\u00f1\u00f2\5\u00b9]\2\u00f2\22\3\2\2\2\u00f3\u00f4\5\u00d7l\2\u00f4"+
		"\u00f5\5\u00b3Z\2\u00f5\u00f6\5\u00bf`\2\u00f6\24\3\2\2\2\u00f7\u00f8"+
		"\5\u00b3Z\2\u00f8\u00f9\5\u00bf`\2\u00f9\26\3\2\2\2\u00fa\u00fb\5\u00af"+
		"X\2\u00fb\u00fc\5\u00b3Z\2\u00fc\u00fd\5\u00c7d\2\u00fd\30\3\2\2\2\u00fe"+
		"\u00ff\5\u00cdg\2\u00ff\u0100\5\u00afX\2\u0100\32\3\2\2\2\u0101\u0102"+
		"\7@\2\2\u0102\u0103\7@\2\2\u0103\34\3\2\2\2\u0104\u0105\7>\2\2\u0105\u0106"+
		"\7>\2\2\u0106\36\3\2\2\2\u0107\u0108\7(\2\2\u0108 \3\2\2\2\u0109\u010a"+
		"\7`\2\2\u010a\"\3\2\2\2\u010b\u010c\7~\2\2\u010c$\3\2\2\2\u010d\u010e"+
		"\7\u0080\2\2\u010e&\3\2\2\2\u010f\u0110\7?\2\2\u0110(\3\2\2\2\u0111\u0112"+
		"\7?\2\2\u0112\u0113\7?\2\2\u0113*\3\2\2\2\u0114\u0115\7#\2\2\u0115\u0116"+
		"\7?\2\2\u0116,\3\2\2\2\u0117\u0118\7>\2\2\u0118\u0119\7?\2\2\u0119.\3"+
		"\2\2\2\u011a\u011b\7@\2\2\u011b\u011c\7?\2\2\u011c\60\3\2\2\2\u011d\u011e"+
		"\7>\2\2\u011e\62\3\2\2\2\u011f\u0120\7@\2\2\u0120\64\3\2\2\2\u0121\u0122"+
		"\7-\2\2\u0122\66\3\2\2\2\u0123\u0124\7/\2\2\u01248\3\2\2\2\u0125\u0126"+
		"\7,\2\2\u0126:\3\2\2\2\u0127\u0128\7\61\2\2\u0128<\3\2\2\2\u0129\u012a"+
		"\7\'\2\2\u012a>\3\2\2\2\u012b\u012c\7,\2\2\u012c\u012d\7,\2\2\u012d@\3"+
		"\2\2\2\u012e\u012f\7~\2\2\u012f\u0130\7@\2\2\u0130B\3\2\2\2\u0131\u0132"+
		"\5\u00cdg\2\u0132\u0133\5\u00c1a\2\u0133D\3\2\2\2\u0134\u0135\7)\2\2\u0135"+
		"F\3\2\2\2\u0136\u0137\7$\2\2\u0137H\3\2\2\2\u0138\u0139\7]\2\2\u0139J"+
		"\3\2\2\2\u013a\u013b\7_\2\2\u013bL\3\2\2\2\u013c\u013d\7}\2\2\u013dN\3"+
		"\2\2\2\u013e\u013f\7\177\2\2\u013fP\3\2\2\2\u0140\u0141\5\u00b7\\\2\u0141"+
		"\u0142\5\u00bf`\2\u0142\u0143\5\u00b3Z\2\u0143\u014a\5\u00b5[\2\u0144"+
		"\u0145\5\u00bd_\2\u0145\u0146\5\u00b9]\2\u0146\u0147\5\u00cbf\2\u0147"+
		"\u0148\5\u00bf`\2\u0148\u0149\5\u00bd_\2\u0149\u014b\3\2\2\2\u014a\u0144"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014bR\3\2\2\2\u014c\u014d\5\u00c3b\2\u014d"+
		"\u014e\5\u00bd_\2\u014e\u014f\5\u00d9m\2\u014f\u0150\5\u00bd_\2\u0150"+
		"\u0151\5\u00b5[\2\u0151\u0152\5\u00c7d\2\u0152T\3\2\2\2\u0153\u0154\5"+
		"\u00c1a\2\u0154\u0155\5\u00bf`\2\u0155\u0156\5\u00b3Z\2\u0156\u0157\5"+
		"\u00ddo\2\u0157V\3\2\2\2\u0158\u0159\5\u00d3j\2\u0159\u015a\5\u00c9e\2"+
		"\u015a\u015b\5\u00bd_\2\u015b\u015c\5\u00bf`\2\u015c\u015d\5\u00bd_\2"+
		"\u015dX\3\2\2\2\u015e\u015f\5\u00b3Z\2\u015f\u0160\5\u00bf`\2\u0160\u0161"+
		"\5\u00b9]\2\u0161\u0162\5\u00bd_\2\u0162\u0163\5\u00bf`\2\u0163Z\3\2\2"+
		"\2\u0164\u0165\5\u00c5c\2\u0165\u0166\5\u00bf`\2\u0166\u0167\5\u00b3Z"+
		"\2\u0167\u0168\5\u00cbf\2\u0168\u0169\5\u00b7\\\2\u0169\\\3\2\2\2\u016a"+
		"\u016b\5\u00c9e\2\u016b\u016c\5\u00adW\2\u016c\u016d\5\u00cfh\2\u016d"+
		"\u016e\5\u00cdg\2\u016e\u016f\5\u00afX\2\u016f\u0170\5\u00c5c\2\u0170"+
		"^\3\2\2\2\u0171\u0172\5\u00b1Y\2\u0172\u0173\5\u00dbn\2\u0173`\3\2\2\2"+
		"\u0174\u0175\5\u00d9m\2\u0175\u0176\5\u00cdg\2\u0176\u0177\5\u00ddo\2"+
		"\u0177\u0178\5\u00cdg\2\u0178\u0179\5\u00c7d\2\u0179b\3\2\2\2\u017a\u017b"+
		"\5\u00adW\2\u017b\u017c\5\u00c3b\2\u017cd\3\2\2\2\u017d\u017e\7&\2\2\u017e"+
		"f\3\2\2\2\u017f\u0180\5\u00b5[\2\u0180\u0181\5\u00b3Z\2\u0181\u0182\5"+
		"\u00afX\2\u0182\u0183\5\u00afX\2\u0183\u0184\5\u00bd_\2\u0184\u0185\5"+
		"\u00b5[\2\u0185\u0186\5\u00c7d\2\u0186h\3\2\2\2\u0187\u0188\5\u00c3b\2"+
		"\u0188\u0189\5\u00c7d\2\u0189\u018a\5\u00adW\2\u018a\u018b\5\u00bf`\2"+
		"\u018b\u018c\5\u00c7d\2\u018cj\3\2\2\2\u018d\u018e\5\u00c3b\2\u018e\u018f"+
		"\5\u00c7d\2\u018f\u0190\5\u00b3Z\2\u0190\u0191\5\u00b7\\\2\u0191l\3\2"+
		"\2\2\u0192\u0193\5\u00d3j\2\u0193\u0194\5\u00cdg\2\u0194\u0195\5\u00c7"+
		"d\2\u0195\u0196\5\u00c9e\2\u0196n\3\2\2\2\u0197\u0198\5\u00afX\2\u0198"+
		"\u0199\5\u00b3Z\2\u0199p\3\2\2\2\u019a\u019b\5\u00b5[\2\u019b\u019c\5"+
		"\u00dbn\2\u019c\u019d\5\u00b5[\2\u019d\u019e\5\u00d9m\2\u019e\u019f\5"+
		"\u00bd_\2\u019fr\3\2\2\2\u01a0\u01a1\5\u00cbf\2\u01a1\u01a2\5\u00afX\2"+
		"\u01a2\u01a3\5\u00cdg\2\u01a3\u01a4\5\u00bb^\2\u01a4\u01a5\5\u00cbf\2"+
		"\u01a5\u01a6\5\u00bd_\2\u01a6t\3\2\2\2\u01a7\u01a8\5\u00ddo\2\u01a8\u01a9"+
		"\5\u00bd_\2\u01a9\u01aa\5\u00ddo\2\u01aa\u01ab\5\u00b3Z\2\u01ab\u01ac"+
		"\5\u00bf`\2\u01ac\u01ad\5\u00cdg\2\u01ad\u01ae\5\u00dfp\2\u01ae\u01af"+
		"\5\u00bd_\2\u01afv\3\2\2\2\u01b0\u01b1\5\u00b5[\2\u01b1\u01b2\5\u00b3"+
		"Z\2\u01b2\u01b3\5\u00c3b\2\u01b3\u01b4\5\u00c7d\2\u01b4x\3\2\2\2\u01b5"+
		"\u01b6\5\u00adW\2\u01b6\u01b7\5\u00c3b\2\u01b7\u01bf\5\u00b5[\2\u01b8"+
		"\u01b9\5\u00bd_\2\u01b9\u01ba\5\u00afX\2\u01ba\u01bb\5\u00b9]\2\u01bb"+
		"\u01bc\5\u00cdg\2\u01bc\u01bd\5\u00afX\2\u01bd\u01be\5\u00c5c\2\u01be"+
		"\u01c0\3\2\2\2\u01bf\u01b8\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0z\3\2\2\2"+
		"\u01c1\u01c2\5\u00b9]\2\u01c2\u01c3\5\u00bd_\2\u01c3\u01c4\5\u00c3b\2"+
		"\u01c4\u01cc\5\u00b5[\2\u01c5\u01c6\5\u00bd_\2\u01c6\u01c7\5\u00afX\2"+
		"\u01c7\u01c8\5\u00b9]\2\u01c8\u01c9\5\u00cdg\2\u01c9\u01ca\5\u00afX\2"+
		"\u01ca\u01cb\5\u00c5c\2\u01cb\u01cd\3\2\2\2\u01cc\u01c5\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd|\3\2\2\2\u01ce\u01cf\7f\2\2\u01cf\u01d0\7g\2\2\u01d0"+
		"\u01d1\7n\2\2\u01d1~\3\2\2\2\u01d2\u01d3\7o\2\2\u01d3\u01d4\7g\2\2\u01d4"+
		"\u01d5\7o\2\2\u01d5\u0080\3\2\2\2\u01d6\u01d7\7g\2\2\u01d7\u01d8\7x\2"+
		"\2\u01d8\u01d9\7c\2\2\u01d9\u01da\7n\2\2\u01da\u0082\3\2\2\2\u01db\u01dc"+
		"\5\u00d9m\2\u01dc\u01dd\5\u00b3Z\2\u01dd\u01de\5\u00b3Z\2\u01de\u01df"+
		"\5\u00b7\\\2\u01df\u0084\3\2\2\2\u01e0\u01e1\5\u00bd_\2\u01e1\u01e2\5"+
		"\u00d7l\2\u01e2\u01e3\5\u00cdg\2\u01e3\u01e4\5\u00c7d\2\u01e4\u0086\3"+
		"\2\2\2\u01e5\u01e6\5\u00c7d\2\u01e6\u01e7\5\u00bf`\2\u01e7\u01e8\5\u00db"+
		"n\2\u01e8\u0088\3\2\2\2\u01e9\u01ea\5\u00bf`\2\u01ea\u01eb\5\u00bd_\2"+
		"\u01eb\u01ec\5\u00b5[\2\u01ec\u01ed\5\u00cbf\2\u01ed\u01ee\5\u00bf`\2"+
		"\u01ee\u008a\3\2\2\2\u01ef\u01f0\5\u00bf`\2\u01f0\u01f1\5\u00bd_\2\u01f1"+
		"\u01f2\5\u00c1a\2\u01f2\u008c\3\2\2\2\u01f3\u01f4\5\u00cdg\2\u01f4\u01f5"+
		"\5\u00ddo\2\u01f5\u01f6\5\u00b7\\\2\u01f6\u01f7\5\u00b3Z\2\u01f7\u01f8"+
		"\5\u00bf`\2\u01f8\u01f9\5\u00c7d\2\u01f9\u008e\3\2\2\2\u01fa\u01fb\5\u00db"+
		"n\2\u01fb\u01fc\5\u00cdg\2\u01fc\u01fd\5\u00bd_\2\u01fd\u01fe\5\u00d9"+
		"m\2\u01fe\u01ff\5\u00b9]\2\u01ff\u0090\3\2\2\2\u0200\u0202\7\17\2\2\u0201"+
		"\u0200\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\7\f"+
		"\2\2\u0204\u0205\3\2\2\2\u0205\u0206\bI\2\2\u0206\u0092\3\2\2\2\u0207"+
		"\u0209\t\2\2\2\u0208\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u0208\3\2"+
		"\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d\bJ\2\2\u020d"+
		"\u0094\3\2\2\2\u020e\u020f\7\61\2\2\u020f\u0210\7,\2\2\u0210\u0214\3\2"+
		"\2\2\u0211\u0213\13\2\2\2\u0212\u0211\3\2\2\2\u0213\u0216\3\2\2\2\u0214"+
		"\u0215\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0217\3\2\2\2\u0216\u0214\3\2"+
		"\2\2\u0217\u0218\7,\2\2\u0218\u0219\7\61\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u021b\bK\2\2\u021b\u0096\3\2\2\2\u021c\u0220\7%\2\2\u021d\u021f\n\3\2"+
		"\2\u021e\u021d\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221"+
		"\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0225\7\17\2\2"+
		"\u0224\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0227\3\2\2\2\u0226\u0228"+
		"\7\f\2\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u022a\bL\2\2\u022a\u0098\3\2\2\2\u022b\u022f\5G$\2\u022c\u022e\13\2\2"+
		"\2\u022d\u022c\3\2\2\2\u022e\u0231\3\2\2\2\u022f\u0230\3\2\2\2\u022f\u022d"+
		"\3\2\2\2\u0230\u0232\3\2\2\2\u0231\u022f\3\2\2\2\u0232\u0233\5G$\2\u0233"+
		"\u023e\3\2\2\2\u0234\u0238\5E#\2\u0235\u0237\13\2\2\2\u0236\u0235\3\2"+
		"\2\2\u0237\u023a\3\2\2\2\u0238\u0239\3\2\2\2\u0238\u0236\3\2\2\2\u0239"+
		"\u023b\3\2\2\2\u023a\u0238\3\2\2\2\u023b\u023c\5E#\2\u023c\u023e\3\2\2"+
		"\2\u023d\u022b\3\2\2\2\u023d\u0234\3\2\2\2\u023e\u009a\3\2\2\2\u023f\u0241"+
		"\5\u00a7T\2\u0240\u023f\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2\2"+
		"\2\u0242\u0243\3\2\2\2\u0243\u0245\3\2\2\2\u0244\u0242\3\2\2\2\u0245\u0249"+
		"\5\7\4\2\u0246\u0248\5\u00a7T\2\u0247\u0246\3\2\2\2\u0248\u024b\3\2\2"+
		"\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u009c\3\2\2\2\u024b\u0249"+
		"\3\2\2\2\u024c\u024e\5\u00a7T\2\u024d\u024c\3\2\2\2\u024e\u024f\3\2\2"+
		"\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u026b\3\2\2\2\u0251\u0252"+
		"\7\62\2\2\u0252\u0253\7d\2\2\u0253\u0255\3\2\2\2\u0254\u0256\t\4\2\2\u0255"+
		"\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2"+
		"\2\2\u0258\u026b\3\2\2\2\u0259\u025a\7\62\2\2\u025a\u025b\7q\2\2\u025b"+
		"\u025d\3\2\2\2\u025c\u025e\4\629\2\u025d\u025c\3\2\2\2\u025e\u025f\3\2"+
		"\2\2\u025f\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u026b\3\2\2\2\u0261"+
		"\u0262\7\62\2\2\u0262\u0263\7z\2\2\u0263\u0266\3\2\2\2\u0264\u0267\5\u00a7"+
		"T\2\u0265\u0267\t\5\2\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267"+
		"\u0268\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026b\3\2"+
		"\2\2\u026a\u024d\3\2\2\2\u026a\u0251\3\2\2\2\u026a\u0259\3\2\2\2\u026a"+
		"\u0261\3\2\2\2\u026b\u009e\3\2\2\2\u026c\u026d\t\6\2\2\u026d\u026e\t\7"+
		"\2\2\u026e\u026f\t\b\2\2\u026f\u0270\t\t\2\2\u0270\u00a0\3\2\2\2\u0271"+
		"\u0272\t\n\2\2\u0272\u0273\t\13\2\2\u0273\u0274\t\f\2\2\u0274\u0275\t"+
		"\r\2\2\u0275\u0276\t\t\2\2\u0276\u00a2\3\2\2\2\u0277\u0278\t\16\2\2\u0278"+
		"\u0279\t\17\2\2\u0279\u027a\t\16\2\2\u027a\u027b\t\t\2\2\u027b\u00a4\3"+
		"\2\2\2\u027c\u027e\5\u00a7T\2\u027d\u027c\3\2\2\2\u027d\u027e\3\2\2\2"+
		"\u027e\u0281\3\2\2\2\u027f\u0282\5\u00a9U\2\u0280\u0282\5\u00abV\2\u0281"+
		"\u027f\3\2\2\2\u0281\u0280\3\2\2\2\u0282\u0288\3\2\2\2\u0283\u0287\5\u00a7"+
		"T\2\u0284\u0287\5\u00a9U\2\u0285\u0287\5\u00abV\2\u0286\u0283\3\2\2\2"+
		"\u0286\u0284\3\2\2\2\u0286\u0285\3\2\2\2\u0287\u028a\3\2\2\2\u0288\u0286"+
		"\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u00a6\3\2\2\2\u028a\u0288\3\2\2\2\u028b"+
		"\u028c\4\62;\2\u028c\u00a8\3\2\2\2\u028d\u028e\t\20\2\2\u028e\u00aa\3"+
		"\2\2\2\u028f\u0290\t\21\2\2\u0290\u00ac\3\2\2\2\u0291\u0292\t\13\2\2\u0292"+
		"\u00ae\3\2\2\2\u0293\u0294\t\16\2\2\u0294\u00b0\3\2\2\2\u0295\u0296\t"+
		"\22\2\2\u0296\u00b2\3\2\2\2\u0297\u0298\t\17\2\2\u0298\u00b4\3\2\2\2\u0299"+
		"\u029a\t\23\2\2\u029a\u00b6\3\2\2\2\u029b\u029c\t\24\2\2\u029c\u00b8\3"+
		"\2\2\2\u029d\u029e\t\25\2\2\u029e\u00ba\3\2\2\2\u029f\u02a0\t\26\2\2\u02a0"+
		"\u00bc\3\2\2\2\u02a1\u02a2\t\t\2\2\u02a2\u00be\3\2\2\2\u02a3\u02a4\t\7"+
		"\2\2\u02a4\u00c0\3\2\2\2\u02a5\u02a6\t\n\2\2\u02a6\u00c2\3\2\2\2\u02a7"+
		"\u02a8\t\r\2\2\u02a8\u00c4\3\2\2\2\u02a9\u02aa\t\27\2\2\u02aa\u00c6\3"+
		"\2\2\2\u02ab\u02ac\t\6\2\2\u02ac\u00c8\3\2\2\2\u02ad\u02ae\t\30\2\2\u02ae"+
		"\u00ca\3\2\2\2\u02af\u02b0\t\b\2\2\u02b0\u00cc\3\2\2\2\u02b1\u02b2\t\31"+
		"\2\2\u02b2\u00ce\3\2\2\2\u02b3\u02b4\t\32\2\2\u02b4\u00d0\3\2\2\2\u02b5"+
		"\u02b6\t\33\2\2\u02b6\u00d2\3\2\2\2\u02b7\u02b8\t\34\2\2\u02b8\u00d4\3"+
		"\2\2\2\u02b9\u02ba\t\35\2\2\u02ba\u00d6\3\2\2\2\u02bb\u02bc\t\36\2\2\u02bc"+
		"\u00d8\3\2\2\2\u02bd\u02be\t\f\2\2\u02be\u00da\3\2\2\2\u02bf\u02c0\t\37"+
		"\2\2\u02c0\u00dc\3\2\2\2\u02c1\u02c2\t \2\2\u02c2\u00de\3\2\2\2\u02c3"+
		"\u02c4\t!\2\2\u02c4\u00e0\3\2\2\2\33\2\u014a\u01bf\u01cc\u0201\u020a\u0214"+
		"\u0220\u0224\u0227\u022f\u0238\u023d\u0242\u0249\u024f\u0257\u025f\u0266"+
		"\u0268\u026a\u027d\u0281\u0286\u0288\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}