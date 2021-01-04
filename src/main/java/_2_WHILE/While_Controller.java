package main.java._2_WHILE;

import main.java.Helper.Helper_verifier;
import main.java._0_Main.Controller;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Map;

public class While_Controller extends Controller {

    // speichert die Eingaben drch den Model , Compielert die in JavaCode String und zeigt den fertigen JavaCode an

    private Map<Integer, String> map = new OrderedHashMap<>();     // hier sind alle nötigen Elemente des Programes vom Model gespeichert
    private ArrayList<String> parameters_names = new ArrayList<>(); // hier werden nur die Name von variablen  von Model gespeichert
    private ArrayList<Integer> parameters_werte = new ArrayList<>();   // hier werden die passenden Werte von Variables gelargert
    private ArrayList<String> variables_names = new ArrayList<>();
    private ArrayList<String> variables_werte = new ArrayList<>();
    private ArrayList<String> macro_anruf = new ArrayList<>();                      // lager für alle macro anruf mit ihre parameter , Bsp : Test(x,x1)
    private ArrayList<String> all_macro_Name_anruf = new ArrayList<>();
    private ArrayList<Integer> macro_anzahl_param_name = new ArrayList<>();         // lager für die Anzahl von parameter
    private ArrayList<String> macro_param_name = new ArrayList<>();                 // speichert  die variablen die als parameter für den Anruf genutzt sind
    protected ArrayList<String> deklarierte_macro_param_name = new ArrayList<>();
    protected boolean macro_exist = false;

    private  int counterAnzahl = 0;
    private  int counterAnzahl1 = 0;  // der Zähler für Counter fon JavaProgram .  Bsp : for ( int i = 0; i < Counter; i++) {}
    private  int counterTab = 2;  //zählt die Anzahl von  Tabulation, die zu nutzen sind
    private boolean kompilieren = false ;
    private  String[] args ;
    private  String javaCode = "";
    private boolean javaCode_fur_macro = false;
    private boolean  isGultig = false;
    private boolean code_print = true;
    private boolean is_haupt_while = true;
    protected int pos_Macro = 0;
    protected int positiom_start = 0;

    public While_Controller(String[] args) {
        super(args);
        this.args = args ;
    }

    @Override
    public void speicherungElemente(ParseTree tree) {

        // Für LoopModel
        While_Model while_model = new While_Model(tree);  // erzeugt ein Instance von Loop_Model um ihre Daten zu nutzen

        // deep Copy of map von Model , von Parameter, Variables_name  und die andere nötigen Elemente von loopModel
        map.putAll(while_model.getMap());
        parameters_names.addAll(while_model.getParameter_names());
        variables_names.addAll(while_model.getVariables_names());
        macro_anruf.addAll(while_model.getMacro_anruf());
        all_macro_Name_anruf.addAll(while_model.getAll_macro_Name_anruf());
        macro_param_name.addAll(while_model.getMacro_param_name());
        macro_anzahl_param_name.addAll(while_model.getMacro_anzahl_param_name_());

        // eingabeMethod()  fur parameters und variables
        copyValue(args);

        if (is_haupt_while){ // wenn es geht um den HauptLoop , prufman besonders die Prameter in macro anruf
            Helper_verifier prufer = new Helper_verifier();
            kompilieren = kompilieren && prufer.macro_anruf_prufer(parameters_names, variables_names,macro_param_name);
        }

        // pruft ob es ein Macro anruf ohne definierte macrro gibt
        if (is_haupt_while){
            if (!macro_exist){
                if (macro_anruf.size()> 0){
                    kompilieren = false;
                    System.out.println("Kein Macro ist definiert");
                }
            }
        }
    }

    @Override
    public void toJavaCode() {

        macro_name_anruf_toLowerCase(); // alle Namen von macros werden in lowercase, richtige schreibweise von java umgewandelt

        if (!javaCode_fur_macro){  // wenn es geht um de Haupt-Loop

            javaCode = "public class WhileKlasse {" +"\n" +"\n" +"\t" + "public static void main (String[] args) {" +"\n" + "\n" + "\t" + "\t" + "int x0 = 0 ;" + "\n";  // Initialisierung des JavaCode

            // Initialisierung von alle Parameters
            for (int i = 0; i < parameters_names.size() ; i++) {

                javaCode = tabulationMaker(javaCode);              // Tabulation einfügen um die Strukture des Codes zu verschönen
                javaCode = javaCode + "int " + parameters_names.get(i) + " = " + parameters_werte.get(i) + " ;" + "\n";

            }

            javaCode = javaCode + "\n";

            // Initialisierung von alle Variable
            for (int i = 0; i < variables_names.size() ; i++) {

                javaCode = tabulationMaker(javaCode);              // Tabulation einfügen um die Strukture des Codes zu verschönen
                javaCode = javaCode + "int " + variables_names.get(i) + " = " + variables_werte.get(i) + " ;" + "\n";
            }

            javaCode = javaCode + "\n";
        }else {  // wenn es geht um ein Macro

            javaCode = tabulationMaker(javaCode);              // Tabulation einfügen um die Strukture des Codes zu verschönen
            javaCode = javaCode + "int x0 = 0;" + "\n";

            Helper_verifier prufer = new Helper_verifier();

            int zahler = 0;
            for (int i = 0; i < parameters_names.size() ; i++) {

                if (! prufer.exist(deklarierte_macro_param_name, parameters_names.get(i), positiom_start, pos_Macro )){
                    javaCode = tabulationMaker(javaCode);              // Tabulation einfügen um die Strukture des Codes zu verschönen
                    javaCode = javaCode + "int " + parameters_names.get(i) + " = " + parameters_werte.get(zahler) + " ;" +"\n";
                    ++ zahler;
                }
            }

            // Initialisierung von alle Variable
            for (int i = 0; i < variables_names.size() ; i++) {

                if (! prufer.exist(deklarierte_macro_param_name, variables_names.get(i), positiom_start, pos_Macro)){

                    javaCode = tabulationMaker(javaCode);              // Tabulation einfügen um die Strukture des Codes zu verschönen
                    javaCode = javaCode + "int " + variables_names.get(i) + " = " + variables_werte.get(i) + " ;" + "\n";
                }
            }
        }


        // Compieler Program körper ds Program zu JavaCode
        for (int i = 0; i < map.size() ; i++) {

            // Falls es ein While ist
            if (map.get(i).equals("WHILE")){

                javaCode = tabulationMaker(javaCode);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
                javaCode = javaCode + "while ( " + map.get(i+1) + " ){" +"\n" ;

                i+=2 ;
                ++counterTab ;
                continue;
            }

            // Falls es ein If ist
            if (map.get(i).equals("IF")){

                javaCode = tabulationMaker(javaCode);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
                javaCode = javaCode + "if( " +map.get(i+1)+" ){" +"\n" ;
                ++ counterTab;
                i+=2;
                continue;
            }

            // Falls es um ein ENd geht
            if (map.get(i).equals("END")){
                --counterTab ;

                javaCode = tabulationMaker(javaCode);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
                javaCode = javaCode + "}" +"\n";
                continue;
            }

            // Falls es kein Schlussewort ist : LOOP, DO, END, IF,THEN, ;
            if (!(map.get(i).equals("WHILE")||map.get(i).equals("DO")||map.get(i).equals("END")||map.get(i).equals("IF")||map.get(i).equals("THEN") ||map.get(i).equals(";"))){

                javaCode = tabulationMaker(javaCode);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
                javaCode = javaCode  + codeGenerator( map.get(i)) + "\n" ;
            }

        }

        javaCode = tabulationMaker(javaCode);                              // Tabulation einfügen um die Strukture des Codes zu verschönen

        if (!javaCode_fur_macro && !code_print){ // wenn es  macro im Program gibt, zeigen wir nicht den Javacode hier

            javaCode = javaCode + "System.out.println (x0);" ;
            javaCode = javaCode + "\n" + "\t" + "}" + "\n"  + "}" ;    // Ende des JavaCodes
        }else {
            if (!javaCode_fur_macro){ // wenn es geht um  einen Loop ohne Macro

                javaCode = javaCode + "System.out.println (x0);" ;
                javaCode = javaCode + "\n" + "\t" + "}" + "\n"  + "}" ;    // Ende des JavaCodes

                System.out.println(javaCode);   //Anzeigt des gesampten Programes

            }else { // wenn es geht um ein Macro
                javaCode = javaCode + "return x0;" ;
                javaCode = javaCode + "\n" + "\t" + "}" ;    // Ende des JavaCodes

            }
        }
    }

    @Override
    public boolean zuKompilieren() {
        return kompilieren ;
    }

    private void copyValue(String[] args){

        parameters_names.remove("x0");

        kompilieren = true;
        if (args.length < parameters_names.size()){

            int index = args.length ;
            for (int i = 0; i < args.length ; i++) {
                int werte = Integer.valueOf(args[i]);
                parameters_werte.add(werte);
            }

            for (int i = index; i < parameters_names.size() ; i++) {
                parameters_werte.add(0);
            }

        }else {
            if (args.length > parameters_names.size()) {

                for (int i = 0; i < parameters_names.size(); i++) {
                    int werte = Integer.valueOf(args[i]);
                    parameters_werte.add(werte);
                }

            } else {

                for (int i = 0; i < args.length; i++) {
                    int werte = Integer.valueOf(args[i]);
                    parameters_werte.add(werte);
                }
            }
        }

        for (String s: variables_names) {
            variables_werte.add("0");
        }

    }


    private String  codeGenerator(String assign){
        String statement ;

        if (assign.contains("-")){
            int index = assign.indexOf(" =");
            String var = assign.substring(0, index );

            statement = assign + "\n" ;

            statement = tabulationMaker(statement);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
            statement = statement  + "if( " + var + " < 0 ){" +"\n" + "\t" ;

            statement = tabulationMaker(statement);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
            statement = statement + var + " = 0;" + "\n";

            statement = tabulationMaker(statement);                              // Tabulation einfügen um die Strukture des Codes zu verschönen
            statement = statement + "}" ;

        }else {
            statement = assign ;
        }

        return statement;
    }

    // schreibe die tabulation in Javacode String
    private String  tabulationMaker(String javaCode){

        for (int j = 0; j < counterTab; j++) {
            javaCode = javaCode + "\t";
        }

        return javaCode;
    }

    private void macro_name_anruf_toLowerCase(){   //  wandelt alle ersten großen Buchstabe von Macro_Name in kleine Buchstabe um.

        for (int i = 0; i < macro_anruf.size(); i++) {
            for (int j = 0; j < map.size(); j++) {

                if ((macro_anruf.get(i) + ";").equals(map.get(j))){

                    String s_with_Uppercase = map.get(j);
                    String method_name = s_with_Uppercase.substring(0,1).toLowerCase() + s_with_Uppercase.substring(1, s_with_Uppercase.length());
                    map.put(j, method_name);

                }

                if ((map.get(j).contains(macro_anruf.get(i)))){

                    String s_with_Uppercase = map.get(j);

                    int index_of_macro_anruf = s_with_Uppercase.indexOf(macro_anruf.get(i));

                    String part1  = s_with_Uppercase.substring(0, index_of_macro_anruf) ;
                    String part2 =  s_with_Uppercase.substring(index_of_macro_anruf,index_of_macro_anruf+1).toLowerCase();
                    String part3 = s_with_Uppercase.substring(index_of_macro_anruf+1
                    );

                    map.put(j, part1 + part2 + part3);

                }
            }
        }

    }

    // Getter und Setter
    protected String getJavaCode() { return javaCode; }

    protected ArrayList<String> getParameters_names() { return parameters_names; }

    protected ArrayList<String> getVariables_names() { return variables_names; }

    protected void setJavaCode_fur_macro(boolean javaCode_fur_macro) { this.javaCode_fur_macro = javaCode_fur_macro; }

    protected ArrayList<String> getMacro_anruf() { return macro_anruf; }

    protected ArrayList<String> getAll_macro_Name_anruf() { return all_macro_Name_anruf; }

    protected ArrayList<Integer> getMacro_anzahl_param_name() { return macro_anzahl_param_name; }

    protected ArrayList<String> getMacro_param_name() { return macro_param_name; }

    protected boolean isGultig() { return isGultig; }

    protected void setDeklarierte_macro_param_name(ArrayList<String> deklarierte_macro_param_name) { this.deklarierte_macro_param_name = deklarierte_macro_param_name; }

    protected void setCode_print(boolean code_print) { this.code_print = code_print; }

    protected void setIs_haupt_while(boolean is_haupt_while) {
        this.is_haupt_while = is_haupt_while;
    }

}
