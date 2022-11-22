package AST;

public abstract class ConstDecl implements ASTNode{
    @Override
    public void print() {

        if (this instanceof ItemsConstDecl) this.print();

    }
}
