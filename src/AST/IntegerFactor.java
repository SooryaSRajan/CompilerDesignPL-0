
package AST;

public class IntegerFactor extends Factor implements ASTNode{
	String s;

	public IntegerFactor(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("IntegerFactor( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
