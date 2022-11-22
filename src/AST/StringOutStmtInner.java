
package AST;

public class StringOutStmtInner extends OutStmtInner implements ASTNode {
    String s;

    public StringOutStmtInner(String s) {
        this.s = s;
    }

    @Override
    public void print() {

        System.out.println("StringOutStmtInner( ");
        System.out.println("ID: " + s);
        System.out.println(")");

    }

}
