grammar Lexar;

start : program;
program : MODULE MAIN SEMICOLON block MAIN DOT;
block : declList BEGIN stmtList END;
declList : decl SEMICOLON declList | ;
decl : constDecl
    | varDecl
    | procDecl;
constDecl : CONST constDeclItem constDeclItemInner;
constDeclItemInner : COMMA constDeclItem constDeclItemInner | ;
constDeclItem : ID COLON type EQUAL constExpr;
constExpr : ID
    | INTEGER
    | CHARACTER;
varDecl : VAR varDeclItem varDeclItemInner;
varDeclItemInner: COMMA varDeclItem varDeclItemInner | ;
varDeclItem : ID COLON type;
procDecl : PROCEDURE ID BRACKET_OPEN procFormalCallChoice BRACKET_CLOSE colonTypeChoice SEMICOLON block ID;
colonTypeChoice: COLON type | ;
procFormalCallChoice : formalDecl formalDeclInnerRepeat | ;
formalDeclInnerRepeat: COMMA formalDecl formalDeclInnerRepeat | ;
formalDecl : ID COLON type;
type : INT
    | CHAR
    | ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type;
stmtList: decl SEMICOLON stmtListStmtInner | stmt SEMICOLON stmtListStmtInner | ;
stmtListStmtInner: stmtList | ;

stmt : callStmt
    | assignStmt
    | returnStmt
    | outStmt
    | ifStmt
    | whileStmt
    | forStmt;
callStmt : ID BRACKET_OPEN exprInner BRACKET_CLOSE;
exprInner : exprs | ;
assignStmt : lvalue ASSIGNMENT (expr);
lvalue : ID lvalueInner;
lvalueInner : SQ_OPEN sum SQ_CLOSE | ;
returnStmt : RETURN sumCallInner;
sumCallInner: sum | ;
outStmt : OUTPUT ASSIGNMENT outStmtInner;
outStmtInner: expr | STRING;
ifStmt : IF condition THEN stmtList ifStmtInner END;
ifStmtInner: SQ_OPEN ELSE stmtList SQ_CLOSE | ;
whileStmt : WHILE condition DO stmtList END;
forStmt : FOR sum TO sum DO stmtList END;
condition : innerStatement conditionInner
   | NOT condition;
conditionInner: AND condition | OR condition | ;
innerStatement :  ODD sum
    | sum relop sum;
relop : LT
    | LTE
    | EQUAL
    | GTE
    | GT
    | NOTEQUAL;
exprs : expr exprsInner;
exprsInner: COMMA expr exprInner | ;
expr : sum
    | CHARACTER;
sum : term sumInner;
sumInner: PLUS term sumInner | MINUS term sumInner | ;
term : factor termMultDivFactor;
termMultDivFactor: MULTIPLICATION factor termMultDivFactor | DIVISION factor termMultDivFactor | ;
factor : MINUS factor
    | lvalue
    | INTEGER
    | INPUT
    | callStmt
    | BRACKET_OPEN expr BRACKET_CLOSE;

//Spaces and non-graphical characters
WS: ('\n' | '\t' | ' ') -> skip;

//keywords
MODULE: 'module';
PROCEDURE: 'procedure';
MAIN: 'main';
BEGIN: 'begin';
END: 'end';
CONST: 'const';
VAR: 'var';
INT: 'int';
CHAR: 'char';
IF: 'if';
THEN: 'then';
ELSE: 'else';
INPUT: 'input';
OUTPUT: 'output';
ODD: 'odd';
RETURN: 'return';

//Boolean operators
OR: 'or';
AND: 'and';
NOT: 'not';

//While loop
WHILE: 'while';
DO: 'do';

//For Loop
FOR: 'for';
TO: 'to';

//Extended tokens for arrays
ARRAY: 'array';
OF: 'of';

//Variables and values
ID: ([a-zA-Z_][a-zA-Z0-9_]*);
INTEGER: [0]|[1-9]+[0-9]*;
CHARACTER: ('\''([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])'\'');

//operators
PLUS: '+';
MINUS: '-';
MULTIPLICATION: '*';
DIVISION: '/';
ASSIGNMENT: ':=';
EQUAL: '=';
NOTEQUAL: '<>';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';

//Punctuations
SEMICOLON: ';';
COLON: ':';
DOT: '.';
COMMA: ',';
BRACKET_OPEN: '(';
BRACKET_CLOSE: ')';
SQ_OPEN: '[';
SQ_CLOSE: ']';

//Comments
COMMENT: ('#'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*) -> skip;
COMMENT_MULTILINE: ('##'([a-zA-Z0-9_ ]|~[a-zA-Z0-9])*'##') -> skip;

//String
STRING: ('"'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*'"');







