
package AST;

public class CharacterExpr extends Expr implements ASTNode{
	String s;

	public CharacterExpr(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("CharacterExpr( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
