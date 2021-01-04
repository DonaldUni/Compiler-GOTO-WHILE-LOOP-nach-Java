package main.java._1_Interfaces;

import org.antlr.v4.runtime.tree.ParseTree;

public interface CommunMethode {


    public  void speicherungElemente(ParseTree tree) ;    // holt und speichert die Eingaben

    public  void toJavaCode () ;                        // compieliert die gespeicherten Eingaben in JavaCode String

    public boolean zuKompilieren() ;                    // sagt ob der eingegebene Code kompilierbar ist oder nicht

}
