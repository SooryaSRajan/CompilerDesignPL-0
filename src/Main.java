import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class Main {

    public static void main(String[] args) {

        try {
            CharStream input = new ANTLRFileStream("/Users/adheenababu/IdeaProjects/CompilerDesignPL-0/src/InputFiles/sum");
//            CharStream input = new ANTLRFileStream("/Users/adheenababu/IdeaProjects/CompilerDesignPL-0/src/InputFiles/multiplication");
//            CharStream input = new ANTLRFileStream("/Users/adheenababu/IdeaProjects/CompilerDesignPL-0/src/InputFiles/odd_numbers");
//            CharStream input = new ANTLRFileStream("/Users/adheenababu/IdeaProjects/CompilerDesignPL-0/src/InputFiles/fibonacci");
//            CharStream input = new ANTLRFileStream("/Users/adheenababu/IdeaProjects/CompilerDesignPL-0/src/InputFiles/stack");

            /* give your filepath in the above place*/
            Lexar lexer = new Lexar(input);
            String[] ruleNames = lexer.getRuleNames();
            Token token;
            while ((token = lexer.nextToken()).getType() != -1) {
                System.err.println("Line: " + token.getLine() + ":" + token.getStartIndex() + ", Token: <" + ruleNames[token.getType() - 1] + ", \"" + token.getText() + "\">");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}