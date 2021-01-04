package main.java._2_GOTO;

import main.java.Helper.Helper_verifier;
import main.java._0_Main.Controller;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Map;

public class GoTo_Controller extends Controller {

    private Map<Integer, String> map = new OrderedHashMap<>();          // hier werden alle nötigen Elemente des Programes speichert
    protected Map<Integer, String> code = new OrderedHashMap<>();         // hier werden alle Zeilen des Programes gespeichert
    private Map<Integer, String> marke = new OrderedHashMap<>();        // hier werden alle im programm erhaltenen marke gespeichert
    protected String[][] valueOfMarke ;                                   // hier werden nummer von sprungmarken gespeichert
    private Map<Integer, String> sprungMarke = new OrderedHashMap<>();  // hier werden alle sprungsmarke (marke in GOTO anweisungen) des Programes gespeichert
    protected ArrayList<String> parameters_names = new ArrayList<>();     // hier werden nur die Name von parameter gespeichert
    protected ArrayList<Integer> parameters_werte = new ArrayList<>();    // hier werden nur die werte von parameter gespeichert
    protected ArrayList<String> variables_names = new ArrayList<>();      // hier werden nur die Name von Variable gespeichert
    protected ArrayList<String> variables_werte = new ArrayList<>();      // hier werden die passenden Werte von Variables gelargert

    protected ArrayList<String> macro_anruf = new ArrayList<>();            // lager für alle macro anruf mit ihre parameter , Bsp : Test(x,x1)
    protected ArrayList<String> all_macro_Name_anruf = new ArrayList<>();
    protected ArrayList<Integer> macro_anzahl_param_name = new ArrayList<>();   // lager für die Anzahl von parameter
    protected ArrayList<String> macro_param_name = new ArrayList<>();           // speichert  die variablen die als parameter für den Anruf genutzt sind
    protected ArrayList<String> deklarierte_macro_param_name = new ArrayList<>();
    protected boolean macro_exist = false;

    private  int counterTab = 2;            // zählt die Anzahl von  Tabulation, die zu nutzen sind
    private boolean kompilieren = true ;    // variable, die speichert ob der Program kompilierbar ist oder nicht
    private  String[] args ;                // arguments von Nutzer in Tabelle
    private String javaCode = "";
    protected boolean javaCode_fur_macro = false;
    protected boolean  isGultig = false;
    protected boolean code_print = true;
    protected boolean is_haupt_goto = true;
    protected int pos_Macro = 0;
    protected int positiom_start = 0;
    protected boolean halt_program = false;


    public GoTo_Controller(String[] args) {
        super(args);
        this.args = args;
    }


    @Override
    public void speicherungElemente(ParseTree tree) {

        // Für GOTO Model
        GoTo_Model goTo_model = new GoTo_Model(tree);  // erzeugt ein Instance von Loop_Model um ihre Daten zu nutzen

        // deep Copy of map von Model
        map.putAll(goTo_model.getMap());

        // deep Copy von marke, sprungsmarke, Parameter_name von loopModel
        marke.putAll(goTo_model.getMarke());
        valueOfMarke =  new String[2][marke.size()];
        sprungMarke.putAll(goTo_model.getSprungMarke());
        parameters_names.addAll(goTo_model.getParameter_names());
        macro_anruf.addAll(goTo_model.getMacro_anruf());
        all_macro_Name_anruf.addAll(goTo_model.getAll_macro_Name_anruf());
        macro_param_name.addAll(goTo_model.getMacro_param_name());
        macro_anzahl_param_name.addAll(goTo_model.getMacro_anzahl_param_name_());

        if (! halt_program){ // wenn die Werte von halt_program noch nicht bestimmt ist
            halt_program = goTo_model.halt_program;
        }

        boolean erlaubnis = markeNamePrufen() && sprungsprufen() ;

        if (erlaubnis){         // wenn der eingegebenen Code gultig ist

            // deep copy con code et variables_names
            code.putAll(goTo_model.getCode());
            variables_names.addAll(goTo_model.getVariables_names());

            extractionValueOfMarke();       // speichert die markennummer und ihre entsprechende nummer (counter) in den kommenden Javacode
        }

        copyValue(args);                // nimmt die vom Nutzer eingegebenen arguments
        kompilieren = kompilieren && erlaubnis ;

        if (is_haupt_goto){ // wenn es geht um den HauptLoop , prufman besonders die Prameter in macro anruf
            Helper_verifier prufer = new Helper_verifier();
            kompilieren = kompilieren && prufer.macro_anruf_prufer(parameters_names, variables_names,macro_param_name);

        }

        // pruft ob es ein Macro anruf ohne definierte macrro gibt
        if (is_haupt_goto){
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
        // bildet der entsprechenden Javacode durch eine Instance von Code_bearbeiter

       Code_bearbeiter code_bearbeiter = new Code_bearbeiter(this);
       javaCode = code_bearbeiter.to_Java_Code(this);

    }

    // getter von kompilieren
    @Override
    public boolean zuKompilieren() {
        return kompilieren;
    }

    // Prüft, ob die marke sind korrect geschrieben
    private boolean markeNamePrufen(){

        Map<Integer, Integer> markeNummer = new OrderedHashMap<>();

        for (int i = 0; i < marke.size() ; i++) {
            markeNummer.put(i, Integer.valueOf(marke.get(i).substring(1,2)));
        }

        if (markeNummer.size() != 0 && markeNummer.get(0) != 1){
            kompilieren = false ;
            System.out.println("Die Marken Mx sind unlogisch geschrieben! Die erste Sprungsmarke muss 1 sein. Bitte schreiben Sie die logisch." +"\n"+
                    "Beispiel :  " + "\n" +
                    "M1 : ... ; " + "\n" +
                    "Mx : ...  "+"\n");
        }


        for (int i = 0; i < markeNummer.size() -1 ; i++) {
            if (markeNummer.get(i+1)!= markeNummer.get(i) +1){
                kompilieren = false ;
                System.out.println("Die Marken Mx sind unlogisch geschrieben! Bitte schreiben Sie die logisch." +"\n"+
                        "Beispiel :  " + "\n" +
                        "Mn : ... ; " + "\n" +
                        "Mm : ...  "+"\n" +
                        "so, dass m = n + 1.");
                break;
            }

            if (markeNummer.get(i)> markeNummer.get(i+1)){
                kompilieren = false ;
                System.out.println("Die Marken Mx sind unordenlich geschrieben! Bitte schreiben Sie die ordentlich." +"\n"+
                        "Beispiel :  " + "\n" +
                        "Mn : ... ; " + "\n" +
                        "Mm : ...  "+"\n" +
                        "so, dass m = n + 1.");
                break;
            }
        }

        return kompilieren;
    }

    // prüft, on die sprungsmarke stimmen (existieren)
    private boolean sprungsprufen(){

        boolean marke_gefunden = false;
        String markeName = "";

        if (sprungMarke.size() == 0){
            marke_gefunden = true;
        }else {
            for (int i = 0; i < sprungMarke.size(); i++) {
                markeName = sprungMarke.get(i) ;
                for (int j = 0; j < marke.size(); j++) {

                    if (markeName.equals(marke.get(j))){
                        marke_gefunden = true;
                        break;
                    }else {
                        marke_gefunden = false;
                    }

                    if (j == marke.size()-1 ){

                        System.out.println("Die Marken " + markeName + " existiert nicht." +"\n"+
                                "Bitte korrigieren Sie es, indem Sie eine gültige sprungsmarke schreiben.");
                        return  marke_gefunden ;
                    }

                }

            }
        }
        return marke_gefunden ;
    }

    // kopiert die vom Nutzer eingegeben argements
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

    // speichert die markennummer und ihre entsprechende nummer (counter) in den kommenden Javacode
    private void extractionValueOfMarke(){

        int counter = 0 ;
        for (int i = 0; i < code.size() ; i++) {

            String text = code.get(i);

            if (text.contains("M")){

                String teil1 = text.substring(0,2);
                String teil2 = text.substring(2,3);

                if (marke.containsValue(teil1) && teil2.equals(":")){

                    int index = text.length() ;
                    String teil3 = text.substring(3, index);

                    code.put(i,teil3 );
                    valueOfMarke[0][counter] = teil1;
                    valueOfMarke[1][counter] = "" + (i+1);

                    ++counter;
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

    protected void setIs_haupt_goto(boolean is_haupt_loop) {
        this.is_haupt_goto = is_haupt_loop;
    }


}
