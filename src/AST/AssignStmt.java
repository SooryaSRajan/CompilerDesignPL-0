
package AST;

public abstract class AssignStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprAssignStmt) this.print();


	}
}
