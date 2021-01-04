package main.java._0_Main;

import main.java._1_Interfaces.CommunMethode;
import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class Controller extends GrammatikBaseVisitor implements CommunMethode {
    // Dieser Controller implementiert die gemeinsamen Mehoden, die alle Controller (Loop, While und Goto) zur Verfügung stellen müssen
    private boolean kompilieren = false;

    public Controller(String[] args) {

    }

    @Override
    public void speicherungElemente(ParseTree tree) {

    }

    @Override
    public void toJavaCode() {

    }

    @Override
    public boolean zuKompilieren() {
        return false;
    }

}
