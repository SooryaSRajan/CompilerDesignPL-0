
package AST;

public class InputFactor extends Factor implements ASTNode{
	String s;

	public InputFactor(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("InputFactor( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
