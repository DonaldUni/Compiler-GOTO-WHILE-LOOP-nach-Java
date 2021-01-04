// Generated from D:/Universität/Bachelor Cyklus/7 Semester/Bacherlor Arbeit/Compiler/src/main/java/_0_ParserGrammatik\Grammatik.g4 by ANTLR 4.7.2
package main.java._0_ParserGrammatik;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammatikParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammatikVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammatikParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#loops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoops(GrammatikParser.LoopsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#loopProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopProgram(GrammatikParser.LoopProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#ifLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfLoop(GrammatikParser.IfLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#counter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounter(GrammatikParser.CounterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#nichts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNichts(GrammatikParser.NichtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#whiles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhiles(GrammatikParser.WhilesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#whileProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileProgram(GrammatikParser.WhileProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#ifWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfWhile(GrammatikParser.IfWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(GrammatikParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#gotos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotos(GrammatikParser.GotosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#gotoEnde}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoEnde(GrammatikParser.GotoEndeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#gotoProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoProgram(GrammatikParser.GotoProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#gotoCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoCode(GrammatikParser.GotoCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#gotoInstructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoInstructions(GrammatikParser.GotoInstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#gotoAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoAssign(GrammatikParser.GotoAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#ifGoto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfGoto(GrammatikParser.IfGotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#marken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarken(GrammatikParser.MarkenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(GrammatikParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(GrammatikParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#expIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIf(GrammatikParser.ExpIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroLoops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroLoops(GrammatikParser.MacroLoopsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroLoop(GrammatikParser.MacroLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroWhiles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroWhiles(GrammatikParser.MacroWhilesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroWhile(GrammatikParser.MacroWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroGotos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroGotos(GrammatikParser.MacroGotosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroGoto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroGoto(GrammatikParser.MacroGotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(GrammatikParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(GrammatikParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammatikParser#macroNameAnruf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroNameAnruf(GrammatikParser.MacroNameAnrufContext ctx);
}