
package AST;

public class IntegerConstExpr extends ConstExpr implements ASTNode{
	String s;

	public IntegerConstExpr(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("IntegerConstExpr( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
