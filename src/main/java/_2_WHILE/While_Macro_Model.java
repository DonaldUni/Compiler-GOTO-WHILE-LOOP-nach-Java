package main.java._2_WHILE;

import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import main.java._0_ParserGrammatik.GrammatikParser;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class While_Macro_Model extends GrammatikBaseVisitor<Void> {

    private OrderedHashMap<Integer, String> allKomponente = new OrderedHashMap<>();
    private ArrayList<Integer> macroslist = new ArrayList<>();                  // enthält die macro
    private ArrayList<String> all_macro_names = new ArrayList<>();
    private ArrayList<ParseTree> whileslist = new ArrayList<>();                // enthält alle while context in program
    private ArrayList<Integer> parameters_Anzahl = new ArrayList<>();           // Anzahl von Parameter für jeden definierten Macro
    private ArrayList<String> parameters_names = new ArrayList<>();             // enthält alle parameter die in macro definition genuzt geworden sind

    private ParseTree whilesContext ;                       // ist der Context für den haupt loop des programm
    private boolean hat_fehler = true;


    private int komponenterCounter = 0;
    private int macroCounter = 0;
    private int paramCounter = 0;

    protected While_Macro_Model(ParseTree tree) { visit(tree); }


    /* Der code unten verhält sich genau wie die grammatik, d.h. wenn eine Method eines Elementes  ein andere Element trifft,
      bearbeitet sie es und ruft seine entprechende Method.
     Um besser zu verstehen ist die Grammatik Defintion "Grammatikg4.txt" eine große Hilfe
      */

    @Override
    public Void visitProgram(GrammatikParser.ProgramContext ctx) {          // kummert ich um die Bearbeitung von Program Rule

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroWhilesContext")){

                visitMacroWhiles(ctx.macroWhiles());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("WhilesContext")){
                whilesContext = ctx.whiles();
            }

        }
        return null;
    }

    // Läuft durch alle Kinder  von MacroWhiless rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroWhiles(GrammatikParser.MacroWhilesContext ctx) {
        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroWhileContext")){

                macroslist.add(macroCounter);
                all_macro_names.add(ctx.macroWhile().MacroName().getText());
                visitMacroWhile(ctx.macroWhile());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("TextContext")){
                hat_fehler = false ;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroWhilesContext")){

                visitMacroWhiles(ctx.macroWhiles());
            }
        }
        return null;
    }

    // Läuft durch alle Kinder  von MacroWhile rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroWhile(GrammatikParser.MacroWhileContext ctx) {
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

            if (ctx.getChild(i).getClass().getSimpleName().equals("WhilesContext")){

                whileslist.add(ctx.whiles());

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


    public OrderedHashMap<Integer, String> getAllKomponente() {
        return allKomponente;
    }

    public ArrayList<Integer> getMacroslist() {
        return macroslist;
    }

    public ArrayList<ParseTree> getWhileslist() {
        return whileslist;
    }

    public ArrayList<Integer> getParameters_Anzahl() {
        return parameters_Anzahl;
    }

    public ArrayList<String> getParameters_names() {
        return parameters_names;
    }

    public boolean isFehler() {
        return hat_fehler;
    }

    public ParseTree getWhilesContext() {
        return whilesContext;
    }

    public ArrayList<String> getAll_macro_names() {
        return all_macro_names;
    }
}
