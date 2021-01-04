// Generated from D:/Universität/Bachelor Cyklus/7 Semester/Bacherlor Arbeit/Compiler/src/main/java/_0_ParserGrammatik\Grammatik.g4 by ANTLR 4.7.2
package main.java._0_ParserGrammatik;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammatikParser}.
 */
public interface GrammatikListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammatikParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammatikParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#loops}.
	 * @param ctx the parse tree
	 */
	void enterLoops(GrammatikParser.LoopsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#loops}.
	 * @param ctx the parse tree
	 */
	void exitLoops(GrammatikParser.LoopsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#loopProgram}.
	 * @param ctx the parse tree
	 */
	void enterLoopProgram(GrammatikParser.LoopProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#loopProgram}.
	 * @param ctx the parse tree
	 */
	void exitLoopProgram(GrammatikParser.LoopProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#ifLoop}.
	 * @param ctx the parse tree
	 */
	void enterIfLoop(GrammatikParser.IfLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#ifLoop}.
	 * @param ctx the parse tree
	 */
	void exitIfLoop(GrammatikParser.IfLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#counter}.
	 * @param ctx the parse tree
	 */
	void enterCounter(GrammatikParser.CounterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#counter}.
	 * @param ctx the parse tree
	 */
	void exitCounter(GrammatikParser.CounterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#nichts}.
	 * @param ctx the parse tree
	 */
	void enterNichts(GrammatikParser.NichtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#nichts}.
	 * @param ctx the parse tree
	 */
	void exitNichts(GrammatikParser.NichtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#whiles}.
	 * @param ctx the parse tree
	 */
	void enterWhiles(GrammatikParser.WhilesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#whiles}.
	 * @param ctx the parse tree
	 */
	void exitWhiles(GrammatikParser.WhilesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#whileProgram}.
	 * @param ctx the parse tree
	 */
	void enterWhileProgram(GrammatikParser.WhileProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#whileProgram}.
	 * @param ctx the parse tree
	 */
	void exitWhileProgram(GrammatikParser.WhileProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#ifWhile}.
	 * @param ctx the parse tree
	 */
	void enterIfWhile(GrammatikParser.IfWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#ifWhile}.
	 * @param ctx the parse tree
	 */
	void exitIfWhile(GrammatikParser.IfWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(GrammatikParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(GrammatikParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#gotos}.
	 * @param ctx the parse tree
	 */
	void enterGotos(GrammatikParser.GotosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#gotos}.
	 * @param ctx the parse tree
	 */
	void exitGotos(GrammatikParser.GotosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#gotoEnde}.
	 * @param ctx the parse tree
	 */
	void enterGotoEnde(GrammatikParser.GotoEndeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#gotoEnde}.
	 * @param ctx the parse tree
	 */
	void exitGotoEnde(GrammatikParser.GotoEndeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#gotoProgram}.
	 * @param ctx the parse tree
	 */
	void enterGotoProgram(GrammatikParser.GotoProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#gotoProgram}.
	 * @param ctx the parse tree
	 */
	void exitGotoProgram(GrammatikParser.GotoProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#gotoCode}.
	 * @param ctx the parse tree
	 */
	void enterGotoCode(GrammatikParser.GotoCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#gotoCode}.
	 * @param ctx the parse tree
	 */
	void exitGotoCode(GrammatikParser.GotoCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#gotoInstructions}.
	 * @param ctx the parse tree
	 */
	void enterGotoInstructions(GrammatikParser.GotoInstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#gotoInstructions}.
	 * @param ctx the parse tree
	 */
	void exitGotoInstructions(GrammatikParser.GotoInstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#gotoAssign}.
	 * @param ctx the parse tree
	 */
	void enterGotoAssign(GrammatikParser.GotoAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#gotoAssign}.
	 * @param ctx the parse tree
	 */
	void exitGotoAssign(GrammatikParser.GotoAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#ifGoto}.
	 * @param ctx the parse tree
	 */
	void enterIfGoto(GrammatikParser.IfGotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#ifGoto}.
	 * @param ctx the parse tree
	 */
	void exitIfGoto(GrammatikParser.IfGotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#marken}.
	 * @param ctx the parse tree
	 */
	void enterMarken(GrammatikParser.MarkenContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#marken}.
	 * @param ctx the parse tree
	 */
	void exitMarken(GrammatikParser.MarkenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(GrammatikParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(GrammatikParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(GrammatikParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(GrammatikParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#expIf}.
	 * @param ctx the parse tree
	 */
	void enterExpIf(GrammatikParser.ExpIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#expIf}.
	 * @param ctx the parse tree
	 */
	void exitExpIf(GrammatikParser.ExpIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroLoops}.
	 * @param ctx the parse tree
	 */
	void enterMacroLoops(GrammatikParser.MacroLoopsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroLoops}.
	 * @param ctx the parse tree
	 */
	void exitMacroLoops(GrammatikParser.MacroLoopsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroLoop}.
	 * @param ctx the parse tree
	 */
	void enterMacroLoop(GrammatikParser.MacroLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroLoop}.
	 * @param ctx the parse tree
	 */
	void exitMacroLoop(GrammatikParser.MacroLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroWhiles}.
	 * @param ctx the parse tree
	 */
	void enterMacroWhiles(GrammatikParser.MacroWhilesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroWhiles}.
	 * @param ctx the parse tree
	 */
	void exitMacroWhiles(GrammatikParser.MacroWhilesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroWhile}.
	 * @param ctx the parse tree
	 */
	void enterMacroWhile(GrammatikParser.MacroWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroWhile}.
	 * @param ctx the parse tree
	 */
	void exitMacroWhile(GrammatikParser.MacroWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroGotos}.
	 * @param ctx the parse tree
	 */
	void enterMacroGotos(GrammatikParser.MacroGotosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroGotos}.
	 * @param ctx the parse tree
	 */
	void exitMacroGotos(GrammatikParser.MacroGotosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroGoto}.
	 * @param ctx the parse tree
	 */
	void enterMacroGoto(GrammatikParser.MacroGotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroGoto}.
	 * @param ctx the parse tree
	 */
	void exitMacroGoto(GrammatikParser.MacroGotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(GrammatikParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(GrammatikParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(GrammatikParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(GrammatikParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammatikParser#macroNameAnruf}.
	 * @param ctx the parse tree
	 */
	void enterMacroNameAnruf(GrammatikParser.MacroNameAnrufContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammatikParser#macroNameAnruf}.
	 * @param ctx the parse tree
	 */
	void exitMacroNameAnruf(GrammatikParser.MacroNameAnrufContext ctx);
}