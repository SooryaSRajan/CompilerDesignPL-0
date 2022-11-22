
package AST;

public class LtRelop extends Relop implements ASTNode{
	String s;

	public LtRelop(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("LtRelop( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
