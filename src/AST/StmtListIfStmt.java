
package AST;

public class StmtListIfStmt extends IfStmt implements ASTNode {
    ASTNode t1, t2, t3;

    public StmtListIfStmt(ASTNode t1, ASTNode t2, ASTNode t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public void print() {

        System.out.println("StmtListIfStmt( ");
        t1.print();
        System.out.print(", ");
        t2.print();
        System.out.print(", ");
        t3.print();
        System.out.println(")");

    }

}
