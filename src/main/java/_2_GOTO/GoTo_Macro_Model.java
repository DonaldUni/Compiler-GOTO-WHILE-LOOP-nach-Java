package main.java._2_GOTO;

import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import main.java._0_ParserGrammatik.GrammatikParser;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class GoTo_Macro_Model extends GrammatikBaseVisitor<Void> {

    private OrderedHashMap<Integer, String> allKomponente = new OrderedHashMap<>();
    private ArrayList<Integer> macroslist = new ArrayList<>();              // enthält die macro
    private ArrayList<String> all_macro_names = new ArrayList<>();
    private ArrayList<ParseTree> gotoslist = new ArrayList<>();             // enthält alle loop context in program
    private ArrayList<Boolean> halt_program = new ArrayList<>();
    private ArrayList<Integer> parameters_Anzahl = new ArrayList<>();       // Anzahl von Parameter für jeden definierten Macro
    private ArrayList<String> parameters_names = new ArrayList<>();         // enthält alle parameter die in macro definition genuzt geworden sind


    private ParseTree gotosContext ;        // ist der Context für den haupt loop des programm

    private boolean hat_fehler = true;


    private int komponenterCounter = 0;
    private int macroCounter = 0;
    private int paramCounter = 0;

    protected GoTo_Macro_Model(ParseTree tree) {  visit(tree); }

        /* Der code unten verhält sich genau wie die grammatik, d.h. wenn eine Method eines Elementes  ein andere Element trifft,
      bearbeitet sie es und ruft seine entprechende Method.
     Um besser zu verstehen ist die Grammatik Defintion "Grammatikg4.txt" eine große Hilfe
      */

    @Override
    public Void visitProgram(GrammatikParser.ProgramContext ctx) { // kummert ich um die Bearbeitung von Program Rule   und ruft die passende visit Methode

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroGotosContext")){

                visitMacroGotos(ctx.macroGotos());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotosContext")){
                gotosContext = ctx.gotos();
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoEndeContext")){
                gotosContext = ctx.gotoEnde();
            }
        }

        return null;
    }

    // Läuft durch alle Kinder  von MacroGotos rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroGotos(GrammatikParser.MacroGotosContext ctx) {

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroGotoContext")){

                macroslist.add(macroCounter);
                all_macro_names.add(ctx.macroGoto().MacroName().getText());
                visitMacroGoto(ctx.macroGoto());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("TextContext")){
                hat_fehler = false ;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroGotosContext")){

                visitMacroGotos(ctx.macroGotos());
            }
        }

        return null;
    }

    // Läuft durch alle Kinder  von MacroGoto rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroGoto(GrammatikParser.MacroGotoContext ctx) {

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

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotosContext")){

                gotoslist.add(ctx.gotos());
                halt_program.add(false);
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoEndeContext")){

                gotoslist.add(ctx.gotoEnde());
                halt_program.add(true);
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

    protected ArrayList<ParseTree> getGotoslist() {
        return gotoslist;
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

    protected ParseTree getGotosContext() {
        return gotosContext;
    }

    protected ArrayList<String> getAll_macro_names() {
        return all_macro_names;
    }

    protected ArrayList<Boolean> getHalt_program() {
        return halt_program;
    }
}
