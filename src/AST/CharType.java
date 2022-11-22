
package AST;

public class CharType extends Type implements ASTNode{
	String s;

	public CharType(String s) {
		this.s = s;
	}

	@Override
	public void print() {
        
		System.out.println("CharType( " );
		System.out.println("ID: " + s);
        System.out.println(")");

	}

}
