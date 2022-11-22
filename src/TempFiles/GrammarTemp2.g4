start -> program
program -> MODULE MAIN SEMICOLON block MAIN DOT
block -> declList BEGIN stmtList END
declList -> decl SEMICOLON declList
declList -> //epsilon, follow: BEGIN
decl -> constDecl
decl -> varDecl
decl -> procDecl
constDecl -> CONST constDeclItem constDeclItemInner
constDeclItemInner -> COMMA constDeclItem constDeclItemInner
constDeclItemInner -> //epsilon, follow: SEMICOLON
constDeclItem -> ID COLON type EQUAL constExpr
constExpr -> ID
constExpr -> INTEGER
constExpr -> CHARACTER
varDecl -> VAR varDeclItem varDeclItemInner
varDeclItemInner -> COMMA varDeclItem varDeclItemInner
varDeclItemInner -> //epsilon, follow: SEMICOLON
varDeclItem -> ID COLON type
procDecl -> PROCEDURE ID BRACKET_OPEN procFormalCallChoice BRACKET_CLOSE colonTypeChoice SEMICOLON block ID
colonTypeChoice -> COLON type
colonTypeChoice -> //epsilon, follow: SEMICOLON
procFormalCallChoice -> formalDecl formalDeclInnerRepeat
procFormalCallChoice ->
formalDeclInnerRepeat-> COMMA formalDecl formalDeclInnerRepeat
formalDecl -> ID COLON type
type -> INT
type -> CHAR
type -> ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type
stmtList -> decl SEMICOLON stmtListStmtInner
stmtList -> stmt SEMICOLON stmtListStmtInner
stmtList -> //epsilon
stmtListStmtInner -> stmtList
stmtListStmtInner -> //epsilon
stmt -> callStmt
stmt -> assignStmt
stmt -> returnStmt
stmt -> outStmt
stmt -> ifStmt
stmt -> whileStmt
stmt -> forStmt
callStmt -> ID BRACKET_OPEN exprInner BRACKET_CLOSE
exprInner -> exprs
exprInner -> //epsilon
assignStmt -> lvalue ASSIGNMENT expr
lvalue -> ID lvalueInner
lvalueInner -> SQ_OPEN sum SQ_CLOSE
lvalueInner -> //epsilon
returnStmt -> RETURN sumCallInner
sumCallInner -> sum
sumCallInner -> //epsilon
outStmt -> OUTPUT ASSIGNMENT outStmtInner
outStmtInner -> expr
outStmtInner -> STRING
ifStmt -> IF condition THEN stmtList ifStmtInner END
ifStmtInner -> SQ_OPEN ELSE stmtList SQ_CLOSE
ifStmtInner -> //epsilon
whileStmt -> WHILE condition DO stmtList END
forStmt -> FOR sum TO sum DO stmtList END
condition -> innerStatement conditionInner
condition -> NOT condition
conditionInner -> AND condition
conditionInner -> OR condition
conditionInner -> //epsilon
innerStatement -> ODD sum
innerStatement -> sum relop sum
relop -> LT
relop -> LTE
relop -> EQUAL
relop -> GTE
relop -> GT
relop -> NOTEQUAL
exprs -> expr exprsInner
exprsInner -> COMMA expr exprInner
exprsInner -> //epsilon
expr -> sum
expr -> CHARACTER
sum -> term sumInner
sumInner -> PLUS term sumInner
sumInner -> MINUS term sumInner
sumInner -> //epsilon
term -> factor termMultDivFactor
termMultDivFactor -> MULTIPLICATION factor termMultDivFactor
termMultDivFactor -> DIVISION factor termMultDivFactor
termMultDivFactor -> //epsilon
factor -> MINUS factor
factor -> lvalue
factor -> INTEGER
factor -> INPUT
factor -> callStmt
factorInner -> BRACKET_OPEN exprInner BRACKET_CLOSE

