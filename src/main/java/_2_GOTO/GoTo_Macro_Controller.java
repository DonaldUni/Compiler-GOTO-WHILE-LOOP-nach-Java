package main.java._2_GOTO;

import main.java.Helper.Helper_verifier;
import main.java._0_Main.Controller;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class GoTo_Macro_Controller extends Controller {

    private OrderedHashMap<Integer, String> allKomponente = new OrderedHashMap<>();
    private ArrayList<Integer> macroslist = new ArrayList<>();              // enthält die macro
    private ArrayList<ParseTree> gotoslist = new ArrayList<>();             // enthält alle gotos context von Macro in program
    private ArrayList<Boolean> halt_program = new ArrayList<>();

    private ArrayList<Integer> parameters_Anzahl = new ArrayList<>();       // Anzahl von Parameter für jeden definierten Macro
    private ArrayList<Integer> variables_Anzahl = new ArrayList<>();
    private ArrayList<String> parameters_names = new ArrayList<>();         // enthält alle parameter die in macro definition genuzt geworden sind
    private ArrayList<String> macro_anruf = new ArrayList<>();
    private ArrayList<String> all_macro_name = new ArrayList<>();
    private ArrayList<String> all_macro_Name_anruf = new ArrayList<>();


    private ArrayList<String> variables_names = new ArrayList<>();
    private ParseTree gotosContext  ;           // ist der Context für den haupt goto des programm
    private boolean hat_fehler = false;

    private boolean kompilieren = false;
    private String pseudo_javaCode  = "";
    private int allKomponentercounter = 0 ;

    private String[] args ;

    public GoTo_Macro_Controller(String[] args) {
        super(args);
        this.args = args;
    }

    @Override
    public void speicherungElemente(ParseTree tree) {     // holt und speichert die Eingaben

        GoTo_Macro_Model  model = new GoTo_Macro_Model(tree);
        initialisierungVariables(model);

        if (! hat_fehler){
            System.out.println("Es gibt ein unerlaubnis String zwischen zwei Macros.");
        }
        kompilieren = hat_fehler;

    }

    @Override
    public void toJavaCode() {

        hat_fehler = false;
        boolean unique = is_unique_macro(all_macro_name) && is_unique_parameters_name(parameters_names);
        if (unique) { // wenn der Name jedes macos ist einzigartig
            int positiom_start = 0;
            for (int i = 0; i < gotoslist.size() ; i++) {       // für alle loop programm, der zu einem Macro gehört , erzeugen wir den Java Code

                GoTo_Controller controller = new GoTo_Controller(args);
                controller.is_haupt_goto = false;
                controller.halt_program = halt_program.get(i);
                controller.speicherungElemente(gotoslist.get(i));
                controller.deklarierte_macro_param_name = parameters_names;
                controller.positiom_start = positiom_start;
                controller.pos_Macro = parameters_Anzahl.get(i);
                Helper_verifier prufer = new Helper_verifier();

                boolean isGultig = prufer.parameter_macro_prufen(controller.getParameters_names(), controller.getVariables_names(), parameters_names, controller.getMacro_param_name(), positiom_start, parameters_Anzahl.get(i));
                positiom_start += parameters_Anzahl.get(i);

                if(isGultig){       // wenn alle aufgerufenen Parameter gulig sind

                    all_macro_Name_anruf = controller.getAll_macro_Name_anruf();

                    boolean pruf = prufer.macro_anruf_prufer(all_macro_name,parameters_Anzahl,controller.getAll_macro_Name_anruf(), controller.getMacro_anzahl_param_name());

                    if (pruf ){   // wenn alle macro anruf gultig sind
                        if (controller.zuKompilieren()){

                            controller.setJavaCode_fur_macro(true);
                            controller.toJavaCode();               // compieliert die gespeicherten Eingaben in JavaCode String
                            String inkomplett_Code = controller.getJavaCode();

                            inkomplett_Code = tojavaCode_macro() + "\n" + inkomplett_Code;

                            pseudo_javaCode = pseudo_javaCode + "\n" + inkomplett_Code + "\n" ;

                        }else {
                            kompilieren = false;
                            hat_fehler = true;
                            break;
                        }
                    }else {
                        hat_fehler = true;
                        break;
                    }
                }else {
                    hat_fehler = true;
                    break;
                }
            }
        }

        // hier geht esum den haupt loop des program, erzeugen wir seín javacode und erganzen wir ihn mit den javacode für alle Macros
        if (unique){
            if (! hat_fehler){

                GoTo_Controller controller = new GoTo_Controller(args);
                controller.macro_exist = true;
                controller.speicherungElemente(gotosContext);

                Helper_verifier prufer = new Helper_verifier();

                boolean macro_anruf_gultig = prufer.macro_anruf_prufer(all_macro_name,parameters_Anzahl, takeName_anruf(controller.getMacro_anruf()), controller.getMacro_anzahl_param_name());

                if (macro_anruf_gultig && controller.zuKompilieren()){

                    controller.setCode_print(false);
                    controller.toJavaCode();
                    String javaCode = controller.getJavaCode();

                    javaCode = javaCode.substring(0, javaCode.length()-1) ;
                    javaCode = javaCode + pseudo_javaCode + "}";

                    System.out.println(javaCode);    // Anzeigt des gesampten JavaCode

                }

            }
        }

    }

    private String tojavaCode_macro (){    // erzeugung des Javacode für ein Macro
        String tmp_code = "";
        String param_def = "";
        boolean tobreak = false;


        for (int i = allKomponentercounter; i < allKomponente.size() ; i++) {

            String text = allKomponente.get(i);

            if (text.equals("MACRO")){      // wenn es geht um ein MACRO Schlussel
                String macro_name_with_Uppercase = allKomponente.get(i+1);
                String method_name = macro_name_with_Uppercase.substring(0,1).toLowerCase() + macro_name_with_Uppercase.substring(1, macro_name_with_Uppercase.length());

                tmp_code = "\t" +  "public static int " + method_name ;
                i = i+1 ;
                continue;
            }

            if (text.equals("(")){     // wenn es geht um ein (
                param_def = "(";

                for (int j = i+1; j < allKomponente.size() ; j++) {

                    if (!allKomponente.get(j).equals(",") && !allKomponente.get(j).equals(")")){

                        param_def = param_def + "int " + allKomponente.get(j);
                        continue;
                    }

                    if (allKomponente.get(j).equals(",")){
                        param_def = param_def + allKomponente.get(j) + " ";
                        continue;
                    }

                    if (allKomponente.get(j).equals(")")){

                        param_def = param_def + allKomponente.get(j) + "{" +"\n";
                        allKomponentercounter = j + 3 ;  // um die in dem allkomponenten Zeichen = und MACROEND zu überspringen
                        tobreak = true;
                        break;
                    }
                }
            }

            if (tobreak){
                tmp_code  = tmp_code + param_def ;
                break;
            }
        }

        return tmp_code;
    }

    @Override
    public boolean zuKompilieren() {
        return kompilieren;
    }

    private void initialisierungVariables(GoTo_Macro_Model model){      //initialisierung von allen wichtigen Komponenten

        allKomponente.putAll(model.getAllKomponente());
        macroslist.addAll(model.getMacroslist());
        gotoslist = model.getGotoslist();
        halt_program = model.getHalt_program();
        parameters_Anzahl.addAll(model.getParameters_Anzahl());
        parameters_names.addAll(model.getParameters_names());
        gotosContext = model.getGotosContext();
        all_macro_name = model.getAll_macro_names();

        hat_fehler = model.isFehler();

    }

    public boolean is_unique_macro(ArrayList<String> all_macro_name){    // pruft ob jeder MAcro_name eindeutig ist

        boolean unique = true;

        for (int i = 0; i < all_macro_name.size() ; i++) {
            for (int j = i+1; j < all_macro_name.size() ; j++) {

                if (all_macro_name.get(i).equals(all_macro_name.get(j))){
                    unique = false;
                    System.out.println("Der macro " + all_macro_name.get(i) + " ist mehr mal definiert. Er muss nur einmal definiert sein.");
                    break;
                }

            }

            if (!unique){
                break;
            }
        }
        return unique;
    }

    private boolean is_unique_parameters_name(ArrayList<String> parameters_names){    // pruft ob jeder deklarierte Parameter für ein Macro eindeutig ist

        boolean unique = true;

        int initpos = 0;
        int lastpos = 0;
        for (int l = 0; l < parameters_Anzahl.size(); l++) {
            initpos = lastpos;
            lastpos = lastpos + parameters_Anzahl.get(l);

            for (int i = initpos; i < lastpos ; i++) {
                for (int j = i+1; j < lastpos ; j++) {

                    if (parameters_names.get(i).equals(parameters_names.get(j))){
                        unique = false;
                        System.out.println("Der Parameter " + parameters_names.get(i) + " ist mehr mal definiert. Es muss nur einmal definiert sein.");
                        break;
                    }

                }

                if (!unique){
                    break;
                }
            }
        }
        return unique;
    }

    private static ArrayList<String> takeName_anruf(ArrayList<String> all_macro_name_anruf){        //extrahiert alle Macro Name und gibt die in einem List zurück
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < all_macro_name_anruf.size() ; i++) {

            int index = all_macro_name_anruf.get(i).indexOf("(");
            String name = all_macro_name_anruf.get(i).substring(0,index);
            list.add(name);
        }
        return list;
    }
}
