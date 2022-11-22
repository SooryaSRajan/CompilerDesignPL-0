
package AST;

public class IDConstExpr extends ConstExpr implements ASTNode{

	String s;

	public IDConstExpr(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("IDConstExpr( " );
		System.out.println("ID " + s );
		System.out.println(")");

	}

}
