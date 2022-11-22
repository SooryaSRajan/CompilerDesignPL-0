
package AST;

public class GtRelop extends Relop implements ASTNode{
	String s;

	public GtRelop(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("GtRelop( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
