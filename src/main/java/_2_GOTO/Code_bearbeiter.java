package main.java._2_GOTO;

import main.java.Helper.Helper_verifier;
import org.antlr.v4.misc.OrderedHashMap;

import java.util.ArrayList;
import java.util.Map;

public class Code_bearbeiter {

    private Map<Integer, String> code = new OrderedHashMap<>();         // hier werden alle Zeilen des Programes gespeichert
    private String[][] valueOfMarke ;                                   // hier werden nummer von sprungmarken gespeichert
    private ArrayList<String> parameters_names = new ArrayList<>();     // hier werden nur die Namen von parameter gespeichert
    private ArrayList<Integer> parameters_werte = new ArrayList<>();    // hier werden nur die werte von parameter gespeichert
    private ArrayList<String> variables_names = new ArrayList<>();      // hier werden nur die Name von variablen gespeichert
    private ArrayList<String> variables_werte = new ArrayList<>();      // hier werden die passenden Werte von Variables gelargert
    protected ArrayList<String> macro_anruf = new ArrayList<>();        // lager für alle macro anruf mit ihre parameter , Bsp : Test(x,x1)
    protected ArrayList<String> all_macro_Name_anruf = new ArrayList<>();
    protected ArrayList<Integer> macro_anzahl_param_name = new ArrayList<>();  // lager für die Anzahl von parameter
    protected ArrayList<String> macro_param_name = new ArrayList<>();           // speichert  die variablen die als parameter für den Anruf genutzt sind
    protected ArrayList<String> deklarierte_macro_param_name = new ArrayList<>();
    protected boolean macro_exist = false;

    private String javaCode = "";
    private String counterName ;
    private  int counterTab = 2;  //zählt die Anzahl von  Tabulation, die zu nutzen sind
    private int  counter = 1 ;

    protected boolean javaCode_fur_macro = false;
    protected boolean  isGultig = false;
    protected boolean code_print = true;
    protected boolean is_haupt_goto = true;
    protected int pos_Macro = 0;
    protected int positiom_start = 0;
    protected boolean halt_program = false;


    protected Code_bearbeiter(GoTo_Controller controller) {

        code = controller.code;
        valueOfMarke = controller.valueOfMarke;
        parameters_names = controller.parameters_names;
        parameters_werte = controller.parameters_werte;
        variables_names = controller.variables_names;
        variables_werte = controller.variables_werte;
        macro_anruf.addAll(controller.macro_anruf);
        all_macro_Name_anruf.addAll(controller.all_macro_Name_anruf);
        macro_param_name.addAll(controller.macro_param_name);
        macro_anzahl_param_name.addAll(controller.macro_anzahl_param_name);
        deklarierte_macro_param_name.addAll(controller.deklarierte_macro_param_name);
        halt_program = controller.halt_program;

    }

    protected String to_Java_Code(GoTo_Controller controller){

         javaCode_fur_macro = controller.javaCode_fur_macro;
         code_print = controller.code_print;
         is_haupt_goto = controller.is_haupt_goto;
         pos_Macro = controller.pos_Macro;
         positiom_start = controller.positiom_start;

        macro_name_anruf_toLowerCase(); // alle Namen von macros werden in lowercase, richtige schreibweise von java umgewandelt


        if (!javaCode_fur_macro){     // wenn es geht um den Haupt-Loop

            javaCode = "public class GoToKlasse {" + "\n" + "\n" + "\t" + "public static void main (String[] args) {" + "\n" + "\n"+ "\t" + "\t" + "int x0 = 0 ;" + "\n";

            // Initialisierung von allen Parameters
            for (int i = 0; i < parameters_names.size(); i++) {

                tabulationMaker();
                javaCode = javaCode + "int " + parameters_names.get(i) + " = " + parameters_werte.get(i) + " ;" + "\n" ;
            }

            javaCode = javaCode + "\n";

            // Initialisierung von allen Variable
            for (int i = 0; i < variables_names.size(); i++) {

                tabulationMaker();
                javaCode = javaCode + "int " + variables_names.get(i) + " = " + variables_werte.get(i) + " ;" + "\n";
            }
        }else {  // wenn es geht um ein Macro

            tabulationMaker();              // Tabulation einfügen um die Strukture des Codes zu verschönen
            javaCode = javaCode + "int x0 = 0;" + "\n";

            Helper_verifier prufer = new Helper_verifier();

            int zahler = 0;
            for (int i = 0; i < parameters_names.size() ; i++) {

                if (! prufer.exist(deklarierte_macro_param_name, parameters_names.get(i), positiom_start, pos_Macro)){
                    tabulationMaker();              // Tabulation einfügen um die Strukture des Codes zu verschönen
                    javaCode = javaCode + "int " + parameters_names.get(i) + " = " + parameters_werte.get(zahler) + " ;" +"\n";
                    ++ zahler;
                }
            }

            // Initialisierung von alle Variable
            for (int i = 0; i < variables_names.size() ; i++) {

                if (! prufer.exist(deklarierte_macro_param_name, variables_names.get(i), positiom_start,pos_Macro)){

                    tabulationMaker();              // Tabulation einfügen um die Strukture des Codes zu verschönen
                    javaCode = javaCode + "int " + variables_names.get(i) + " = " + variables_werte.get(i) + " ;" + "\n";
                }
            }
        }

        if (!halt_program){ // wenn es geht nicht um ein goto programmit der einzigen Anweisung HALT

            counterName = setCounterName("counter");  //Erstellung des Names des Counter für die while Schleife

            tabulationMaker();
            javaCode = javaCode + "\n";

            tabulationMaker();
            javaCode = javaCode  + "int "+ counterName + " = 1 ;" + "\n" ;  // initialisierungs des counter

            //
            tabulationMaker();
            javaCode = javaCode  + "while ( " + counterName + " != 0 ) {" + "\n" ;     // afangs der while-schleife
            ++ counterTab ;

            // Compilierung des Program körper zu JavaCode
            for (int i = 0; i < code.size(); i++) {

                String text = code.get(i);

                if (!text.contains("GOTO") && !text.contains("HALT")){      // falls es um eine einfache anweisung geht. Bsp : x0 = x1 + 2;

                    tabulationMaker();                                      // tabulation hinzufüger
                    communText("ifStart");                          // schreibt den Abfang von If -Instruktion
                    javaCode = javaCode + codeGenerator(text) + "\n";       //generiert den Inhat

                    tabulationMaker();
                    javaCode = javaCode  + counterName + " = " + counterName + " + 1 ;" + "\n";  // Inkrementierung des counter

                    tabulationMaker();
                    javaCode = javaCode + "continue;" + "\n";

                    communText("ifEnde");                           // schießt die If -Instruktion

                    continue;
                }

                if (text.contains("GOTO") && !text.contains("IF")){         // falls es um eine GOTO anweisung geht. Bsp : GOTO M2

                    int indexOfEnd = text.length()-1 ;
                    String marke = text.substring(4, indexOfEnd);            // speichert die Marke, weil die anweisung ist so gespeichert Bsp: "M2: GOTO M4;"wo M4 ist zwischen den index 4 und length-1

                    tabulationMaker();
                    communText("ifStart");                           // schreibt den Abfang von If -Instruktion
                    javaCode = javaCode + "counter = "+ nummerOfMarke(marke)+ ";"  + "\n";  //generiert den Inhat

                    tabulationMaker();
                    javaCode = javaCode + "continue;" + "\n";
                    communText("ifEnde");                            // schießt die If -Instruktion
                    continue;

                }

                if (text.contains("IF")){                                   // falls es um eine IF anweisung geht. Bsp : IF x0 = 2 THEN GOTO M2;

                    int indexEndOfIF = text.lastIndexOf("F")+1;
                    int indexOfTHEN = text.indexOf("THEN");
                    String ifCondition = text.substring(indexEndOfIF, indexOfTHEN); // speichert die Condition
                    int lastindex = text.length();
                    String marke = text.substring(lastindex-3, lastindex-1);            // nimmt die marke

                    tabulationMaker();
                    communText("ifStart");                                      // schreibt den Abfang von If -Instruktion

                    javaCode = javaCode + "if( "+ ifCondition + "){" + "\n";
                    ++counterTab;

                    tabulationMaker();
                    javaCode = javaCode +  counterName + " = " + nummerOfMarke(marke) + ";" + "\n";

                    tabulationMaker();
                    javaCode = javaCode + "continue;" + "\n";
                    --counterTab;

                    tabulationMaker();
                    javaCode = javaCode + "}else{" + "\n";
                    ++counterTab;
                    tabulationMaker();
                    javaCode = javaCode + counterName + " = " + counterName + " + 1;" + "\n";

                    tabulationMaker();
                    javaCode = javaCode + "continue;" + "\n";
                    --counterTab;

                    tabulationMaker();
                    javaCode = javaCode+ "}" +"\n" ;

                    communText("ifEnde");                                            // schießt die If -Instruktion

                    continue;
                }

                if (text.contains("HALT")){                                     // falls es um eine HALT anweisung geht.

                    tabulationMaker();
                    communText("ifStart");
                    javaCode = javaCode +  counterName + " = 0; " + "\n";

                    communText("ifEnde");
                }
            }
        }

        if (!javaCode_fur_macro && !code_print){ // wenn es  macro im Program gibt, zeigen wir nicht den Javacode hier

            if (!halt_program){
                javaCode = javaCode + "\t" + "\t" +"}" +"\n" + "\n";
            }
            javaCode = javaCode + "\t" + "\t" + "System.out.println (x0);";
            javaCode = javaCode + "\n" + "\t" + "}" + "\n" + "}";
        }else {
            if (!javaCode_fur_macro){ // wenn es geht um einen Loop ohne Macro

                if (!halt_program){
                    javaCode = javaCode +"\t" + "\t" + "}" +"\n" + "\n";
                }
                javaCode = javaCode + "\t" + "\t" + "System.out.println (x0);";
                javaCode = javaCode + "\n" + "\t" + "}" + "\n" + "}";    // Ende des JavaCodes

                System.out.println(javaCode);   //Anzeigt des gesampten Programes

            }else { // wenn es geht um ein Macro
                if (!halt_program){
                    javaCode = javaCode + "\t" + "\t" +"}" +"\n" ;
                }
                javaCode = javaCode +"\t" + "\t" + "return x0;" ;
                javaCode = javaCode + "\n" + "\t" + "}" ;    // Ende des JavaCodes

            }
        }

        return javaCode;
    }

    // Abhägig der Eingabe, wird der Anfang oder der Ende des If -Instruktions gespeichert
    private void communText(String keyword){

        if (keyword.equals("ifStart")){

            javaCode = javaCode + "if ( " + counterName + " == " + counter + " ){" + "\n" ;
            ++ counter;
            ++ counterTab;
            tabulationMaker();
        }

        if (keyword.equals("ifEnde")){

            --counterTab ;
            tabulationMaker();
            javaCode = javaCode + "}" + "\n" ;
        }

    }

    // gibt die Nummer des Ziel von einer sprungsmarke zurück
    private int nummerOfMarke(String marke){
        int value = 0 ;

        for (int i = 0; i < valueOfMarke[0].length; i++) {

            if (valueOfMarke[0][i].equals(marke)){

                value = Integer.valueOf(valueOfMarke [1][i]);
                return value;
            }
        }
        return value;
    }


    // schreibe die tabulation in Javacode String
    private void tabulationMaker(){

        for (int j = 0; j < counterTab; j++) {
            javaCode = javaCode + "\t";
        }
    }


    // erstellt ein Name, der nicht in der Variablenmenge existiert, für den counter von while schleife in Javacode
    private int counter_tail = 0;
    private String setCounterName(String name){

        String counter = name;

        if (counterNameTesting(counter)){
            counter = counter + counter_tail;
            ++ counter_tail;
            counter = setCounterName(counter);
        }

        return counter;
    }

    // prüft, b der eingegebenen String in der variablenmenge existiert
    private boolean counterNameTesting(String counter){

        boolean gefunden = false;

        for (String name: variables_names) {
            if (name.equals(counter)){
                gefunden = true;
                break;
            }
        }

        return gefunden;
    }

    // schreibt den inhalt, wen es ein - perator gibt, dann wird ein if Instruktion in den j´Javacode hinzugefügt damit der ergenis keine negative werte enthalt
    private String  codeGenerator(String assign){

        String statement ;

        if (assign.contains("-")){
            int index = assign.indexOf(" =");
            String var = assign.substring(0, index );

            statement = assign + "\n" ;

            for (int j = 0; j < counterTab ; j++) {
                statement = statement + "\t";
            }

            statement = statement  + "if( " + var + " < 0 ){" +"\n" + "\t" ;

            for (int j = 0; j < counterTab ; j++) {
                statement = statement + "\t";
            }

            statement = statement + var + " = 0;" + "\n";

            for (int j = 0; j < counterTab ; j++) {
                statement = statement + "\t";
            }

            statement = statement + "}" ;
        }else {
            statement = assign ;
        }

        return statement;
    }

    private void macro_name_anruf_toLowerCase(){   //  wandelt alle ersten großen Buchstabe von Macro_Name in kleine Buchstabe um.

        for (int i = 0; i < macro_anruf.size(); i++) {
            for (int j = 0; j < code.size(); j++) {

                if ((macro_anruf.get(i) + ";").equals(code.get(j))){

                    String s_with_Uppercase = code.get(j);
                    String method_name = s_with_Uppercase.substring(0,1).toLowerCase() + s_with_Uppercase.substring(1, s_with_Uppercase.length());
                    code.put(j, method_name);
                }

                if ((code.get(j).contains(macro_anruf.get(i)))){

                    String s_with_Uppercase = code.get(j);
                    int index_of_macro_anruf = s_with_Uppercase.indexOf(macro_anruf.get(i));
                    String part1  = s_with_Uppercase.substring(0, index_of_macro_anruf) ;
                    String part2 =  s_with_Uppercase.substring(index_of_macro_anruf,index_of_macro_anruf+1).toLowerCase();
                    String part3 = s_with_Uppercase.substring(index_of_macro_anruf+1
                    );

                    code.put(j, part1 + part2 + part3);
                }
            }
        }

    }
}
