
package AST;

public class LTERelop extends Relop implements ASTNode{
	String s;

	public LTERelop(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("LTERelop( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
