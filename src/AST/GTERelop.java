
package AST;

public class GTERelop extends Relop implements ASTNode{
	String s;

	public GTERelop(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("GTERelop( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
