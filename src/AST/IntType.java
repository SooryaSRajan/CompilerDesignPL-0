
package AST;

public class IntType extends Type implements ASTNode{
	String s;

	public IntType(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("IntType( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
