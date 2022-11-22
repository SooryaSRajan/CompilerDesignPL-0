
package AST;

public class EmptyExprInner extends ExprInner implements ASTNode{
	
	public EmptyExprInner() {
		//TODO: Add right constructors
		
	}
	@Override
	public void print() {
        System.out.println("ExprInner`s epsilon");
	}

}
