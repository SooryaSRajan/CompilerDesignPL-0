
package AST;

public class EmptyDeclList extends DeclList implements ASTNode{
	
	public EmptyDeclList() {
		//TODO: Add right constructors
		
	}
	@Override
	public void print() {
        System.out.println("DeclList`s epsilon");
	}

}
