package GeneratedOutput;// Generated from /Users/sooryasrajan/AntlrCompilerDesign/src/Lexar.g4 by ANTLR 4.10.1
 import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LexarParser}.
 */
public interface LexarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LexarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LexarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LexarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LexarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LexarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LexarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LexarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#declList}.
	 * @param ctx the parse tree
	 */
	void enterDeclList(LexarParser.DeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#declList}.
	 * @param ctx the parse tree
	 */
	void exitDeclList(LexarParser.DeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(LexarParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(LexarParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(LexarParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(LexarParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#constDeclItemInner}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclItemInner(LexarParser.ConstDeclItemInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#constDeclItemInner}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclItemInner(LexarParser.ConstDeclItemInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#constDeclItem}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclItem(LexarParser.ConstDeclItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#constDeclItem}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclItem(LexarParser.ConstDeclItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#constExpr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(LexarParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#constExpr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(LexarParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(LexarParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(LexarParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#varDeclItemInner}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclItemInner(LexarParser.VarDeclItemInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#varDeclItemInner}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclItemInner(LexarParser.VarDeclItemInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#varDeclItem}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclItem(LexarParser.VarDeclItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#varDeclItem}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclItem(LexarParser.VarDeclItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(LexarParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(LexarParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#colonTypeChoice}.
	 * @param ctx the parse tree
	 */
	void enterColonTypeChoice(LexarParser.ColonTypeChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#colonTypeChoice}.
	 * @param ctx the parse tree
	 */
	void exitColonTypeChoice(LexarParser.ColonTypeChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#procFormalCallChoice}.
	 * @param ctx the parse tree
	 */
	void enterProcFormalCallChoice(LexarParser.ProcFormalCallChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#procFormalCallChoice}.
	 * @param ctx the parse tree
	 */
	void exitProcFormalCallChoice(LexarParser.ProcFormalCallChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#formalDeclInnerRepeat}.
	 * @param ctx the parse tree
	 */
	void enterFormalDeclInnerRepeat(LexarParser.FormalDeclInnerRepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#formalDeclInnerRepeat}.
	 * @param ctx the parse tree
	 */
	void exitFormalDeclInnerRepeat(LexarParser.FormalDeclInnerRepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#formalDecl}.
	 * @param ctx the parse tree
	 */
	void enterFormalDecl(LexarParser.FormalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#formalDecl}.
	 * @param ctx the parse tree
	 */
	void exitFormalDecl(LexarParser.FormalDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LexarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LexarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(LexarParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(LexarParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#stmtListStmtInner}.
	 * @param ctx the parse tree
	 */
	void enterStmtListStmtInner(LexarParser.StmtListStmtInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#stmtListStmtInner}.
	 * @param ctx the parse tree
	 */
	void exitStmtListStmtInner(LexarParser.StmtListStmtInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LexarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LexarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(LexarParser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(LexarParser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#exprInner}.
	 * @param ctx the parse tree
	 */
	void enterExprInner(LexarParser.ExprInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#exprInner}.
	 * @param ctx the parse tree
	 */
	void exitExprInner(LexarParser.ExprInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(LexarParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(LexarParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(LexarParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(LexarParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#lvalueInner}.
	 * @param ctx the parse tree
	 */
	void enterLvalueInner(LexarParser.LvalueInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#lvalueInner}.
	 * @param ctx the parse tree
	 */
	void exitLvalueInner(LexarParser.LvalueInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(LexarParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(LexarParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#sumCallInner}.
	 * @param ctx the parse tree
	 */
	void enterSumCallInner(LexarParser.SumCallInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#sumCallInner}.
	 * @param ctx the parse tree
	 */
	void exitSumCallInner(LexarParser.SumCallInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#outStmt}.
	 * @param ctx the parse tree
	 */
	void enterOutStmt(LexarParser.OutStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#outStmt}.
	 * @param ctx the parse tree
	 */
	void exitOutStmt(LexarParser.OutStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#outStmtInner}.
	 * @param ctx the parse tree
	 */
	void enterOutStmtInner(LexarParser.OutStmtInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#outStmtInner}.
	 * @param ctx the parse tree
	 */
	void exitOutStmtInner(LexarParser.OutStmtInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(LexarParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(LexarParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#ifStmtInner}.
	 * @param ctx the parse tree
	 */
	void enterIfStmtInner(LexarParser.IfStmtInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#ifStmtInner}.
	 * @param ctx the parse tree
	 */
	void exitIfStmtInner(LexarParser.IfStmtInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(LexarParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(LexarParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(LexarParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(LexarParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(LexarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(LexarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#conditionInner}.
	 * @param ctx the parse tree
	 */
	void enterConditionInner(LexarParser.ConditionInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#conditionInner}.
	 * @param ctx the parse tree
	 */
	void exitConditionInner(LexarParser.ConditionInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterInnerStatement(LexarParser.InnerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitInnerStatement(LexarParser.InnerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(LexarParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(LexarParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(LexarParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(LexarParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#exprsInner}.
	 * @param ctx the parse tree
	 */
	void enterExprsInner(LexarParser.ExprsInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#exprsInner}.
	 * @param ctx the parse tree
	 */
	void exitExprsInner(LexarParser.ExprsInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LexarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LexarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(LexarParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(LexarParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#sumInner}.
	 * @param ctx the parse tree
	 */
	void enterSumInner(LexarParser.SumInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#sumInner}.
	 * @param ctx the parse tree
	 */
	void exitSumInner(LexarParser.SumInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LexarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LexarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#termMultDivFactor}.
	 * @param ctx the parse tree
	 */
	void enterTermMultDivFactor(LexarParser.TermMultDivFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#termMultDivFactor}.
	 * @param ctx the parse tree
	 */
	void exitTermMultDivFactor(LexarParser.TermMultDivFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LexarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LexarParser.FactorContext ctx);
}