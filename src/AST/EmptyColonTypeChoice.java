
package AST;

public class EmptyColonTypeChoice extends ColonTypeChoice implements ASTNode{
	
	public EmptyColonTypeChoice() {
		//TODO: Add right constructors
		
	}
	@Override
	public void print() {
        System.out.println("ColonTypeChoice`s epsilon");
	}

}
