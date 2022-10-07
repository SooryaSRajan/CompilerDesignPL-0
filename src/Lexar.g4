grammar Lexar;

start : program;
program : MODULE MAIN SEMICOLON block MAIN DOT;
block : declList BEGIN stmtList END;
declList : (decl SEMICOLON)*;
decl : constDecl
    | varDecl
    | procDecl;
constDecl : CONST constDeclItem (COMMA constDeclItem)*;
constDeclItem : ID COLON type EQUAL constExpr;
constExpr : ID
    | INTEGER
    | CHARACTER;
varDecl : VAR varDeclItem (COMMA varDeclItem)*;
varDeclItem : ID COLON type;
procDecl : PROCEDURE ID BRACKET_OPEN (formalDecl (COMMA formalDecl)*)? BRACKET_CLOSE (COLON type)? SEMICOLON block ID;
formalDecl : ID COLON type;
type : INT
    | CHAR
    | ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type;
stmtList : ((decl SEMICOLON)+ | (stmt SEMICOLON)+)*;
stmt : callStmt
    | assignStmt
    | returnStmt
    | outStmt
    | ifStmt
    | whileStmt
    | forStmt;
callStmt : ID BRACKET_OPEN (exprs)? BRACKET_CLOSE;
assignStmt : lvalue ASSIGNMENT (expr);
lvalue : ID
    | ID SQ_OPEN sum SQ_CLOSE;
returnStmt : RETURN (sum)?;
outStmt : OUTPUT ASSIGNMENT (expr | STRING);
ifStmt : IF condition THEN stmtList (SQ_OPEN ELSE stmtList SQ_CLOSE)? END;
whileStmt : WHILE condition DO stmtList END;
forStmt : FOR sum TO sum DO stmtList END;
condition : innerStatement
    | innerStatement AND condition
    | innerStatement OR condition
    | NOT condition;
innerStatement :  ODD sum
    | sum relop sum;
relop : LT
    | LTE
    | EQUAL
    | GTE
    | GT
    | NOTEQUAL;
exprs : expr (COMMA expr)*;
expr : sum
    | CHARACTER;
sum : term ((PLUS | MINUS) term)*;
term : factor ((MULTIPLICATION | DIVISION) factor)*;
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







