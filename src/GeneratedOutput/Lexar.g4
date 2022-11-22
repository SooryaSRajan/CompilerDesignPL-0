grammar Lexar;
@parser::header { import AST.*; }

//start returns [ASTNode node] : t1= stmtlist {$t1.node.print();};
start : t1 = program {$t1.node.print();};
program  returns [ASTNode node] : MODULE MAIN SEMICOLON t2 = block MAIN DOT {$node = new BlockProgram($t2.node);};
block returns [ASTNode node] : t3 = declList BEGIN t4 = stmtList END {$node = new StatementBlock($t3.node, $t4.node);};
//EmptyDeclList
declList returns [ASTNode node] : t5 = decl SEMICOLON t6 = declList {$node = new DeeclarationsDeclList($t5.node, $t6.node);}
    | {$node = new EmptyDeclList();};
decl returns [ASTNode node] : t7 = constDecl {$node = new ConstantDecl($t7.node);}
    | t8 = varDecl {$node = new VariableDecl($t8.node);}
    | t9 = procDecl {$node = new ProceduralDecl($t9.node);};
constDecl returns [ASTNode node] : CONST t10 = constDeclItem t11 = constDeclItemInner {$node = new ItemsConstDecl($t10.node, $t11.node);};
constDeclItemInner returns [ASTNode node] : COMMA t12 = constDeclItem t13 = constDeclItemInner {$node = new ItemsConstDeclItemInner($t12.node, $t13.node);}
    | {$node = new EmptyConstDeclItemInner();};
constDeclItem returns [ASTNode node] : ID COLON t14 = type EQUAL t15 = constExpr {$node = new ExprConstDeclItem($t14.node, $t15.node);};
constExpr returns [ASTNode node] : ID  {$node = new IDConstExpr($ID.text);}
    | INTEGER {$node = new IntegerConstExpr($INTEGER.text);}
    | CHARACTER {$node = new CharacterConstExpr($CHARACTER.text);};
varDecl returns [ASTNode node] : VAR t16 = varDeclItem t17 = varDeclItemInner {$node = new ItemsVarDecl($t16.node, $t17.node);};
varDeclItemInner returns [ASTNode node]: COMMA t18 = varDeclItem t19 = varDeclItemInner {$node = new ItemsVarDeclItemInner($t18.node, $t19.node);}
    | {$node = new EmptyVarDeclItemInner();};
varDeclItem returns [ASTNode node] : ID COLON t20 = type {$node = new TypeVarDeclItem($t20.node);};
procDecl returns [ASTNode node] : PROCEDURE ID BRACKET_OPEN t21 = procFormalCallChoice BRACKET_CLOSE t22 = colonTypeChoice SEMICOLON t23 = block ID SEMICOLON {$node = new BlockProcDecl($t21.node, $t22.node, $t23.node);};
colonTypeChoice returns [ASTNode node] : COLON t24 = type {$node = new TypeColonTypeChoice($t24.node);}
    |  {$node = new EmptyColonTypeChoice();};
procFormalCallChoice returns [ASTNode node] : t25 = formalDecl t26 = formalDeclInnerRepeat {$node = new ItemsProcFormalCallChoice($t25.node, $t26.node);}
    | {$node = new EmptyProcFormalCallChoice();};
    //TODO: Add class for formalDeclInnerRepeat empty class
formalDeclInnerRepeat returns [ASTNode node] : COMMA t27 = formalDecl t28 = formalDeclInnerRepeat {$node = new RepeatingFormalDeclInnerRepeat($t27.node, $t28.node);}
    | {$node = new EmptyFormalDeclInnerRepeat();};
formalDecl returns [ASTNode node] : ID COLON t29 = type {$node = new TypeFormalDecl($t29.node);};
type returns [ASTNode node] : INT {$node = new IntType($INT.text);}
    | CHAR {$node = new CharType($CHAR.text);}
    | ARRAY SQ_OPEN INTEGER SQ_CLOSE OF t30 = type {$node = new ArrayType($t30.node);};
stmtList returns [ASTNode node] : t31 = decl SEMICOLON t32 = stmtListStmtInner {$node = new DeclarationStmtList($t31.node, $t32.node);}
    | t33 = stmt SEMICOLON t34 = stmtListStmtInner {$node = new StatementStmtList($t33.node, $t34.node);}
    | {$node = new EmptyStmtList();};
stmtListStmtInner returns [ASTNode node] : t35 = stmtList {$node = new StmtListStmtListInner($t35.node);}
    | {$node = new EmptyStmtListInner();};

stmt returns [ASTNode node] : t36 = callStmt {$node = new FunctionCallStmt($t36.node);}
    | t37 = assignStmt {$node = new AssignmentStmt($t37.node);}
    | t38 = returnStmt {$node = new ProcedureReturnStmt($t38.node);}
    | t39 = outStmt {$node = new OutputStmt($t39.node);}
    | t40 = ifStmt {$node = new IfBlockStmt($t40.node);}
    | t41 = whileStmt {$node = new WhileLoopStmt($t41.node);}
    | t42 = forStmt {$node = new ForLoopStmt($t42.node);};
callStmt returns [ASTNode node] : ID BRACKET_OPEN t43 = exprInner BRACKET_CLOSE {$node = new ExprCallStmt($t43.node);};
exprInner returns [ASTNode node] : t44 = exprs {$node = new ExprsExprInner($t44.node);}
    | {$node = new EmptyExprInner();};
assignStmt returns [ASTNode node] : t45 = lvalue ASSIGNMENT ( t46 = expr) {$node = new ExprAssignStmt($t45.node, $t46.node);};
lvalue returns [ASTNode node] : ID t47 = lvalueInner {$node = new InnerLvalue($t47.node);};
lvalueInner returns [ASTNode node] : SQ_OPEN t48 = sum SQ_CLOSE {$node = new ExprLvalueInner($t48.node);}
    | {$node = new EmptyLvalueInner();};
returnStmt returns [ASTNode node] : RETURN t49 = sumCallInner {$node = new ExprReturnStmt($t49.node);};
sumCallInner returns [ASTNode node] : t50 = sum {$node = new SumSumCallInner($t50.node);}
    | {$node = new EmptySumCallInner();};
outStmt returns [ASTNode node] : OUTPUT ASSIGNMENT t51 = outStmtInner {$node = new AssignmentOutStmt($t51.node);};
outStmtInner returns [ASTNode node] : t52 = expr {$node = new ExprOutStmtInner($t52.node);}
    | STRING {$node = new StringOutStmtInner($STRING.text);};
ifStmt returns [ASTNode node] : IF t53 = condition THEN t54 = stmtList t55 = ifStmtInner END {$node = new StmtListIfStmt($t53.node, $t54.node, $t55.node);};
ifStmtInner returns [ASTNode node] : SQ_OPEN ELSE t56 = stmtList SQ_CLOSE {$node = new StmtListIfStmtInner($t56.node);}
    | {$node = new EmptyIfStmtInner();};
whileStmt returns [ASTNode node] : WHILE t57 = condition DO t58 = stmtList END {$node = new StmtListWhileStmt($t57.node, $t58.node);};
forStmt returns [ASTNode node] : FOR t59 = sum TO t60 = sum DO t61 = stmtList END {$node = new StmtListForStmt($t59.node, $t60.node, $t61.node);};
condition returns [ASTNode node] : t62 = innerStatement t63 = conditionInner {$node = new InnerCondition($t62.node, $t63.node);}
   | NOT t64 = condition {$node = new NotCondition($t64.node);};
conditionInner returns [ASTNode node] : AND t65 = condition {$node = new AndConditionInner($t65.node);}
    | OR t66 = condition  {$node = new OrConditionInner($t66.node);}
    | {$node = new EmptyConditionInner();};
innerStatement returns [ASTNode node] :  ODD t67 = sum {$node = new OddInnerStatement($t67.node);}
    | t68 = sum t69 = relop t70 = sum {$node = new RelopInnerStatement($t68.node, $t69.node, $t70.node);};
relop returns [ASTNode node] : LT {$node = new LtRelop($LT.text);}
    | LTE {$node = new LTERelop($LTE.text);}
    | EQUAL {$node = new EqualRelop($EQUAL.text);}
    | GTE {$node = new GTERelop($GTE.text);}
    | GT {$node = new GtRelop($GT.text);}
    | NOTEQUAL {$node = new NotEqualRelop($NOTEQUAL.text);};
exprs returns [ASTNode node] : t71 = expr t72 = exprsInner {$node = new InnerExprs($t71.node, $t72.node);};
exprsInner returns [ASTNode node] : COMMA t73 = expr t74 = exprInner {$node = new InnerExprsInner($t73.node, $t74.node);}
    | {$node = new EmptyExprsInner();};
expr returns [ASTNode node] : t75 = sum {$node = new SumExpr($t75.node);}
    | CHARACTER {$node = new CharacterExpr($CHARACTER.text);};
sum returns [ASTNode node] : t76 = term t77 = sumInner {$node = new InnerSum($t76.node, $t77.node);};
sumInner returns [ASTNode node] : PLUS t78 = term t79 = sumInner {$node = new PlusSumInner($t78.node, $t79.node);}
    | MINUS t80 = term t81 = sumInner {$node = new MinusSumInner($t80.node, $t81.node);}
    | {$node = new EmptySumInner();};
term returns [ASTNode node] : t82 = factor t83 = termMultDivFactor {$node = new MultDivFactorTerm($t82.node, $t83.node);};
termMultDivFactor returns [ASTNode node] : MULTIPLICATION t84 = factor t85 = termMultDivFactor {$node = new MultTermMultDivFactor($t84.node, $t85.node);}
    | DIVISION t86 = factor t87 = termMultDivFactor {$node = new DivTermMultDivFactor($t86.node, $t87.node);}
    | {$node = new EmptyTermMultDivFactor();};
factor returns [ASTNode node] : MINUS t88 = factor {$node = new MinusFactor($t88.node);}
    | t89 = lvalue {$node = new LValueFactor($t89.node);}
    | INTEGER {$node = new IntegerFactor($INTEGER.text);}
    | INPUT {$node = new InputFactor($INPUT.text);}
    | t90 = callStmt {$node = new CallStatementFactor($t90.node);}
    | BRACKET_OPEN t91 = expr BRACKET_CLOSE {$node = new BracketFactorInner($t91.node);};

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