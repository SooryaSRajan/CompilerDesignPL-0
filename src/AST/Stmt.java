package AST;

public abstract class Stmt implements ASTNode {
    @Override
    public void print() {

        if (this instanceof FunctionCallStmt) this.print();
        if (this instanceof AssignmentStmt) this.print();
        if (this instanceof ProcedureReturnStmt) this.print();
        if (this instanceof OutputStmt) this.print();
        if (this instanceof IfBlockStmt) this.print();
        if (this instanceof WhileLoopStmt) this.print();
        if (this instanceof ForLoopStmt) this.print();


    }
}


