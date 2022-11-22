
package AST;

public class EmptyStmtList extends StmtList implements ASTNode{
	
	public EmptyStmtList() {
		//TODO: Add right constructors
		
	}
	@Override
	public void print() {
        System.out.println("StmtList`s epsilon");
	}

}
