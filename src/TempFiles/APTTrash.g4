start -> program //ProgramStart

program -> MODULE MAIN SEMICOLON block MAIN DOT //BlockProgram

block -> declList BEGIN stmtList END //StatementBlock

declList -> decl SEMICOLON declList //DeeclarationsDeclList
declList -> //EmptyDeclList

decl -> constDecl //ConstDecl
decl -> varDecl //VarDecl
decl -> procDecl //ProcDecl

constDecl -> CONST constDeclItem constDeclItemInner //ItemsConstDecl

constDeclItemInner -> COMMA constDeclItem constDeclItemInner //ItemsConstDeclItemInner
constDeclItemInner -> //EmptyConstDeclItemInner

constDeclItem -> ID COLON type EQUAL constExpr //ExprConstDeclItem

constExpr -> ID //IDConstExpr
constExpr -> INTEGER //IntegerConstExpr
constExpr -> CHARACTER //CharacterConstExpr

varDecl -> VAR varDeclItem varDeclItemInner //ItemsVarDecl

varDeclItemInner -> COMMA varDeclItem varDeclItemInner //ItemsVarDeclItemInner
varDeclItemInner -> //EmptyVarDeclItemInner

varDeclItem -> ID COLON type //TypeVarDeclItem

procDecl -> PROCEDURE ID BRACKET_OPEN procFormalCallChoice BRACKET_CLOSE colonTypeChoice SEMICOLON block ID //BlockProcDecl

colonTypeChoice -> COLON type //TypeColonTypeChoice
colonTypeChoice -> //EmptyColonTypeChoice

procFormalCallChoice -> formalDecl formalDeclInnerRepeat //ItemsProcFormalCallChoice
procFormalCallChoice -> //EmptyProcFormalCallChoice

formalDeclInnerRepeat-> COMMA formalDecl formalDeclInnerRepeat //RepeatingFormalDeclInnerRepeat
formalDeclInnerRepeat -> EPSILON //EmptyFormalDeclInnerRepeat
formalDecl -> ID COLON type //TypeFormalDecl

type -> INT //IntType
type -> CHAR //CharType
type -> ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type //ArrayType

stmtList -> decl SEMICOLON stmtListStmtInner //DeclarationStmtList
stmtList -> stmt SEMICOLON stmtListStmtInner //StatementStmtList
stmtList -> //EmptyStmtList

stmtListStmtInner -> stmtList //StmtListStmtListInner
stmtListStmtInner -> //EmptyStmtListInner

stmt -> callStmt //FunctionCallStmt
stmt -> assignStmt //AssignmentStmt
stmt -> returnStmt //ProcedureReturnStmt
stmt -> outStmt //OutputStmt
stmt -> ifStmt //IfBlockStmt
stmt -> whileStmt //WhileLoopStmt
stmt -> forStmt //ForLoopStmt

callStmt -> ID BRACKET_OPEN exprInner BRACKET_CLOSE //ExprCallStmt

exprInner -> exprs //ExprsExprInner
exprInner -> //EmptyExprInner

assignStmt -> lvalue ASSIGNMENT expr //ExprAssignStmt

lvalue -> ID lvalueInner //InnerLvalue

lvalueInner -> SQ_OPEN sum SQ_CLOSE //ExprLvalueInner
lvalueInner -> //EmptyLvalueInner

returnStmt -> RETURN sumCallInner //ExprReturnStmt

sumCallInner -> sum //SumSumCallInner
sumCallInner -> //EmptySumCallInner

outStmt -> OUTPUT ASSIGNMENT outStmtInner //AssignmentOutStmt

outStmtInner -> expr //ExprOutStmtInner
outStmtInner -> STRING //StringOutStmtInner

ifStmt -> IF condition THEN stmtList ifStmtInner END //StmtListIfStmt

ifStmtInner -> SQ_OPEN ELSE stmtList SQ_CLOSE //StmtListIfStmtInner
ifStmtInner -> //EmptyIfStmtInner

whileStmt -> WHILE condition DO stmtList END //StmtListWhileStmt

forStmt -> FOR sum TO sum DO stmtList END //StmtListForStmt

condition -> innerStatement conditionInner //InnerCondition
condition -> NOT condition //NotCondition

conditionInner -> AND condition //AndConditionInner
conditionInner -> OR condition //OrConditionInner
conditionInner -> //EmptyConditionInner

innerStatement -> ODD sum //OddInnerStatement
innerStatement -> sum relop sum //RelopInnerStatement

relop -> LT //LtRelop
relop -> LTE //LTERelop
relop -> EQUAL //EqualRelop
relop -> GTE //GTERelop
relop -> GT //GtRelop
relop -> NOTEQUAL //NotEqualRelop

exprs -> expr exprsInner //InnerExprs

exprsInner -> COMMA expr exprInner //InnerExprsInner
exprsInner -> //EmptyExprsInner

expr -> sum //SumExpr
expr -> CHARACTER //CharacterExpr

sum -> term sumInner //InnerSum

sumInner -> PLUS term sumInner //PlusSumInner
sumInner -> MINUS term sumInner //MinusSumInner
sumInner -> //EmptySumInner

term -> factor termMultDivFactor //MultDivFactorTerm

termMultDivFactor -> MULTIPLICATION factor termMultDivFactor //MultTermMultDivFactor
termMultDivFactor -> DIVISION factor termMultDivFactor //DivTermMultDivFactor
termMultDivFactor -> //EmptyTermMultDivFactor

factor -> MINUS factor //MinusFactor
factor -> lvalue //LValueFactor
factor -> INTEGER //IntegerFactor
factor -> INPUT //InputFactor
factor -> callStmt //CallStatementFactor

factorInner -> BRACKET_OPEN exprInner BRACKET_CLOSE //BracketFactorInner

