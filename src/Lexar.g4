lexer grammar Lexar;

//Spaces and non-graphical characters
WS: ('\n'|'\t'|' ') -> skip;

//keywords
MODULE: 'module';
PROCEDURE: 'procedure';
BEGIN: 'begin';
END: 'end';
CONST: 'const';
VAR: 'var';
INT: 'int';
CHAR: 'char';
BOOLEAN: 'bool';
IF: 'if';
THEN: 'then';
ELSE: 'else';
INPUT: 'input';
OUTPUT: 'output';
ODD: 'odd';
RETURN: 'return';

//Booleans
TRUE: 'true';
FALSE: 'false';

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







