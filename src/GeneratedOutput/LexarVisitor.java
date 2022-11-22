package GeneratedOutput;// Generated from /Users/sooryasrajan/AntlrCompilerDesign/src/Lexar.g4 by ANTLR 4.10.1
 import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LexarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LexarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LexarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LexarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LexarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LexarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#declList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclList(LexarParser.DeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(LexarParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(LexarParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#constDeclItemInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclItemInner(LexarParser.ConstDeclItemInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#constDeclItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclItem(LexarParser.ConstDeclItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#constExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(LexarParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(LexarParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#varDeclItemInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclItemInner(LexarParser.VarDeclItemInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#varDeclItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclItem(LexarParser.VarDeclItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#procDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcDecl(LexarParser.ProcDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#colonTypeChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColonTypeChoice(LexarParser.ColonTypeChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#procFormalCallChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcFormalCallChoice(LexarParser.ProcFormalCallChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#formalDeclInnerRepeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalDeclInnerRepeat(LexarParser.FormalDeclInnerRepeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#formalDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalDecl(LexarParser.FormalDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LexarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(LexarParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#stmtListStmtInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtListStmtInner(LexarParser.StmtListStmtInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LexarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#callStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStmt(LexarParser.CallStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#exprInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInner(LexarParser.ExprInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(LexarParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(LexarParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#lvalueInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueInner(LexarParser.LvalueInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(LexarParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#sumCallInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumCallInner(LexarParser.SumCallInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#outStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStmt(LexarParser.OutStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#outStmtInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStmtInner(LexarParser.OutStmtInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(LexarParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#ifStmtInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmtInner(LexarParser.IfStmtInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(LexarParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(LexarParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(LexarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#conditionInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionInner(LexarParser.ConditionInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#innerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerStatement(LexarParser.InnerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(LexarParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(LexarParser.ExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#exprsInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprsInner(LexarParser.ExprsInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LexarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(LexarParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#sumInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumInner(LexarParser.SumInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LexarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#termMultDivFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermMultDivFactor(LexarParser.TermMultDivFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LexarParser.FactorContext ctx);
}