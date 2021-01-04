package main.java._0_Main;

import main.java._2_GOTO.GoTo_Controller;
import main.java._2_GOTO.GoTo_Macro_Controller;
import main.java._2_LOOP.Loop_Controller;
import main.java._0_ParserGrammatik.GrammatikBaseVisitor;
import main.java._0_ParserGrammatik.GrammatikParser;
import main.java._2_LOOP.Loop_Macro_Controller;
import main.java._2_WHILE.While_Controller;
import main.java._2_WHILE.While_Macro_Controller;

public class Strategie_Pattern  extends GrammatikBaseVisitor<Controller> {

    private String[] args ;

    protected Strategie_Pattern(String[] args) {
        this.args = args ;
    }

    // Abhangig  des Types des Elementes ( ctx) gibt die Method den passenden Controller zurück
    @Override
    public Controller visitProgram(GrammatikParser.ProgramContext ctx) {

        Controller controller ;
        String name = ctx.getChild(0).getClass().getSimpleName() ;

        switch (name) {

            case "MacroLoopsContext" : controller = new Loop_Macro_Controller(args);
                break;

            case  "LoopsContext" : controller = new Loop_Controller(args);
                break;

            case "MacroWhilesContext" : controller = new While_Macro_Controller(args);
                break;

            case "WhilesContext" : controller = new While_Controller(args);
                break;

            case "MacroGotosContext" : controller = new GoTo_Macro_Controller(args);
                break;

            default: controller = new GoTo_Controller(args);
                break;
        }

        return controller;
    }
}
