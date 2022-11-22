
package AST;

public class TypeColonTypeChoice extends ColonTypeChoice implements ASTNode{
	ASTNode t1;

	public TypeColonTypeChoice(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("TypeColonTypeChoice( " );
        t1.print();
        System.out.println(")");

	}

}
