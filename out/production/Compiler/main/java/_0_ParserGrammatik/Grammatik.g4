grammar Grammatik ;


program :   macroLoops ? loops EOF| macroWhiles ? whiles EOF | macroGotos ?  (gotos | gotoEnde) EOF;  // erste und haupt-rule


// spezifizierte Loops rules
loops :   assign | macroNameAnruf | ifLoop  | loops CommaPunkt loops | loopProgram ;

loopProgram : LoopStart counter DO (loops | nichts) Ende ;

ifLoop : If expIf Then (loops | nichts) Ende ;

counter : exp ;
nichts : ;



// spezifiziertes Whiles rules

whiles : assign  | macroNameAnruf |ifWhile  | whiles CommaPunkt whiles | whileProgram ;

whileProgram : WhileStart condition  DO ( whiles | nichts ) Ende ;

ifWhile : If expIf Then ( whiles | nichts ) Ende ;

condition : exp NichtGleich Zero
            | '(' condition ')'
             ;


 // spezialisierte  GoTo rules

gotos : gotoProgram CommaPunkt gotoEnde ;

gotoEnde : marken? ( GotoEnd | gotoAssign ) ;

gotoProgram : gotoCode | gotoProgram CommaPunkt gotoProgram ;

gotoCode : marken? gotoInstructions ;

gotoInstructions : assign | macroNameAnruf |  gotoAssign |  ifGoto ;

gotoAssign : GotoStart MarkeName ;

ifGoto : If expIf Then gotoAssign ;

marken : mark = MarkeName DoopeltPunkt ;




// Commun Rule für Expression
assign : var = Variable Gleich exp ;

exp :     var = Variable
           | Zero +
           | Value
           | '(' exp ')'
           | exp (Plus| Minus| Mal| Div ) exp
           | '(' exp (Plus| Minus| Mal| Div ) exp')'
           | '(' exp (Plus| Minus| Mal| Div ) exp')' + exp
           | macroNameAnruf
           ;


expIf : exp ( Gleichung | NichtGleich )  exp
        | '(' expIf ')';


///////// MACROS Defintion

// MACRO für loop Programm

macroLoops : macroLoop | macroLoops (text)? macroLoop ;

macroLoop : MacroSart MacroName KlammerAuf parameters KlammerZu Gleichung loops MacroEND ;


// MACRO  für while Program
macroWhiles : macroWhile | macroWhiles (text)? macroWhile ;

macroWhile : MacroSart MacroName KlammerAuf parameters KlammerZu Gleichung whiles MacroEND ;


// Macro für GOTO
macroGotos : macroGoto | macroGotos (text)? macroGoto ;

macroGoto : MacroSart MacroName KlammerAuf parameters KlammerZu Gleichung (gotos | gotoEnde) MacroEND ;



// Rules  die alle Macros nutzen

parameters :   Variable  | parameters Komma  Variable | nichts;

text : ( Variable | Value | NichtWichtigCharakter1 |NichtWichtigCharakter2 |Gleich | DoopeltPunkt | Gleichung | CommaPunkt | Plus | Minus | Komma | Mal | KlammerZu | Div| KlammerAuf| NichtGleich )+;

macroNameAnruf : MacroName KlammerAuf parameters KlammerZu  ;



//////////////////////////////////////////////////


// Schlusselwort Token
LoopStart : 'LOOP';
WhileStart : 'WHILE';
If : 'IF' ;
Then : 'THEN' ;

DO : 'DO' ;
Ende : 'END' ;

GotoStart : 'GOTO' ;
GotoEnd : 'HALT' ;

MacroSart :'MACRO' ;
MacroEND : 'MACROEND' ;


// Variablen
MarkeName : ('M') ('0'..'9')+ ;
MacroName : ('A'..'Z') ('a'..'z')* ;
Variable :  ('a'..'z' |'A'..'Z')('a'..'z' |'A'..'Z'| '0'..'9'| '_')* ;
Zero : '0';
Value : '0'..'9'+ ;
Text : 'a'..'z' ;

// Zeichen Token
Gleich : ':=' ;
DoopeltPunkt : ':';
Gleichung : '=';
CommaPunkt : ';' ;
Plus : '+' ;
Minus : '-' ;
Mal : '*' ;
Div : '/' ;
NichtGleich : '!=';
KlammerAuf : '(';
KlammerZu : ')';
Komma : ',';

NichtWichtigCharakter1 : '!'|'<'|'>'| '|'|'"'|'$'|'%'|'&'|'{'|'['|']'|'}'|'?'|'`'|'``'|'´'|'´´'|'~'|'#'| '.' | '^^'| '^';
NichtWichtigCharakter2 :  '²'|'§'|'³'|'°' ;
WhiteSpace : [ \t\r\n]+ -> skip ;
