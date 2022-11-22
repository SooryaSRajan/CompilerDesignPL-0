
package AST;

public abstract class OutStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof AssignmentOutStmt) this.print();


	}
}
