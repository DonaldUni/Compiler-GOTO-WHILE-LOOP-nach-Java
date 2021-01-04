package main.java._0_Main;

import main.java._0_ParserGrammatik.GrammatikLexer;
import main.java._0_ParserGrammatik.GrammatikParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {    // Hauptmethode des Projektes


    public static void main(String[] args) {
        // parser und lexer generator
        ANTLRInputStream input = null;
        try {  // nimmt die Eingaben von CodeSource
            input = new ANTLRFileStream("D:\\Universität\\Bachelor Cyklus\\7 Semester\\Bacherlor Arbeit\\Compiler\\Eingabe_Datei\\Eingabe_Datei.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        GrammatikLexer lexer = new GrammatikLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammatikParser parser = new GrammatikParser(tokens);
        ParseTree tree = parser.program();

        int anzahlError = parser.getNumberOfSyntaxErrors();  // spechert die Anzahl von Fehler



        // Compilieren wenn kein Fehler gschehen ist
       if (anzahlError == 0){


            Strategie_Pattern pattern = new Strategie_Pattern(args);   //Strategie pattern : Wählt abhängig vom LOOP/While/Goto Program den entsprechenden Controller
            Controller controller = pattern.visit(tree) ;

            controller.speicherungElemente(tree);  // holt und speichert die Eingaben

            if (controller.zuKompilieren()){

                controller.toJavaCode();               // compieliert die gespeicherten Eingaben in JavaCode String
            }
        }

    }

}
