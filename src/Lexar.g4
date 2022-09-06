lexer grammar Lexar;

//keywords
MODULE: 'module';
PROCEDURE: 'procedure';
BEGIN: 'begin';
END: 'end';
CONST: 'const';
VAR: 'var';
INT: 'int';
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
INPUT: 'input';
OUTPUT: 'output';
ODD: 'odd';

//Extended tokens for arrays
ARRAY: 'array';
OF: 'of';
ARR_OPEN: '[';
ARR_CLOSE: ']';

ID: ([a-zA-Z][a-zA-Z0-9]*);
INTEGER: [0]|[1-9]+[0-9]*;

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
LBRACKET: '(';
RBRACKET: ')';

//spaces and non-graphical characters
WS: ('\n'|'\t'|' ') -> skip;





