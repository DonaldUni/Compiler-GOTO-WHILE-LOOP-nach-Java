package main.java._2_LOOP;

import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import main.java._0_ParserGrammatik.GrammatikParser;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class Loop_Macro_Model extends GrammatikBaseVisitor<Void> {

    private OrderedHashMap <Integer, String> allKomponente = new OrderedHashMap<>();
    private ArrayList<Integer> macroslist = new ArrayList<>();                          // enthält die macro
    private ArrayList<String> all_macro_names = new ArrayList<>();
    private ArrayList<ParseTree> loopslist = new ArrayList<>();                         // enthält alle loop context in program
    private ArrayList<Integer> parameters_Anzahl = new ArrayList<>();                   // Anzahl von Parameter für jeden definierten Macro
    private ArrayList<String> parameters_names = new ArrayList<>();                     // enthält alle parameter die in macro definition genuzt geworden sind

    private ParseTree loopsContext ;                    // ist der Context für den haupt loop des programm
    private boolean hat_fehler = true;


    private int komponenterCounter = 0;
    private int macroCounter = 0;
    private int paramCounter = 0;

    protected Loop_Macro_Model(ParseTree tree) { visit(tree); }


    /* Der code unten verhält sich genau wie die grammatik, d.h. wenn eine Method eines Elementes  ein andere Element trifft,
      bearbeitet sie es und ruft seine entprechende Method.
     Um besser zu verstehen ist die Grammatik Defintion "Grammatikg4.txt" eine große Hilfe
      */

    @Override
    public Void visitProgram(GrammatikParser.ProgramContext ctx) {  // kummert ich um die Bearbeitung von Program Rule

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroLoopsContext")){

                visitMacroLoops(ctx.macroLoops());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("LoopsContext")){
                loopsContext = ctx.loops();
            }

        }
        return null;
    }

    // Läuft durch alle Kinder  von MacroLoops rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroLoops(GrammatikParser.MacroLoopsContext ctx) {

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroLoopContext")){

                macroslist.add(macroCounter);
                all_macro_names.add(ctx.macroLoop().MacroName().getText());
                visitMacroLoop(ctx.macroLoop());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("TextContext")){
                hat_fehler = false ;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroLoopsContext")){

                visitMacroLoops(ctx.macroLoops());
            }
        }
        return null;
    }

    // Läuft durch alle Kinder  von MacroLoop rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroLoop(GrammatikParser.MacroLoopContext ctx) {
        String text = "";
        for (int i = 0; i < ctx.getChildCount() ; i++) {

            text = ctx.getChild(i).getText() ;

            if (ctx.getChild(i).getClass().getSimpleName().equals("TerminalNodeImpl")){
                allKomponente.put(komponenterCounter, text);
                ++ komponenterCounter ;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("ParametersContext")){
                visitParameters(ctx.parameters());
                parameters_Anzahl.add(paramCounter);
                paramCounter = 0;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("LoopsContext")){

                loopslist.add(ctx.loops());
            }
        }

        ++macroCounter;
        return null;
    }

    // Läuft durch alle Kinder  von Parameter rules und rechnet die passende Anweisungen
    @Override
    public Void visitParameters(GrammatikParser.ParametersContext ctx) {
        String text = "";
        for (int i = 0; i < ctx.getChildCount() ; i++) {

            text = ctx.getChild(i).getText() ;

            if (ctx.getChild(i).getClass().getSimpleName().equals("ParametersContext")){
                visitParameters(ctx.parameters());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("TerminalNodeImpl")){
                allKomponente.put(komponenterCounter, text );
                ++ komponenterCounter;

                if (!text.equals(",")){ // falls es eine Variable ist

                    parameters_names.add(text);
                    ++paramCounter;

                }
            }
        }

        return null;
    }

    protected OrderedHashMap<Integer, String> getAllKomponente() {
        return allKomponente;
    }

    protected ArrayList<Integer> getMacroslist() {
        return macroslist;
    }

    protected ArrayList<ParseTree> getLoopslist() {
        return loopslist;
    }

    protected ArrayList<Integer> getParameters_Anzahl() {
        return parameters_Anzahl;
    }

    protected ArrayList<String> getParameters_names() {
        return parameters_names;
    }

    protected boolean isFehler() {
        return hat_fehler;
    }

    protected ParseTree getLoopsContext() {
        return loopsContext;
    }

    protected ArrayList<String> getAll_macro_names() {
        return all_macro_names;
    }
}
