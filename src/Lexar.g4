lexer grammar Lexar;

//TODO: Add return, for-loop, break regex and booleans. Maybe add while loops, extneded PL/0 support for _ in ID, include maybe
//TODO: Add regex for comments
//TODO: Look into: https://courses.cs.washington.edu/courses/cse401/02sp/pl0/proj.html for extra information pertaining to extended keywords

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
IF: 'if';
THEN: 'then';
ELSE: 'else';
INPUT: 'input';
OUTPUT: 'output';
ODD: 'odd';
RETURN: 'return';

//Booleans
BOOLEAN: 'bool';
TRUE: 'true';
FALSE: 'false';

//Boolean operators
OR: 'or';
AND: 'and';

//Loops, we'll stick with while loops alone
WHILE: 'while';
DO: 'do';

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
BRACKET_OPEN: '(';
BRACKET_CLOSE: ')';

//Comment
COMMENT: ('#'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*) -> skip;
COMMENT_MULTILINE: ('##'([a-zA-Z0-9_ ]|~[a-zA-Z0-9])*'##') -> skip;

//String
STRING: ('"'([a-zA-Z0-9_ ]|~[a-zA-Z0-9])*'"');







