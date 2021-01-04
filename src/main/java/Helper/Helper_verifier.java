package main.java.Helper;

import java.util.ArrayList;

public class Helper_verifier {

    //pruf ob alle Macro anruf sind korrekt , Namen und parameter anzahl
    public boolean  macro_anruf_prufer(ArrayList<String> all_macro_name, ArrayList<Integer> parameters_Anzahl, ArrayList<String> all_macro_name_anruf, ArrayList<Integer> macro_anzahl_param_name ){
        boolean macro_anruf_gultig = false;

        if (all_macro_name_anruf.size() == 0){

            macro_anruf_gultig = true;
        }else {
            for (int i = 0; i < all_macro_name_anruf.size() ; i++) {
                boolean tmpName = false;
                boolean tmpCounter = false;

                for (int j = 0; j < all_macro_name.size(); j++) {

                    if (all_macro_name.get(j).equals(all_macro_name_anruf.get(i))){
                        tmpName = true ;
                        if (parameters_Anzahl.get(j) == macro_anzahl_param_name.get(i)){
                            tmpCounter = true;
                            break;
                        }else {
                            tmpCounter = false;
                            System.out.println("Fehler: Die Anzahl von Parameters für die Macro " + all_macro_name.get(j) + " stimmt nicht."
                                    + "\n" + "Sie mussen fur diesen Macro " + parameters_Anzahl.get(j) + " Parameters eingeben bitte");

                        }
                    }else {
                        continue;
                    }

                    if (!tmpCounter){
                        break;
                    }


                }

                macro_anruf_gultig = tmpCounter; // wenn tmpCounter true ist, ist auch tmpName true

                if (!macro_anruf_gultig){
                    break;
                }

                if (!tmpName){
                    System.out.println("Fehler : Der Macro " + all_macro_name_anruf.get(i) + " existiert nicht !");
                    break;
                }
            }
        }

        return macro_anruf_gultig ;
    }

    // pruf ob die parameter in macro anruf sind im Loop programm enthalten oder existiert nicht
    public  boolean parameter_macro_prufen (ArrayList<String>  parameters_names,  ArrayList<String>  variables_names, ArrayList<String>  deklarierte_param, ArrayList<String> macro_anruf_param_name, int position_start, int anzahl_param){

        boolean macro_param_gultig = true;
        for (int i = 0; i < macro_anruf_param_name.size(); i++) {

            if (! macro_anruf_param_name.get(i).equals("x0")){
                boolean tmp = false;

                for (int j = 0; j < parameters_names.size(); j++) { // prüfen ob der aufgerufene paramerter existier in deklarierte Parameter

                    if (macro_anruf_param_name.get(i).equals(parameters_names.get(j))){
                        tmp = true ;
                        break;
                    }

                }

                if(!tmp){           // wenn tmp true ist, braucht man diese if nicht mehr
                    for (int j = 0; j < variables_names.size(); j++) {

                        if (macro_anruf_param_name.get(i).equals(variables_names.get(j))){
                            tmp = true ;
                            break;
                        }
                    }
                }

                if(!tmp){           // wenn tmp true ist, braucht man diese if nicht mehr
                    for (int j = position_start; j < position_start + anzahl_param; j++) {

                        if (macro_anruf_param_name.get(i).equals(deklarierte_param.get(j))){
                            tmp = true ;
                            break;
                        }
                    }
                }

                macro_param_gultig = tmp ;

                if (!tmp){
                    System.out.println("Fehler : Der Name " + macro_anruf_param_name.get(i) + " existiert nicht im Loop program, wo es genutzt ist." );
                    break;
                }
            }else {
                macro_param_gultig = true;
            }

        }
        return macro_param_gultig;
    }

    // pruf ob ein Parameter, der in einen Macro anruf existiert, ist als Parameter des deklarierten Macro definiert
    public boolean exist(ArrayList<String> deklarierte_macro_param_name, String name,  int position_start, int anzahl_param){
        boolean gultig = false;
        for (int j = position_start; j < position_start + anzahl_param; j++) {

            if (deklarierte_macro_param_name.get(j).equals(name)){
                gultig = true ;
                break;
            }
        }
        return gultig;
    }

    // pruf für den Haupt-Loop ob die parameter in macro anruf sind im Loop programm enthalten oder existiert nicht
    public boolean macro_anruf_prufer(ArrayList<String>  parameters_names, ArrayList<String>  variables_names, ArrayList<String> macro_param_name){

        boolean gultig = false;
        if (parameters_names.size()== 0){
            gultig = true;

        }else {

            if (macro_param_name.size() == 0){
                gultig = true;

            }else {
                for (int i = 0; i < macro_param_name.size(); i++) {

                    if (! macro_param_name.get(i).equals("x0")){
                        boolean tmp = false;

                        for (int j = 0; j < parameters_names.size(); j++) {

                            if (macro_param_name.get(i).equals(parameters_names.get(j))){
                                tmp = true;
                                break;
                            }
                        }

                        if (!tmp){
                            for (int j = 0; j < variables_names.size(); j++) {

                                if (macro_param_name.get(i).equals(variables_names.get(j))){
                                    tmp = true;
                                    break;
                                }
                            }
                        }

                        gultig = tmp;

                        if (!gultig) {
                            System.out.println("Fehler : Der parameter " + macro_param_name.get(i) + " existiert nicht im Loop program, wo es genutzt ist.");
                            break;
                        }

                    }else {
                        gultig = true;
                    }
                }
            }
        }

        return gultig;
    }

}
