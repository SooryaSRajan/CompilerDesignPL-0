
package AST;

public class EqualRelop extends Relop implements ASTNode{
	String s;

	public EqualRelop(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("EqualRelop( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
