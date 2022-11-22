start -> program
program -> MODULE MAIN SEMICOLON block MAIN DOT
block -> declList BEGIN stmtList END
declList -> decl SEMICOLON declList | EPSILON
decl -> constDecl | varDecl | procDecl
constDecl -> CONST constDeclItem constDeclItemInner
constDeclItemInner -> COMMA constDeclItem constDeclItemInner | EPSILON
constDeclItem -> ID COLON type EQUAL constExpr
constExpr -> ID | INTEGER | CHARACTER
varDecl -> VAR varDeclItem varDeclItemInner
varDeclItemInner-> COMMA varDeclItem varDeclItemInner | EPSILON
varDeclItem -> ID COLON type
procDecl -> PROCEDURE ID BRACKET_OPEN procFormalCallChoice BRACKET_CLOSE colonTypeChoice SEMICOLON block ID
colonTypeChoice-> COLON type | EPSILON
procFormalCallChoice -> formalDecl formalDeclInnerRepeat | EPSILON
formalDeclInnerRepeat-> COMMA formalDecl formalDeclInnerRepeat | EPSILON
formalDecl -> ID COLON type
type -> INT | CHAR | ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type
stmtList-> decl SEMICOLON stmtListStmtInner | stmt SEMICOLON stmtListStmtInner | EPSILON
stmtListStmtInner-> stmtList | EPSILON
stmt -> callStmt | assignStmt | returnStmt | outStmt | ifStmt | whileStmt | forStmt
callStmt -> ID BRACKET_OPEN exprInner BRACKET_CLOSE
exprInner -> exprs | EPSILON
assignStmt -> lvalue ASSIGNMENT expr
lvalue -> ID | ID SQ_OPEN sum SQ_CLOSE
returnStmt -> RETURN sumCallInner
sumCallInner-> sum | EPSILON
outStmt -> OUTPUT ASSIGNMENT expr | OUTPUT ASSIGNMENT STRING
ifStmt -> IF condition THEN stmtList ifStmtInner END
ifStmtInner-> SQ_OPEN ELSE stmtList SQ_CLOSE | EPSILON
whileStmt -> WHILE condition DO stmtList END
forStmt -> FOR sum TO sum DO stmtList END
condition -> innerStatement | innerStatement AND condition | innerStatement OR condition | NOT condition
innerStatement -> ODD sum | sum relop sum
relop -> LT | LTE | EQUAL | GTE | GT | NOTEQUAL
exprs -> expr exprsInner
exprsInner-> COMMA expr exprInner | EPSILON
expr -> sum | CHARACTER
sum -> term sumInner
sumInner-> PLUS term sumInner | MINUS term sumInner | EPSILON
term -> factor termMultDivFactor
termMultDivFactor-> MULTIPLICATION factor termMultDivFactor | DIVISION factor termMultDivFactor | EPSILON
factor -> MINUS factor | lvalue | INTEGER | INPUT | callStmt | BRACKET_OPEN expr BRACKET_CLOSE