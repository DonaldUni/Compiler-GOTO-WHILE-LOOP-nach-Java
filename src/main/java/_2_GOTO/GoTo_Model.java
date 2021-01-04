package main.java._2_GOTO;

import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import main.java._0_ParserGrammatik.GrammatikParser;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Map;

public class GoTo_Model extends GrammatikBaseVisitor<Void> {

    public GoTo_Model(ParseTree tree) {
        visit(tree);
    }

    private Map<Integer, String> map = new OrderedHashMap<>();          // hier werden alle komponente  des Programes einzelne gespeichert
    private Map<Integer, String> code = new OrderedHashMap<>();         // hier werden alle Zeilen des Programes gespeichert
    private Map<Integer, String> marke = new OrderedHashMap<>();        // hier werden alle im programm erhaltenen marke gespeichert
    private Map<Integer, String> sprungMarke = new OrderedHashMap<>();  // hier werden alle sprungsmarke (marke in GOTO anweisungen) des Programes gespeichert
    private ArrayList<String> parameter_names = new ArrayList<>();      // hier werden nur die Name von parameter gespeichert
    private ArrayList<String> variables_names = new ArrayList<>();      // hier werden nur die Name von variable gespeichert
    private int counterMap = 0;   // Schlussel für den code
    private int counterCode = 0;   // Schlussel für den code
    private int counterMarke = 0;   // Schlussel für den marke
    private int counteSprungMarke = 0;   // Schlussel für den marke

    // die Strukturen, die sich um Macro kummern
    private ArrayList<String> macro_anruf = new ArrayList<>();
    private ArrayList<String> all_macro_Name_anruf = new ArrayList<>();
    private ArrayList<Integer> macro_anzahl_param_name_ = new ArrayList<>();
    private ArrayList<String> macro_param_name = new ArrayList<>();
    private ArrayList<String> macro_deklarierte_param_name = new ArrayList<>();

    private int macro_param_counter = 0;
    private int macro_deklarierte_param_count = 0;
    private int macro_counter = -1;

    protected boolean halt_program = false;
    private  boolean tmp = true;


    /* Der code unten verhält sich genau wie die grammatik bzw "spezialisierte Rules für GOTO Programm, d.h. wenn eine Method eines Elements trifft einen anderen Element,
     sie bearbeitet es und ruft seine entprechende Method.
     Um besser zu verstehen ist die Grammatik Defintion "Grammatikg4.txt" eine große Hilfe
      */

    // Methode für gotos rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitProgram(GrammatikParser.ProgramContext ctx) {  // kummert ich um die Bearbeitung von Program Rule und ruft visitLoops

        if (ctx.gotos() != null){
            visitGotos(ctx.gotos());
            tmp = false;

        }else {
            visitGotoEnde(ctx.gotoEnde());
        }
        return null ;
    }

    // Läuft durch alle Kinder  von Gotos rules und rechnet die passende Anweisungen
    @Override
    public Void visitGotos(GrammatikParser.GotosContext ctx) {

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoProgramContext")){
                visitGotoProgram(ctx.gotoProgram());   //ruft von entsprechenden visitMethod
                tmp = false;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoEndeContext")){
                String text = ctx.gotoEnde().getText() ;
                map.put(counterMap, text);          // Speicherung der Anweisung
                code.put(counterCode, text + ";");  // Speicherung der Anweisung

                visitGotoEnde(ctx.gotoEnde());  //ruft von entsprechenden visitMethod
            }
        }

        return null;
    }

    // Methode für gotoprogram rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitGotoProgram(GrammatikParser.GotoProgramContext ctx) {

        int gotoProgramCounter = 0 ;

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoCodeContext")){      // Wenn es ein gotocode ist

                String text = space(ctx.getChild(i).getText()) + ";";
                code.put(counterCode, text);    // Speicherung der Anweisung
                ++ counterCode;
                visitGotoCode(ctx.gotoCode());  //ruft von entsprechenden visitMethod

                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoProgramContext")){    // Wenn es ein gotoprogram ist
                visitGotoProgram(ctx.gotoProgram(gotoProgramCounter));  //ruft von entsprechenden visitMethod
                ++ gotoProgramCounter ;
            }
        }
        return null;
    }

    // Methode für gotocode rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitGotoCode(GrammatikParser.GotoCodeContext ctx) {

        for (int i = 0; i < ctx.getChildCount(); i++) {

            if (ctx.getChild(i).getClass().getSimpleName().equals("MarkenContext")) {       // Wenn es ein marken ist

                visitMarken(ctx.marken());   //ruft von entsprechenden visitMethod
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoInstructionsContext")){ // Wenn es ein gotosinstruction ist

                visitGotoInstructions( ctx.gotoInstructions());   //ruft von entsprechenden visitMethod
            }
        }

        return null;
    }

    // Methode für marken rules
    @Override
    public Void visitMarken(GrammatikParser.MarkenContext ctx) {

            String markeName = ctx.mark.getText();
            marke.put(counterMarke, markeName );    // Speicherung der marke
            map.put(counterMap, markeName);         // Speicherung der Anweisung

            ++ counterMarke ;
            ++ counterMap ;
        return null;
    }

    // Methode für gotoinstructions rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitGotoInstructions(GrammatikParser.GotoInstructionsContext ctx) {

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            if(ctx.getChild(i).getClass().getSimpleName().equals("AssignContext")){     // Wenn es ein assign ist
                String text = space(ctx.getChild(i).getText()) + ";";

                map.put(counterMap, text);
                visitAssign(ctx.assign());
                ++ counterMap ;

                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("MacroNameAnrufContext")){
                String text = ctx.getChild(i).getText();
                map.put(counterMap,text + ";");   // Speicherung des Wortes
                ++ counterMap ;
                // ici ecrire quelques chose

                ++ macro_counter;
                visitMacroNameAnruf(ctx.macroNameAnruf());
                ///
                macro_anruf.add(text);
                all_macro_Name_anruf.add(ctx.macroNameAnruf().MacroName().getText());

                continue;
            }

            if(ctx.getChild(i).getClass().getSimpleName().equals("GotoAssignContext")){  // Wenn es ein gotoassign ist
                visitGotoAssign(ctx.gotoAssign());
                continue;
            }

            if(ctx.getChild(i).getClass().getSimpleName().equals("IfGotoContext")){      // Wenn es ein ifgoto ist
                visitIfGoto(ctx.ifGoto());
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

    // Methode für assign rules
    @Override
    public Void visitAssign(GrammatikParser.AssignContext ctx) {
        String var = ctx.var.getText();
        speicherungName(var);   // speichert die Variable duurch diese Methode

        visitExp(ctx.exp()); // übergibt den Rest der Anweisung zu visit Exp genau wie bei der Grammatik
        return null;
    }

    // Methode für gotoassign rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitGotoAssign(GrammatikParser.GotoAssignContext ctx) {

        String text = ctx.getText();
        map.put(counterMap, text);  // Speicherung der Anweisung
        ++ counterMap;

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            text = ctx.getChild(i).getText();

            if(text.contains("M")){
                sprungMarke.put(counteSprungMarke, text); // Speicherung der Anweisung in sprung Map
                ++ counteSprungMarke ;
            }

        }
        return null;
    }

    // Methode für ifGoto rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitIfGoto(GrammatikParser.IfGotoContext ctx) {

        for (int i = 0 ; i < ctx.getChildCount(); i++) {

            String text = ctx.getChild(i).getText();

            if (text.equals("IF") || text.equals("THEN") ) {   // Wenn es ein Schlusselwort : IF, THEN oder END ist

                map.put(counterMap, text);  // Speicherung der Anweisung
                ++counterMap;
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("ExpIfContext")) {   // Wenn es ein ExpIf ist

                text = space(text);
                map.put(counterMap, text);   // Speicherung der Anweisung
                ++counterMap;

                visitExpIf(ctx.expIf());   // ruft von entsprechenden visitMethod
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoAssignContext")) {    // Wenn es ein gotoassign ist

                visitGotoAssign(ctx.gotoAssign());    // ruft von entsprechenden visitMethod
            }

        }
        return null ;
    }

    // Methode für gotoEnde rules, läuft durch alle Kinder und rechnet die passende Anweisungen
    @Override
    public Void visitGotoEnde(GrammatikParser.GotoEndeContext ctx) {

        for (int i = 0; i < ctx.getChildCount() ; i++) {

            String text = ctx.getChild(i).getText();

            if (ctx.getChild(i).getClass().getSimpleName().equals("MarkenContext")) {       // Wenn es ein Marken ist

                visitMarken(ctx.marken());      // ruft von entsprechenden visitMethod
                continue;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("TerminalNodeImpl")){     // Wenn es ein TerminalNode ist

                map.put(counterMap, text);      // Speicherung der Anweisung
                ++counterMap;
            }

            if (ctx.getChild(i).getClass().getSimpleName().equals("GotoAssignContext")){    // Wenn es ein gotoassin ist

                visitGotoAssign(ctx.gotoAssign());  // ruft von entsprechenden visitMethod
            }

        }

        if (tmp){
            halt_program = true ;
        }

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

                if (! (ctx.var == null)){  // Wenn der Exp ein VariableName enthäht
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

            if (name.equals("ExpIfContext")){       // Wenn es ein Expif ist
                visitExpIf(ctx.expIf());        // rucht die passende visitMethod
            }

        }
        return null;
    }

    // die Methode space umwandelt die schreibweise von Goto Programm in der von JavaCode in bezug auf operatoren
    private String space(String s){

        String spaceString = s;

        spaceString = spaceString.replace("="," == ");
        spaceString = spaceString.replace(": == "," = ");
        spaceString = spaceString.replace("! =="," != ");
        spaceString = spaceString.replace("+"," + ");
        spaceString = spaceString.replace("-"," - ");
        spaceString = spaceString.replace("*"," * ");
        spaceString = spaceString.replace("/"," / ");

        return spaceString;
    }

    // die methode speicherungNameprüft ob es geht um ein parameter oder ein e Variable und speichert die im richtigen Map
    private void speicherungName(String var){

        String ersteTeil = var.substring(0,1);
        String zweiteTeil = var.substring(1,var.length());

        if (ersteTeil.equals("x")){

            try {
                int nummer = Integer.valueOf(zweiteTeil);  // wenn die zweiteTeil ein nummer ist die variable var ist ein parameter
                if (! parameter_names.contains(var)){
                    parameter_names.add(var);   // speichert die erste Variable ein Anweisung Assign hier als parameter
                }

            }catch (Exception e){
                if (! variables_names.contains(var)){
                    variables_names.add(var);   // speichert die erste Variable ein Anweisung Assign hier als einfache variable
                }

            }
        }else {
            if (! variables_names.contains(var)){
                variables_names.add(var);   // speichert die erste Variable ein Anweisung Assign hier als einfache variable
            }

        }
    }

    // die methode optimizedBubbleSort sortiert die Eingabelist (parameter_names) durch eine Bubblesort damit die parameters in ordnung angezeigt werden
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




    // getters
    public Map<Integer, String> getMap() {
        return map;
    }

    public ArrayList<String> getParameter_names() {
        parameter_names = optimizedBubbleSort(parameter_names);
        return parameter_names;
    }

    public ArrayList<String> getVariables_names() {
        return variables_names;
    }

    public Map<Integer, String> getCode() {
        return code;
    }

    public Map<Integer, String> getMarke() {
        return marke;
    }

    public Map<Integer, String> getSprungMarke() {
        return sprungMarke;
    }

    public ArrayList<String> getMacro_anruf() {
        return macro_anruf;
    }

    public ArrayList<String> getAll_macro_Name_anruf() {
        return all_macro_Name_anruf;
    }

    public ArrayList<Integer> getMacro_anzahl_param_name_() {
        return macro_anzahl_param_name_;
    }

    public ArrayList<String> getMacro_param_name() {
        return macro_param_name;
    }
}
