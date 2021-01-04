package main.java._2_WHILE;

import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import main.java._0_ParserGrammatik.GrammatikParser;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Map;

public class While_Model  extends GrammatikBaseVisitor<Void> {


    protected While_Model(ParseTree tree) { visit(tree); }

    private Map<Integer, String> map = new OrderedHashMap<>();  // hier werden alle nötigen Elemente des Programes speichert
    private ArrayList<String> parameter_names = new ArrayList<>(); // hier werden nur die Name von variablen gespeichert
    private ArrayList<String> variables_names = new ArrayList<>();

    // die Strukturen, die sich um Macro kummern
    private ArrayList<String> macro_anruf = new ArrayList<>();
    private ArrayList<String> all_macro_Name_anruf = new ArrayList<>();
    private ArrayList<Integer> macro_anzahl_param_name_ = new ArrayList<>();
    private ArrayList<String> macro_param_name = new ArrayList<>();
    private ArrayList<String> macro_deklarierte_param_name = new ArrayList<>();

    private int macro_param_counter = 0;
    private int macro_dklarierte_param_count = 0;
    private int macro_counter = -1;
    private int counter = 0;   // Schlussel für den map

    /* Der code unten verhält sich genau wie die grammatik, d.h. wenn eine Method eines Elementes  ein andere Element trifft,
      bearbeitet sie es und ruft seine entprechende Method.
     Um besser zu verstehen ist die Grammatik Defintion "Grammatikg4.txt" eine große Hilfe
      */

    @Override
    public Void visitProgram(GrammatikParser.ProgramContext ctx) {  // kummert ich um die Bearbeitung von Program Rule und ruft visitWhiles

        visitWhiles(ctx.whiles());
        return null;
    }

    @Override
    public Void visitWhiles(GrammatikParser.WhilesContext ctx) {

        // Läuft durch alle Kinder und rechnet die passende Anweisungen
        int whilesCounter = -1;
        for (int i = 0 ; i < ctx.getChildCount(); i++){

            String text = ctx.getChild(i).getText();

            if (ctx.getChild(i).getClass().getSimpleName().equals("AssignContext") ){ // Wenn es ein assign ist
                text = space(text) + ";";
                map.put(counter, text);  // Speicherung der Anweisung
                ++ counter ;

                visitAssign(ctx.assign());  // ruft von entsprechenden visitMethod

                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroNameAnrufContext")){

                map.put(counter,text + ";");   // Speicherung des Wortes
                ++ counter ;

                ++ macro_counter;
                visitMacroNameAnruf(ctx.macroNameAnruf());
                ///
                macro_anruf.add(text);
                all_macro_Name_anruf.add(ctx.macroNameAnruf().MacroName().getText());

                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("IfWhileContext")){ // Wenn es ein IfLoop ist

                visitIfWhile(ctx.ifWhile());     // ruft von entsprechenden visitMethod
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("WhileProgramContext")){     // Wenn es ein Loop ist

                visitWhileProgram(ctx.whileProgram()); // Anruft von entsprechenden visitMethod
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("WhilesContext")){     // Wenn es ein CodeLoop ist
                ++whilesCounter;
                visitWhiles(ctx.whiles(whilesCounter)); // Anruft von entsprechenden visitMethod

            }
        }

        return null;
    }

    // Läuft durch alle Kinder  von While rules und rechnet die passende Anweisungen
    @Override
    public Void visitWhileProgram(GrammatikParser.WhileProgramContext ctx) {

        for (int i = 0 ; i < ctx.getChildCount(); i++){

            String text = ctx.getChild(i).getText();

            if (text.equals("WHILE") || text.equals("DO") || text.equals("END")  ){  // Wenn es ein Schlusselwort : LOOP, DO oder END ist

                map.put(counter,text);   // Speicherung des Wortes
                ++ counter ;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("ConditionContext")){  // Wenn es ein Counter von Loop  ist
                visitCondition(ctx.condition());
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("WhilesContext")){   // Wenn es ein LoopStatementContext ist

                visitWhiles(ctx.whiles());  // ruft von entsprechenden visitMethod
            }
        }
        return null;
    }

    // Läuft durch alle Kinder  von MacroAnruf rules und rechnet die passende Anweisungen
    @Override
    public Void visitMacroNameAnruf(GrammatikParser.MacroNameAnrufContext ctx) {

        for (int i = 0; i < ctx.getChildCount(); i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("ParametersContext")){
                visitParameters(ctx.parameters());

                macro_anzahl_param_name_.add( macro_param_counter);
                macro_param_counter = 0;
            }
        }

        ++ macro_counter;

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

                if (!text.equals(",")){ // falls es eine Variable ist

                    macro_param_name.add(text);
                    ++macro_param_counter;


                }
            }
        }

        return null;
    }

    // Läuft durch alle Kinder  von Condition rules und rechnet die passende Anweisungen
    @Override
    public Void visitCondition(GrammatikParser.ConditionContext ctx) {

        for (int i = 0; i < ctx.getChildCount(); i++) {

            String text = ctx.getChild(i).getText();
            String name = ctx.getChild(i).getClass().getSimpleName();

            if(ctx.getChild(i).getClass().getSimpleName().equals("ExpContext")){
                text = space(text)+ " != 0";
                map.put(counter, text);    // Speicherung der Anweisung
                ++ counter ;
                visitExp(ctx.exp());

                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("ConditionContext")){  // Wenn es ein LoopStatementContext ist

                try {
                    visitCondition(ctx.condition());  // ruft von entsprechenden visitMethod
                }catch ( Exception e){

                }

            }

        }
        return null;
    }

    // Läuft durch alle Kinder  von IfWhile rules und rechnet die passende Anweisungen
    @Override
    public Void visitIfWhile(GrammatikParser.IfWhileContext ctx) {

        for (int i = 0 ; i < ctx.getChildCount(); i++) {

            String text = ctx.getChild(i).getText();

            if (text.equals("IF") || text.equals("THEN") || text.equals("END") || text.equals(";")) {   // Wenn es ein Schlusselwort : IF, THEN oder END ist

                map.put(counter, text);  // Speicherung der Anweisung
                ++counter;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("ExpIfContext")) {   // Wenn es ein ExpIf ist

                text = space(text);
                map.put(counter, text);   // Speicherung der Anweisung
                ++counter;

                visitExpIf(ctx.expIf());   // ruft von entsprechenden visitMethod
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("WhilesContext")) {    // Wenn es ein CodeLoop ist

                visitWhiles(ctx.whiles());    // ruft von entsprechenden visitMethod
            }
        }
        return null;
    }

    //  rechnet die  Anweisungen  wenn es um eine anweisung geht
    @Override
    public Void visitAssign(GrammatikParser.AssignContext ctx) {

        String var = ctx.var.getText();
        speicherungName(var);

        visitExp(ctx.exp()); // übergibt den Rest der Anweisung zu visit Exp genau wie bei der Grammatik
        return null;
    }

    //  Läuft durch die Kinder und rechnet die  Anweisungen  wenn es um eine Exp geht
    @Override
    public Void visitExp(GrammatikParser.ExpContext ctx) {
        int expCounter = -1;

        for (int i = 0; i <ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroNameAnrufContext")){
                String text = ctx.getChild(i).getText();
                macro_anruf.add(text);
                all_macro_Name_anruf.add(ctx.macroNameAnruf().MacroName().getText());

                visitMacroNameAnruf(ctx.macroNameAnruf());

                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("ExpContext")){  // Wenn es ein Exp ist
                ++expCounter;
                if (! (ctx.exp(expCounter).var == null)){  // Wenn der Exp ein VariableName enthäht
                    String var = ctx.exp(expCounter).var.getText();
                    speicherungName(var);
                }else {
                    visitExp(ctx.exp(expCounter)); // ruft sic selbst wenn der Exp kein VariableNae enthält
                }
            }

            String  text = ctx.getChild(i).getText();
            // Wenn der Exp nur ein Kind hast, das kein Operator ist => es geht um ein VariableName oder VariableWerte wie es in der Grammatik definierrt ist
            if (ctx.getChild(i).getClass().getSimpleName().equals("TerminalNodeImpl")  && ! text.equals("+") && ! text.equals("-") && !text.equals("/") && !text.equals("*")){

                if (! (ctx.var == null)){  // Wenn der Exp ein VariableName enthält
                    String var = ctx.var.getText();
                    speicherungName(var);
                }
            }
        }
        return null;
    }

    // Läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitExpIf(GrammatikParser.ExpIfContext ctx) {

        int expCounter = -1;
        for (int i = 0; i < ctx.getChildCount() ; i++) {
            String name = ctx.getChild(i).getClass().getSimpleName() ;
            if (name.equals("ExpContext")){  // Wenn es ein Exp ist
                ++expCounter;
                visitExp(ctx.exp(expCounter));  // rucht die passende visitMethod
                continue;
            }

            if (name.equals("ExpIfContext")){
                visitExpIf(ctx.expIf());
            }
        }
        return null;
    }

    private String space(String s){
        String spaceString = s;

        spaceString = spaceString.replace("="," == ");
        spaceString = spaceString.replace(": == "," = ");
        spaceString = spaceString.replace("! =="," != ");
        spaceString = spaceString.replace("+"," + ");
        spaceString = spaceString.replace("-"," - ");
        spaceString = spaceString.replace("*"," * ");
        spaceString = spaceString.replace("/"," / ");
        //   spaceString = spaceString.replace(";"," ;");

        return spaceString;
    }

    // abhängig des Names speichert die Methode den Name als parameter oder als Variable
    private void speicherungName(String var){

        String ersteTeil = var.substring(0,1);
        String zweiteTeil = var.substring(1,var.length());

        if (ersteTeil.equals("x")){

            try {
                int nummer = Integer.valueOf(zweiteTeil);
                if (! parameter_names.contains(var)){
                    parameter_names.add(var);   // speichert die erste Variable ein Anweisung Assign
                }
            }catch (Exception e){
                if (! variables_names.contains(var)){
                    variables_names.add(var);   // speichert die erste Variable ein Anweisung Assign
                }
            }
        }else {
            if (! variables_names.contains(var)){
                variables_names.add(var);   // speichert die erste Variable ein Anweisung Assign
            }
        }
    }

    // sortiert alle parameter Name in aufsteigende Ordnung
    private ArrayList<String> optimizedBubbleSort(ArrayList<String> parameter_names) {

        int[] myArray = new int[parameter_names.size()];
        for (int i = 0; i <parameter_names.size() ; i++) {

            String var = parameter_names.get(i);
            int ende = var.length();
            int zweiteTeil = Integer.valueOf(var.substring(1,ende));
            myArray[i] = zweiteTeil;
        }

        int temp;
        boolean swapped;
        for (int i = 0; i < myArray.length - 1; i++) {

            swapped = false;
            for (int j = 0; j < myArray.length - i - 1; j++) {

                if (myArray[j] > myArray[j + 1]) {
                    //  swap arr[j] and arr[j+1]
                    temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    swapped = true;

                }
            }
            //  If there weren't elements to swap in inner loop, then break
            if (! swapped) {
                break;
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < myArray.length ; i++) {
            String paramNames = "x"+myArray[i];
            list.add(paramNames);
        }

        return list;
    }


    // getter
    protected Map<Integer, String> getMap() {
        return map;
    }

    protected ArrayList<String> getParameter_names() {

        parameter_names = optimizedBubbleSort(parameter_names);
        return parameter_names;
    }

    protected ArrayList<String> getVariables_names() {
        return variables_names;
    }

    protected ArrayList<String> getMacro_anruf() {
        return macro_anruf;
    }

    protected ArrayList<String> getAll_macro_Name_anruf() { return all_macro_Name_anruf; }

    protected ArrayList<Integer> getMacro_anzahl_param_name_() {
        return macro_anzahl_param_name_;
    }

    protected ArrayList<String> getMacro_param_name() {
        return macro_param_name;
    }
}
