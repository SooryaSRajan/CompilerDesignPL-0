
package AST;

public class CharacterConstExpr extends ConstExpr implements ASTNode{
	String s;

	public CharacterConstExpr(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("CharacterConstExpr( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
