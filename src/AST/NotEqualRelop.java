
package AST;

public class NotEqualRelop extends Relop implements ASTNode{
	String s;

	public NotEqualRelop(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("NotEqualRelop( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
