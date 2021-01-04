// Generated from D:/Universität/Bachelor Cyklus/7 Semester/Bacherlor Arbeit/Compiler/src/main/java/_0_ParserGrammatik\Grammatik.g4 by ANTLR 4.7.2
package main.java._0_ParserGrammatik;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammatikParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LoopStart=1, WhileStart=2, If=3, Then=4, DO=5, Ende=6, GotoStart=7, GotoEnd=8, 
		MacroSart=9, MacroEND=10, MarkeName=11, MacroName=12, Variable=13, Zero=14, 
		Value=15, Text=16, Gleich=17, DoopeltPunkt=18, Gleichung=19, CommaPunkt=20, 
		Plus=21, Minus=22, Mal=23, Div=24, NichtGleich=25, KlammerAuf=26, KlammerZu=27, 
		Komma=28, NichtWichtigCharakter1=29, NichtWichtigCharakter2=30, WhiteSpace=31;
	public static final int
		RULE_program = 0, RULE_loops = 1, RULE_loopProgram = 2, RULE_ifLoop = 3, 
		RULE_counter = 4, RULE_nichts = 5, RULE_whiles = 6, RULE_whileProgram = 7, 
		RULE_ifWhile = 8, RULE_condition = 9, RULE_gotos = 10, RULE_gotoEnde = 11, 
		RULE_gotoProgram = 12, RULE_gotoCode = 13, RULE_gotoInstructions = 14, 
		RULE_gotoAssign = 15, RULE_ifGoto = 16, RULE_marken = 17, RULE_assign = 18, 
		RULE_exp = 19, RULE_expIf = 20, RULE_macroLoops = 21, RULE_macroLoop = 22, 
		RULE_macroWhiles = 23, RULE_macroWhile = 24, RULE_macroGotos = 25, RULE_macroGoto = 26, 
		RULE_parameters = 27, RULE_text = 28, RULE_macroNameAnruf = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "loops", "loopProgram", "ifLoop", "counter", "nichts", "whiles", 
			"whileProgram", "ifWhile", "condition", "gotos", "gotoEnde", "gotoProgram", 
			"gotoCode", "gotoInstructions", "gotoAssign", "ifGoto", "marken", "assign", 
			"exp", "expIf", "macroLoops", "macroLoop", "macroWhiles", "macroWhile", 
			"macroGotos", "macroGoto", "parameters", "text", "macroNameAnruf"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'LOOP'", "'WHILE'", "'IF'", "'THEN'", "'DO'", "'END'", "'GOTO'", 
			"'HALT'", "'MACRO'", "'MACROEND'", null, null, null, "'0'", null, null, 
			"':='", "':'", "'='", "';'", "'+'", "'-'", "'*'", "'/'", "'!='", "'('", 
			"')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LoopStart", "WhileStart", "If", "Then", "DO", "Ende", "GotoStart", 
			"GotoEnd", "MacroSart", "MacroEND", "MarkeName", "MacroName", "Variable", 
			"Zero", "Value", "Text", "Gleich", "DoopeltPunkt", "Gleichung", "CommaPunkt", 
			"Plus", "Minus", "Mal", "Div", "NichtGleich", "KlammerAuf", "KlammerZu", 
			"Komma", "NichtWichtigCharakter1", "NichtWichtigCharakter2", "WhiteSpace"
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
	public String getGrammarFileName() { return "Grammatik.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammatikParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public LoopsContext loops() {
			return getRuleContext(LoopsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammatikParser.EOF, 0); }
		public MacroLoopsContext macroLoops() {
			return getRuleContext(MacroLoopsContext.class,0);
		}
		public WhilesContext whiles() {
			return getRuleContext(WhilesContext.class,0);
		}
		public MacroWhilesContext macroWhiles() {
			return getRuleContext(MacroWhilesContext.class,0);
		}
		public GotosContext gotos() {
			return getRuleContext(GotosContext.class,0);
		}
		public GotoEndeContext gotoEnde() {
			return getRuleContext(GotoEndeContext.class,0);
		}
		public MacroGotosContext macroGotos() {
			return getRuleContext(MacroGotosContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MacroSart) {
					{
					setState(60);
					macroLoops(0);
					}
				}

				setState(63);
				loops(0);
				setState(64);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MacroSart) {
					{
					setState(66);
					macroWhiles(0);
					}
				}

				setState(69);
				whiles(0);
				setState(70);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MacroSart) {
					{
					setState(72);
					macroGotos(0);
					}
				}

				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(75);
					gotos();
					}
					break;
				case 2:
					{
					setState(76);
					gotoEnde();
					}
					break;
				}
				setState(79);
				match(EOF);
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

	public static class LoopsContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public MacroNameAnrufContext macroNameAnruf() {
			return getRuleContext(MacroNameAnrufContext.class,0);
		}
		public IfLoopContext ifLoop() {
			return getRuleContext(IfLoopContext.class,0);
		}
		public LoopProgramContext loopProgram() {
			return getRuleContext(LoopProgramContext.class,0);
		}
		public List<LoopsContext> loops() {
			return getRuleContexts(LoopsContext.class);
		}
		public LoopsContext loops(int i) {
			return getRuleContext(LoopsContext.class,i);
		}
		public TerminalNode CommaPunkt() { return getToken(GrammatikParser.CommaPunkt, 0); }
		public LoopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterLoops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitLoops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitLoops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopsContext loops() throws RecognitionException {
		return loops(0);
	}

	private LoopsContext loops(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LoopsContext _localctx = new LoopsContext(_ctx, _parentState);
		LoopsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_loops, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
				{
				setState(84);
				assign();
				}
				break;
			case MacroName:
				{
				setState(85);
				macroNameAnruf();
				}
				break;
			case If:
				{
				setState(86);
				ifLoop();
				}
				break;
			case LoopStart:
				{
				setState(87);
				loopProgram();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LoopsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_loops);
					setState(90);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(91);
					match(CommaPunkt);
					setState(92);
					loops(3);
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LoopProgramContext extends ParserRuleContext {
		public TerminalNode LoopStart() { return getToken(GrammatikParser.LoopStart, 0); }
		public CounterContext counter() {
			return getRuleContext(CounterContext.class,0);
		}
		public TerminalNode DO() { return getToken(GrammatikParser.DO, 0); }
		public TerminalNode Ende() { return getToken(GrammatikParser.Ende, 0); }
		public LoopsContext loops() {
			return getRuleContext(LoopsContext.class,0);
		}
		public NichtsContext nichts() {
			return getRuleContext(NichtsContext.class,0);
		}
		public LoopProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterLoopProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitLoopProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitLoopProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopProgramContext loopProgram() throws RecognitionException {
		LoopProgramContext _localctx = new LoopProgramContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loopProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(LoopStart);
			setState(99);
			counter();
			setState(100);
			match(DO);
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LoopStart:
			case If:
			case MacroName:
			case Variable:
				{
				setState(101);
				loops(0);
				}
				break;
			case Ende:
				{
				setState(102);
				nichts();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(105);
			match(Ende);
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

	public static class IfLoopContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(GrammatikParser.If, 0); }
		public ExpIfContext expIf() {
			return getRuleContext(ExpIfContext.class,0);
		}
		public TerminalNode Then() { return getToken(GrammatikParser.Then, 0); }
		public TerminalNode Ende() { return getToken(GrammatikParser.Ende, 0); }
		public LoopsContext loops() {
			return getRuleContext(LoopsContext.class,0);
		}
		public NichtsContext nichts() {
			return getRuleContext(NichtsContext.class,0);
		}
		public IfLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterIfLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitIfLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitIfLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfLoopContext ifLoop() throws RecognitionException {
		IfLoopContext _localctx = new IfLoopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(If);
			setState(108);
			expIf();
			setState(109);
			match(Then);
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LoopStart:
			case If:
			case MacroName:
			case Variable:
				{
				setState(110);
				loops(0);
				}
				break;
			case Ende:
				{
				setState(111);
				nichts();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(114);
			match(Ende);
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

	public static class CounterContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CounterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_counter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterCounter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitCounter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitCounter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CounterContext counter() throws RecognitionException {
		CounterContext _localctx = new CounterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_counter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			exp(0);
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

	public static class NichtsContext extends ParserRuleContext {
		public NichtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nichts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterNichts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitNichts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitNichts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NichtsContext nichts() throws RecognitionException {
		NichtsContext _localctx = new NichtsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nichts);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class WhilesContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public MacroNameAnrufContext macroNameAnruf() {
			return getRuleContext(MacroNameAnrufContext.class,0);
		}
		public IfWhileContext ifWhile() {
			return getRuleContext(IfWhileContext.class,0);
		}
		public WhileProgramContext whileProgram() {
			return getRuleContext(WhileProgramContext.class,0);
		}
		public List<WhilesContext> whiles() {
			return getRuleContexts(WhilesContext.class);
		}
		public WhilesContext whiles(int i) {
			return getRuleContext(WhilesContext.class,i);
		}
		public TerminalNode CommaPunkt() { return getToken(GrammatikParser.CommaPunkt, 0); }
		public WhilesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whiles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterWhiles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitWhiles(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitWhiles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilesContext whiles() throws RecognitionException {
		return whiles(0);
	}

	private WhilesContext whiles(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		WhilesContext _localctx = new WhilesContext(_ctx, _parentState);
		WhilesContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_whiles, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
				{
				setState(121);
				assign();
				}
				break;
			case MacroName:
				{
				setState(122);
				macroNameAnruf();
				}
				break;
			case If:
				{
				setState(123);
				ifWhile();
				}
				break;
			case WhileStart:
				{
				setState(124);
				whileProgram();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new WhilesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_whiles);
					setState(127);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(128);
					match(CommaPunkt);
					setState(129);
					whiles(3);
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class WhileProgramContext extends ParserRuleContext {
		public TerminalNode WhileStart() { return getToken(GrammatikParser.WhileStart, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode DO() { return getToken(GrammatikParser.DO, 0); }
		public TerminalNode Ende() { return getToken(GrammatikParser.Ende, 0); }
		public WhilesContext whiles() {
			return getRuleContext(WhilesContext.class,0);
		}
		public NichtsContext nichts() {
			return getRuleContext(NichtsContext.class,0);
		}
		public WhileProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterWhileProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitWhileProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitWhileProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileProgramContext whileProgram() throws RecognitionException {
		WhileProgramContext _localctx = new WhileProgramContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(WhileStart);
			setState(136);
			condition();
			setState(137);
			match(DO);
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WhileStart:
			case If:
			case MacroName:
			case Variable:
				{
				setState(138);
				whiles(0);
				}
				break;
			case Ende:
				{
				setState(139);
				nichts();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(142);
			match(Ende);
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

	public static class IfWhileContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(GrammatikParser.If, 0); }
		public ExpIfContext expIf() {
			return getRuleContext(ExpIfContext.class,0);
		}
		public TerminalNode Then() { return getToken(GrammatikParser.Then, 0); }
		public TerminalNode Ende() { return getToken(GrammatikParser.Ende, 0); }
		public WhilesContext whiles() {
			return getRuleContext(WhilesContext.class,0);
		}
		public NichtsContext nichts() {
			return getRuleContext(NichtsContext.class,0);
		}
		public IfWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterIfWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitIfWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitIfWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfWhileContext ifWhile() throws RecognitionException {
		IfWhileContext _localctx = new IfWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(If);
			setState(145);
			expIf();
			setState(146);
			match(Then);
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WhileStart:
			case If:
			case MacroName:
			case Variable:
				{
				setState(147);
				whiles(0);
				}
				break;
			case Ende:
				{
				setState(148);
				nichts();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(151);
			match(Ende);
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

	public static class ConditionContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NichtGleich() { return getToken(GrammatikParser.NichtGleich, 0); }
		public TerminalNode Zero() { return getToken(GrammatikParser.Zero, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode KlammerZu() { return getToken(GrammatikParser.KlammerZu, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				exp(0);
				setState(154);
				match(NichtGleich);
				setState(155);
				match(Zero);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(KlammerAuf);
				setState(158);
				condition();
				setState(159);
				match(KlammerZu);
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

	public static class GotosContext extends ParserRuleContext {
		public GotoProgramContext gotoProgram() {
			return getRuleContext(GotoProgramContext.class,0);
		}
		public TerminalNode CommaPunkt() { return getToken(GrammatikParser.CommaPunkt, 0); }
		public GotoEndeContext gotoEnde() {
			return getRuleContext(GotoEndeContext.class,0);
		}
		public GotosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterGotos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitGotos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitGotos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotosContext gotos() throws RecognitionException {
		GotosContext _localctx = new GotosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_gotos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			gotoProgram(0);
			setState(164);
			match(CommaPunkt);
			setState(165);
			gotoEnde();
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

	public static class GotoEndeContext extends ParserRuleContext {
		public TerminalNode GotoEnd() { return getToken(GrammatikParser.GotoEnd, 0); }
		public GotoAssignContext gotoAssign() {
			return getRuleContext(GotoAssignContext.class,0);
		}
		public MarkenContext marken() {
			return getRuleContext(MarkenContext.class,0);
		}
		public GotoEndeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoEnde; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterGotoEnde(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitGotoEnde(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitGotoEnde(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoEndeContext gotoEnde() throws RecognitionException {
		GotoEndeContext _localctx = new GotoEndeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_gotoEnde);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MarkeName) {
				{
				setState(167);
				marken();
				}
			}

			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GotoEnd:
				{
				setState(170);
				match(GotoEnd);
				}
				break;
			case GotoStart:
				{
				setState(171);
				gotoAssign();
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

	public static class GotoProgramContext extends ParserRuleContext {
		public GotoCodeContext gotoCode() {
			return getRuleContext(GotoCodeContext.class,0);
		}
		public List<GotoProgramContext> gotoProgram() {
			return getRuleContexts(GotoProgramContext.class);
		}
		public GotoProgramContext gotoProgram(int i) {
			return getRuleContext(GotoProgramContext.class,i);
		}
		public TerminalNode CommaPunkt() { return getToken(GrammatikParser.CommaPunkt, 0); }
		public GotoProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterGotoProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitGotoProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitGotoProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoProgramContext gotoProgram() throws RecognitionException {
		return gotoProgram(0);
	}

	private GotoProgramContext gotoProgram(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GotoProgramContext _localctx = new GotoProgramContext(_ctx, _parentState);
		GotoProgramContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_gotoProgram, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175);
			gotoCode();
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GotoProgramContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_gotoProgram);
					setState(177);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(178);
					match(CommaPunkt);
					setState(179);
					gotoProgram(2);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GotoCodeContext extends ParserRuleContext {
		public GotoInstructionsContext gotoInstructions() {
			return getRuleContext(GotoInstructionsContext.class,0);
		}
		public MarkenContext marken() {
			return getRuleContext(MarkenContext.class,0);
		}
		public GotoCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterGotoCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitGotoCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitGotoCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoCodeContext gotoCode() throws RecognitionException {
		GotoCodeContext _localctx = new GotoCodeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_gotoCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MarkeName) {
				{
				setState(185);
				marken();
				}
			}

			setState(188);
			gotoInstructions();
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

	public static class GotoInstructionsContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public MacroNameAnrufContext macroNameAnruf() {
			return getRuleContext(MacroNameAnrufContext.class,0);
		}
		public GotoAssignContext gotoAssign() {
			return getRuleContext(GotoAssignContext.class,0);
		}
		public IfGotoContext ifGoto() {
			return getRuleContext(IfGotoContext.class,0);
		}
		public GotoInstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoInstructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterGotoInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitGotoInstructions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitGotoInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoInstructionsContext gotoInstructions() throws RecognitionException {
		GotoInstructionsContext _localctx = new GotoInstructionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_gotoInstructions);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				assign();
				}
				break;
			case MacroName:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				macroNameAnruf();
				}
				break;
			case GotoStart:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				gotoAssign();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				ifGoto();
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

	public static class GotoAssignContext extends ParserRuleContext {
		public TerminalNode GotoStart() { return getToken(GrammatikParser.GotoStart, 0); }
		public TerminalNode MarkeName() { return getToken(GrammatikParser.MarkeName, 0); }
		public GotoAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterGotoAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitGotoAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitGotoAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoAssignContext gotoAssign() throws RecognitionException {
		GotoAssignContext _localctx = new GotoAssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_gotoAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(GotoStart);
			setState(197);
			match(MarkeName);
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

	public static class IfGotoContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(GrammatikParser.If, 0); }
		public ExpIfContext expIf() {
			return getRuleContext(ExpIfContext.class,0);
		}
		public TerminalNode Then() { return getToken(GrammatikParser.Then, 0); }
		public GotoAssignContext gotoAssign() {
			return getRuleContext(GotoAssignContext.class,0);
		}
		public IfGotoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifGoto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterIfGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitIfGoto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitIfGoto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfGotoContext ifGoto() throws RecognitionException {
		IfGotoContext _localctx = new IfGotoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifGoto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(If);
			setState(200);
			expIf();
			setState(201);
			match(Then);
			setState(202);
			gotoAssign();
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

	public static class MarkenContext extends ParserRuleContext {
		public Token mark;
		public TerminalNode DoopeltPunkt() { return getToken(GrammatikParser.DoopeltPunkt, 0); }
		public TerminalNode MarkeName() { return getToken(GrammatikParser.MarkeName, 0); }
		public MarkenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_marken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMarken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMarken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMarken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkenContext marken() throws RecognitionException {
		MarkenContext _localctx = new MarkenContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_marken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			((MarkenContext)_localctx).mark = match(MarkeName);
			setState(205);
			match(DoopeltPunkt);
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

	public static class AssignContext extends ParserRuleContext {
		public Token var;
		public TerminalNode Gleich() { return getToken(GrammatikParser.Gleich, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Variable() { return getToken(GrammatikParser.Variable, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			((AssignContext)_localctx).var = match(Variable);
			setState(208);
			match(Gleich);
			setState(209);
			exp(0);
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

	public static class ExpContext extends ParserRuleContext {
		public Token var;
		public TerminalNode Variable() { return getToken(GrammatikParser.Variable, 0); }
		public List<TerminalNode> Zero() { return getTokens(GrammatikParser.Zero); }
		public TerminalNode Zero(int i) {
			return getToken(GrammatikParser.Zero, i);
		}
		public TerminalNode Value() { return getToken(GrammatikParser.Value, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> KlammerZu() { return getTokens(GrammatikParser.KlammerZu); }
		public TerminalNode KlammerZu(int i) {
			return getToken(GrammatikParser.KlammerZu, i);
		}
		public TerminalNode Plus() { return getToken(GrammatikParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(GrammatikParser.Minus, 0); }
		public TerminalNode Mal() { return getToken(GrammatikParser.Mal, 0); }
		public TerminalNode Div() { return getToken(GrammatikParser.Div, 0); }
		public MacroNameAnrufContext macroNameAnruf() {
			return getRuleContext(MacroNameAnrufContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(212);
				((ExpContext)_localctx).var = match(Variable);
				}
				break;
			case 2:
				{
				setState(214); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(213);
						match(Zero);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(216); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				{
				setState(218);
				match(Value);
				}
				break;
			case 4:
				{
				setState(219);
				match(KlammerAuf);
				setState(220);
				exp(0);
				setState(221);
				match(KlammerZu);
				}
				break;
			case 5:
				{
				setState(223);
				match(KlammerAuf);
				setState(224);
				exp(0);
				setState(225);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				exp(0);
				setState(227);
				match(KlammerZu);
				}
				break;
			case 6:
				{
				setState(229);
				match(KlammerAuf);
				setState(230);
				exp(0);
				setState(231);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(232);
				exp(0);
				setState(234); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(233);
					match(KlammerZu);
					}
					}
					setState(236); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==KlammerZu );
				setState(238);
				exp(2);
				}
				break;
			case 7:
				{
				setState(240);
				macroNameAnruf();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(243);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(244);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(245);
					exp(5);
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpIfContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode Gleichung() { return getToken(GrammatikParser.Gleichung, 0); }
		public TerminalNode NichtGleich() { return getToken(GrammatikParser.NichtGleich, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public ExpIfContext expIf() {
			return getRuleContext(ExpIfContext.class,0);
		}
		public TerminalNode KlammerZu() { return getToken(GrammatikParser.KlammerZu, 0); }
		public ExpIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterExpIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitExpIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitExpIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpIfContext expIf() throws RecognitionException {
		ExpIfContext _localctx = new ExpIfContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expIf);
		int _la;
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				exp(0);
				setState(252);
				_la = _input.LA(1);
				if ( !(_la==Gleichung || _la==NichtGleich) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(KlammerAuf);
				setState(256);
				expIf();
				setState(257);
				match(KlammerZu);
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

	public static class MacroLoopsContext extends ParserRuleContext {
		public MacroLoopContext macroLoop() {
			return getRuleContext(MacroLoopContext.class,0);
		}
		public MacroLoopsContext macroLoops() {
			return getRuleContext(MacroLoopsContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public MacroLoopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroLoops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroLoops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroLoops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroLoops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroLoopsContext macroLoops() throws RecognitionException {
		return macroLoops(0);
	}

	private MacroLoopsContext macroLoops(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MacroLoopsContext _localctx = new MacroLoopsContext(_ctx, _parentState);
		MacroLoopsContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_macroLoops, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			macroLoop();
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MacroLoopsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_macroLoops);
					setState(264);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << Value) | (1L << Gleich) | (1L << DoopeltPunkt) | (1L << Gleichung) | (1L << CommaPunkt) | (1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div) | (1L << NichtGleich) | (1L << KlammerAuf) | (1L << KlammerZu) | (1L << Komma) | (1L << NichtWichtigCharakter1) | (1L << NichtWichtigCharakter2))) != 0)) {
						{
						setState(265);
						text();
						}
					}

					setState(268);
					macroLoop();
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MacroLoopContext extends ParserRuleContext {
		public TerminalNode MacroSart() { return getToken(GrammatikParser.MacroSart, 0); }
		public TerminalNode MacroName() { return getToken(GrammatikParser.MacroName, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode KlammerZu() { return getToken(GrammatikParser.KlammerZu, 0); }
		public TerminalNode Gleichung() { return getToken(GrammatikParser.Gleichung, 0); }
		public LoopsContext loops() {
			return getRuleContext(LoopsContext.class,0);
		}
		public TerminalNode MacroEND() { return getToken(GrammatikParser.MacroEND, 0); }
		public MacroLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroLoopContext macroLoop() throws RecognitionException {
		MacroLoopContext _localctx = new MacroLoopContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_macroLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(MacroSart);
			setState(275);
			match(MacroName);
			setState(276);
			match(KlammerAuf);
			setState(277);
			parameters(0);
			setState(278);
			match(KlammerZu);
			setState(279);
			match(Gleichung);
			setState(280);
			loops(0);
			setState(281);
			match(MacroEND);
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

	public static class MacroWhilesContext extends ParserRuleContext {
		public MacroWhileContext macroWhile() {
			return getRuleContext(MacroWhileContext.class,0);
		}
		public MacroWhilesContext macroWhiles() {
			return getRuleContext(MacroWhilesContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public MacroWhilesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroWhiles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroWhiles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroWhiles(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroWhiles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroWhilesContext macroWhiles() throws RecognitionException {
		return macroWhiles(0);
	}

	private MacroWhilesContext macroWhiles(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MacroWhilesContext _localctx = new MacroWhilesContext(_ctx, _parentState);
		MacroWhilesContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_macroWhiles, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(284);
			macroWhile();
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MacroWhilesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_macroWhiles);
					setState(286);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << Value) | (1L << Gleich) | (1L << DoopeltPunkt) | (1L << Gleichung) | (1L << CommaPunkt) | (1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div) | (1L << NichtGleich) | (1L << KlammerAuf) | (1L << KlammerZu) | (1L << Komma) | (1L << NichtWichtigCharakter1) | (1L << NichtWichtigCharakter2))) != 0)) {
						{
						setState(287);
						text();
						}
					}

					setState(290);
					macroWhile();
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MacroWhileContext extends ParserRuleContext {
		public TerminalNode MacroSart() { return getToken(GrammatikParser.MacroSart, 0); }
		public TerminalNode MacroName() { return getToken(GrammatikParser.MacroName, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode KlammerZu() { return getToken(GrammatikParser.KlammerZu, 0); }
		public TerminalNode Gleichung() { return getToken(GrammatikParser.Gleichung, 0); }
		public WhilesContext whiles() {
			return getRuleContext(WhilesContext.class,0);
		}
		public TerminalNode MacroEND() { return getToken(GrammatikParser.MacroEND, 0); }
		public MacroWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroWhileContext macroWhile() throws RecognitionException {
		MacroWhileContext _localctx = new MacroWhileContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_macroWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(MacroSart);
			setState(297);
			match(MacroName);
			setState(298);
			match(KlammerAuf);
			setState(299);
			parameters(0);
			setState(300);
			match(KlammerZu);
			setState(301);
			match(Gleichung);
			setState(302);
			whiles(0);
			setState(303);
			match(MacroEND);
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

	public static class MacroGotosContext extends ParserRuleContext {
		public MacroGotoContext macroGoto() {
			return getRuleContext(MacroGotoContext.class,0);
		}
		public MacroGotosContext macroGotos() {
			return getRuleContext(MacroGotosContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public MacroGotosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroGotos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroGotos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroGotos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroGotos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroGotosContext macroGotos() throws RecognitionException {
		return macroGotos(0);
	}

	private MacroGotosContext macroGotos(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MacroGotosContext _localctx = new MacroGotosContext(_ctx, _parentState);
		MacroGotosContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_macroGotos, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(306);
			macroGoto();
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MacroGotosContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_macroGotos);
					setState(308);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(310);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << Value) | (1L << Gleich) | (1L << DoopeltPunkt) | (1L << Gleichung) | (1L << CommaPunkt) | (1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div) | (1L << NichtGleich) | (1L << KlammerAuf) | (1L << KlammerZu) | (1L << Komma) | (1L << NichtWichtigCharakter1) | (1L << NichtWichtigCharakter2))) != 0)) {
						{
						setState(309);
						text();
						}
					}

					setState(312);
					macroGoto();
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MacroGotoContext extends ParserRuleContext {
		public TerminalNode MacroSart() { return getToken(GrammatikParser.MacroSart, 0); }
		public TerminalNode MacroName() { return getToken(GrammatikParser.MacroName, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode KlammerZu() { return getToken(GrammatikParser.KlammerZu, 0); }
		public TerminalNode Gleichung() { return getToken(GrammatikParser.Gleichung, 0); }
		public TerminalNode MacroEND() { return getToken(GrammatikParser.MacroEND, 0); }
		public GotosContext gotos() {
			return getRuleContext(GotosContext.class,0);
		}
		public GotoEndeContext gotoEnde() {
			return getRuleContext(GotoEndeContext.class,0);
		}
		public MacroGotoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroGoto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroGoto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroGoto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroGotoContext macroGoto() throws RecognitionException {
		MacroGotoContext _localctx = new MacroGotoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_macroGoto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(MacroSart);
			setState(319);
			match(MacroName);
			setState(320);
			match(KlammerAuf);
			setState(321);
			parameters(0);
			setState(322);
			match(KlammerZu);
			setState(323);
			match(Gleichung);
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(324);
				gotos();
				}
				break;
			case 2:
				{
				setState(325);
				gotoEnde();
				}
				break;
			}
			setState(328);
			match(MacroEND);
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

	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(GrammatikParser.Variable, 0); }
		public NichtsContext nichts() {
			return getRuleContext(NichtsContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode Komma() { return getToken(GrammatikParser.Komma, 0); }
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		return parameters(0);
	}

	private ParametersContext parameters(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametersContext _localctx = new ParametersContext(_ctx, _parentState);
		ParametersContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_parameters, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(331);
				match(Variable);
				}
				break;
			case 2:
				{
				setState(332);
				nichts();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParametersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameters);
					setState(335);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(336);
					match(Komma);
					setState(337);
					match(Variable);
					}
					} 
				}
				setState(342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> Variable() { return getTokens(GrammatikParser.Variable); }
		public TerminalNode Variable(int i) {
			return getToken(GrammatikParser.Variable, i);
		}
		public List<TerminalNode> Value() { return getTokens(GrammatikParser.Value); }
		public TerminalNode Value(int i) {
			return getToken(GrammatikParser.Value, i);
		}
		public List<TerminalNode> NichtWichtigCharakter1() { return getTokens(GrammatikParser.NichtWichtigCharakter1); }
		public TerminalNode NichtWichtigCharakter1(int i) {
			return getToken(GrammatikParser.NichtWichtigCharakter1, i);
		}
		public List<TerminalNode> NichtWichtigCharakter2() { return getTokens(GrammatikParser.NichtWichtigCharakter2); }
		public TerminalNode NichtWichtigCharakter2(int i) {
			return getToken(GrammatikParser.NichtWichtigCharakter2, i);
		}
		public List<TerminalNode> Gleich() { return getTokens(GrammatikParser.Gleich); }
		public TerminalNode Gleich(int i) {
			return getToken(GrammatikParser.Gleich, i);
		}
		public List<TerminalNode> DoopeltPunkt() { return getTokens(GrammatikParser.DoopeltPunkt); }
		public TerminalNode DoopeltPunkt(int i) {
			return getToken(GrammatikParser.DoopeltPunkt, i);
		}
		public List<TerminalNode> Gleichung() { return getTokens(GrammatikParser.Gleichung); }
		public TerminalNode Gleichung(int i) {
			return getToken(GrammatikParser.Gleichung, i);
		}
		public List<TerminalNode> CommaPunkt() { return getTokens(GrammatikParser.CommaPunkt); }
		public TerminalNode CommaPunkt(int i) {
			return getToken(GrammatikParser.CommaPunkt, i);
		}
		public List<TerminalNode> Plus() { return getTokens(GrammatikParser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(GrammatikParser.Plus, i);
		}
		public List<TerminalNode> Minus() { return getTokens(GrammatikParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(GrammatikParser.Minus, i);
		}
		public List<TerminalNode> Komma() { return getTokens(GrammatikParser.Komma); }
		public TerminalNode Komma(int i) {
			return getToken(GrammatikParser.Komma, i);
		}
		public List<TerminalNode> Mal() { return getTokens(GrammatikParser.Mal); }
		public TerminalNode Mal(int i) {
			return getToken(GrammatikParser.Mal, i);
		}
		public List<TerminalNode> KlammerZu() { return getTokens(GrammatikParser.KlammerZu); }
		public TerminalNode KlammerZu(int i) {
			return getToken(GrammatikParser.KlammerZu, i);
		}
		public List<TerminalNode> Div() { return getTokens(GrammatikParser.Div); }
		public TerminalNode Div(int i) {
			return getToken(GrammatikParser.Div, i);
		}
		public List<TerminalNode> KlammerAuf() { return getTokens(GrammatikParser.KlammerAuf); }
		public TerminalNode KlammerAuf(int i) {
			return getToken(GrammatikParser.KlammerAuf, i);
		}
		public List<TerminalNode> NichtGleich() { return getTokens(GrammatikParser.NichtGleich); }
		public TerminalNode NichtGleich(int i) {
			return getToken(GrammatikParser.NichtGleich, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(343);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << Value) | (1L << Gleich) | (1L << DoopeltPunkt) | (1L << Gleichung) | (1L << CommaPunkt) | (1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div) | (1L << NichtGleich) | (1L << KlammerAuf) | (1L << KlammerZu) | (1L << Komma) | (1L << NichtWichtigCharakter1) | (1L << NichtWichtigCharakter2))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(346); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << Value) | (1L << Gleich) | (1L << DoopeltPunkt) | (1L << Gleichung) | (1L << CommaPunkt) | (1L << Plus) | (1L << Minus) | (1L << Mal) | (1L << Div) | (1L << NichtGleich) | (1L << KlammerAuf) | (1L << KlammerZu) | (1L << Komma) | (1L << NichtWichtigCharakter1) | (1L << NichtWichtigCharakter2))) != 0) );
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

	public static class MacroNameAnrufContext extends ParserRuleContext {
		public TerminalNode MacroName() { return getToken(GrammatikParser.MacroName, 0); }
		public TerminalNode KlammerAuf() { return getToken(GrammatikParser.KlammerAuf, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode KlammerZu() { return getToken(GrammatikParser.KlammerZu, 0); }
		public MacroNameAnrufContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroNameAnruf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).enterMacroNameAnruf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammatikListener ) ((GrammatikListener)listener).exitMacroNameAnruf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammatikVisitor ) return ((GrammatikVisitor<? extends T>)visitor).visitMacroNameAnruf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroNameAnrufContext macroNameAnruf() throws RecognitionException {
		MacroNameAnrufContext _localctx = new MacroNameAnrufContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_macroNameAnruf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(MacroName);
			setState(349);
			match(KlammerAuf);
			setState(350);
			parameters(0);
			setState(351);
			match(KlammerZu);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return loops_sempred((LoopsContext)_localctx, predIndex);
		case 6:
			return whiles_sempred((WhilesContext)_localctx, predIndex);
		case 12:
			return gotoProgram_sempred((GotoProgramContext)_localctx, predIndex);
		case 19:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 21:
			return macroLoops_sempred((MacroLoopsContext)_localctx, predIndex);
		case 23:
			return macroWhiles_sempred((MacroWhilesContext)_localctx, predIndex);
		case 25:
			return macroGotos_sempred((MacroGotosContext)_localctx, predIndex);
		case 27:
			return parameters_sempred((ParametersContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean loops_sempred(LoopsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean whiles_sempred(WhilesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gotoProgram_sempred(GotoProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean macroLoops_sempred(MacroLoopsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean macroWhiles_sempred(MacroWhilesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean macroGotos_sempred(MacroGotosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean parameters_sempred(ParametersContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0164\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\5\2@"+
		"\n\2\3\2\3\2\3\2\3\2\5\2F\n\2\3\2\3\2\3\2\3\2\5\2L\n\2\3\2\3\2\5\2P\n"+
		"\2\3\2\3\2\5\2T\n\2\3\3\3\3\3\3\3\3\3\3\5\3[\n\3\3\3\3\3\3\3\7\3`\n\3"+
		"\f\3\16\3c\13\3\3\4\3\4\3\4\3\4\3\4\5\4j\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\5\5s\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\u0080\n\b"+
		"\3\b\3\b\3\b\7\b\u0085\n\b\f\b\16\b\u0088\13\b\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u008f\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u0098\n\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a4\n\13\3\f\3\f\3\f\3\f\3\r\5\r"+
		"\u00ab\n\r\3\r\3\r\5\r\u00af\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00b7"+
		"\n\16\f\16\16\16\u00ba\13\16\3\17\5\17\u00bd\n\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\5\20\u00c5\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\6\25\u00d9\n\25\r\25\16"+
		"\25\u00da\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\6\25\u00ed\n\25\r\25\16\25\u00ee\3\25\3\25\3\25\5"+
		"\25\u00f4\n\25\3\25\3\25\3\25\7\25\u00f9\n\25\f\25\16\25\u00fc\13\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0106\n\26\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u010d\n\27\3\27\7\27\u0110\n\27\f\27\16\27\u0113\13\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0123\n\31\3\31\7\31\u0126\n\31\f\31\16\31\u0129\13\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0139"+
		"\n\33\3\33\7\33\u013c\n\33\f\33\16\33\u013f\13\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u0149\n\34\3\34\3\34\3\35\3\35\3\35\5\35\u0150"+
		"\n\35\3\35\3\35\3\35\7\35\u0155\n\35\f\35\16\35\u0158\13\35\3\36\6\36"+
		"\u015b\n\36\r\36\16\36\u015c\3\37\3\37\3\37\3\37\3\37\3\37\2\n\4\16\32"+
		"(,\60\648 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<\2\5\3\2\27\32\4\2\25\25\33\33\5\2\17\17\21\21\23 \2\u0173\2S\3\2\2"+
		"\2\4Z\3\2\2\2\6d\3\2\2\2\bm\3\2\2\2\nv\3\2\2\2\fx\3\2\2\2\16\177\3\2\2"+
		"\2\20\u0089\3\2\2\2\22\u0092\3\2\2\2\24\u00a3\3\2\2\2\26\u00a5\3\2\2\2"+
		"\30\u00aa\3\2\2\2\32\u00b0\3\2\2\2\34\u00bc\3\2\2\2\36\u00c4\3\2\2\2 "+
		"\u00c6\3\2\2\2\"\u00c9\3\2\2\2$\u00ce\3\2\2\2&\u00d1\3\2\2\2(\u00f3\3"+
		"\2\2\2*\u0105\3\2\2\2,\u0107\3\2\2\2.\u0114\3\2\2\2\60\u011d\3\2\2\2\62"+
		"\u012a\3\2\2\2\64\u0133\3\2\2\2\66\u0140\3\2\2\28\u014f\3\2\2\2:\u015a"+
		"\3\2\2\2<\u015e\3\2\2\2>@\5,\27\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\5\4"+
		"\3\2BC\7\2\2\3CT\3\2\2\2DF\5\60\31\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\5"+
		"\16\b\2HI\7\2\2\3IT\3\2\2\2JL\5\64\33\2KJ\3\2\2\2KL\3\2\2\2LO\3\2\2\2"+
		"MP\5\26\f\2NP\5\30\r\2OM\3\2\2\2ON\3\2\2\2PQ\3\2\2\2QR\7\2\2\3RT\3\2\2"+
		"\2S?\3\2\2\2SE\3\2\2\2SK\3\2\2\2T\3\3\2\2\2UV\b\3\1\2V[\5&\24\2W[\5<\37"+
		"\2X[\5\b\5\2Y[\5\6\4\2ZU\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[a\3\2\2"+
		"\2\\]\f\4\2\2]^\7\26\2\2^`\5\4\3\5_\\\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3"+
		"\2\2\2b\5\3\2\2\2ca\3\2\2\2de\7\3\2\2ef\5\n\6\2fi\7\7\2\2gj\5\4\3\2hj"+
		"\5\f\7\2ig\3\2\2\2ih\3\2\2\2jk\3\2\2\2kl\7\b\2\2l\7\3\2\2\2mn\7\5\2\2"+
		"no\5*\26\2or\7\6\2\2ps\5\4\3\2qs\5\f\7\2rp\3\2\2\2rq\3\2\2\2st\3\2\2\2"+
		"tu\7\b\2\2u\t\3\2\2\2vw\5(\25\2w\13\3\2\2\2xy\3\2\2\2y\r\3\2\2\2z{\b\b"+
		"\1\2{\u0080\5&\24\2|\u0080\5<\37\2}\u0080\5\22\n\2~\u0080\5\20\t\2\177"+
		"z\3\2\2\2\177|\3\2\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080\u0086\3\2\2\2\u0081"+
		"\u0082\f\4\2\2\u0082\u0083\7\26\2\2\u0083\u0085\5\16\b\5\u0084\u0081\3"+
		"\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\17\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\4\2\2\u008a\u008b\5\24\13"+
		"\2\u008b\u008e\7\7\2\2\u008c\u008f\5\16\b\2\u008d\u008f\5\f\7\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\b"+
		"\2\2\u0091\21\3\2\2\2\u0092\u0093\7\5\2\2\u0093\u0094\5*\26\2\u0094\u0097"+
		"\7\6\2\2\u0095\u0098\5\16\b\2\u0096\u0098\5\f\7\2\u0097\u0095\3\2\2\2"+
		"\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\b\2\2\u009a\23"+
		"\3\2\2\2\u009b\u009c\5(\25\2\u009c\u009d\7\33\2\2\u009d\u009e\7\20\2\2"+
		"\u009e\u00a4\3\2\2\2\u009f\u00a0\7\34\2\2\u00a0\u00a1\5\24\13\2\u00a1"+
		"\u00a2\7\35\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009f\3"+
		"\2\2\2\u00a4\25\3\2\2\2\u00a5\u00a6\5\32\16\2\u00a6\u00a7\7\26\2\2\u00a7"+
		"\u00a8\5\30\r\2\u00a8\27\3\2\2\2\u00a9\u00ab\5$\23\2\u00aa\u00a9\3\2\2"+
		"\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00af\7\n\2\2\u00ad\u00af"+
		"\5 \21\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\31\3\2\2\2\u00b0"+
		"\u00b1\b\16\1\2\u00b1\u00b2\5\34\17\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4"+
		"\f\3\2\2\u00b4\u00b5\7\26\2\2\u00b5\u00b7\5\32\16\4\u00b6\u00b3\3\2\2"+
		"\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\33"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\5$\23\2\u00bc\u00bb\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5\36\20\2\u00bf\35\3\2"+
		"\2\2\u00c0\u00c5\5&\24\2\u00c1\u00c5\5<\37\2\u00c2\u00c5\5 \21\2\u00c3"+
		"\u00c5\5\"\22\2\u00c4\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3"+
		"\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c7\7\t\2\2\u00c7"+
		"\u00c8\7\r\2\2\u00c8!\3\2\2\2\u00c9\u00ca\7\5\2\2\u00ca\u00cb\5*\26\2"+
		"\u00cb\u00cc\7\6\2\2\u00cc\u00cd\5 \21\2\u00cd#\3\2\2\2\u00ce\u00cf\7"+
		"\r\2\2\u00cf\u00d0\7\24\2\2\u00d0%\3\2\2\2\u00d1\u00d2\7\17\2\2\u00d2"+
		"\u00d3\7\23\2\2\u00d3\u00d4\5(\25\2\u00d4\'\3\2\2\2\u00d5\u00d6\b\25\1"+
		"\2\u00d6\u00f4\7\17\2\2\u00d7\u00d9\7\20\2\2\u00d8\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00f4\3\2"+
		"\2\2\u00dc\u00f4\7\21\2\2\u00dd\u00de\7\34\2\2\u00de\u00df\5(\25\2\u00df"+
		"\u00e0\7\35\2\2\u00e0\u00f4\3\2\2\2\u00e1\u00e2\7\34\2\2\u00e2\u00e3\5"+
		"(\25\2\u00e3\u00e4\t\2\2\2\u00e4\u00e5\5(\25\2\u00e5\u00e6\7\35\2\2\u00e6"+
		"\u00f4\3\2\2\2\u00e7\u00e8\7\34\2\2\u00e8\u00e9\5(\25\2\u00e9\u00ea\t"+
		"\2\2\2\u00ea\u00ec\5(\25\2\u00eb\u00ed\7\35\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f1\5(\25\4\u00f1\u00f4\3\2\2\2\u00f2\u00f4\5<\37\2\u00f3"+
		"\u00d5\3\2\2\2\u00f3\u00d8\3\2\2\2\u00f3\u00dc\3\2\2\2\u00f3\u00dd\3\2"+
		"\2\2\u00f3\u00e1\3\2\2\2\u00f3\u00e7\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00fa\3\2\2\2\u00f5\u00f6\f\6\2\2\u00f6\u00f7\t\2\2\2\u00f7\u00f9\5("+
		"\25\7\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb)\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\5(\25\2"+
		"\u00fe\u00ff\t\3\2\2\u00ff\u0100\5(\25\2\u0100\u0106\3\2\2\2\u0101\u0102"+
		"\7\34\2\2\u0102\u0103\5*\26\2\u0103\u0104\7\35\2\2\u0104\u0106\3\2\2\2"+
		"\u0105\u00fd\3\2\2\2\u0105\u0101\3\2\2\2\u0106+\3\2\2\2\u0107\u0108\b"+
		"\27\1\2\u0108\u0109\5.\30\2\u0109\u0111\3\2\2\2\u010a\u010c\f\3\2\2\u010b"+
		"\u010d\5:\36\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u0110\5.\30\2\u010f\u010a\3\2\2\2\u0110\u0113\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112-\3\2\2\2\u0113\u0111\3\2\2\2"+
		"\u0114\u0115\7\13\2\2\u0115\u0116\7\16\2\2\u0116\u0117\7\34\2\2\u0117"+
		"\u0118\58\35\2\u0118\u0119\7\35\2\2\u0119\u011a\7\25\2\2\u011a\u011b\5"+
		"\4\3\2\u011b\u011c\7\f\2\2\u011c/\3\2\2\2\u011d\u011e\b\31\1\2\u011e\u011f"+
		"\5\62\32\2\u011f\u0127\3\2\2\2\u0120\u0122\f\3\2\2\u0121\u0123\5:\36\2"+
		"\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126"+
		"\5\62\32\2\u0125\u0120\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2"+
		"\u0127\u0128\3\2\2\2\u0128\61\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b"+
		"\7\13\2\2\u012b\u012c\7\16\2\2\u012c\u012d\7\34\2\2\u012d\u012e\58\35"+
		"\2\u012e\u012f\7\35\2\2\u012f\u0130\7\25\2\2\u0130\u0131\5\16\b\2\u0131"+
		"\u0132\7\f\2\2\u0132\63\3\2\2\2\u0133\u0134\b\33\1\2\u0134\u0135\5\66"+
		"\34\2\u0135\u013d\3\2\2\2\u0136\u0138\f\3\2\2\u0137\u0139\5:\36\2\u0138"+
		"\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\5\66"+
		"\34\2\u013b\u0136\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\65\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7\13\2"+
		"\2\u0141\u0142\7\16\2\2\u0142\u0143\7\34\2\2\u0143\u0144\58\35\2\u0144"+
		"\u0145\7\35\2\2\u0145\u0148\7\25\2\2\u0146\u0149\5\26\f\2\u0147\u0149"+
		"\5\30\r\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2\2\2"+
		"\u014a\u014b\7\f\2\2\u014b\67\3\2\2\2\u014c\u014d\b\35\1\2\u014d\u0150"+
		"\7\17\2\2\u014e\u0150\5\f\7\2\u014f\u014c\3\2\2\2\u014f\u014e\3\2\2\2"+
		"\u0150\u0156\3\2\2\2\u0151\u0152\f\4\2\2\u0152\u0153\7\36\2\2\u0153\u0155"+
		"\7\17\2\2\u0154\u0151\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2"+
		"\u0156\u0157\3\2\2\2\u01579\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015b\t"+
		"\4\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d;\3\2\2\2\u015e\u015f\7\16\2\2\u015f\u0160\7\34\2"+
		"\2\u0160\u0161\58\35\2\u0161\u0162\7\35\2\2\u0162=\3\2\2\2$?EKOSZair\177"+
		"\u0086\u008e\u0097\u00a3\u00aa\u00ae\u00b8\u00bc\u00c4\u00da\u00ee\u00f3"+
		"\u00fa\u0105\u010c\u0111\u0122\u0127\u0138\u013d\u0148\u014f\u0156\u015c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}