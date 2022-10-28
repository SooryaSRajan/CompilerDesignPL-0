package RDPFiles;

import GeneratedOutput.LexarLexer;
import org.antlr.v4.runtime.Token;

public class RDPParserPL0 {
    LexarLexer lexer;
    Token token;

    public RDPParserPL0(LexarLexer lexer) {
        this.lexer = lexer;
        System.out.println(lexer);
    }

    //start : program;
    public void start() {
        token = lexer.nextToken();
        System.out.println(program());
    }

    //program : MODULE MAIN SEMICOLON block MAIN DOT;
    public boolean program() {
        System.out.println("Visit program()");
        if (token.getType() == LexarLexer.MODULE) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.MAIN) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.SEMICOLON) {
                    token = lexer.nextToken();
                    if (block()) {
                        if (token.getType() == LexarLexer.MAIN) {
                            token = lexer.nextToken();
                            if (token.getType() == LexarLexer.DOT) {
                                System.out.println("Exit program()");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //block : declList BEGIN stmtList END;
    public boolean block() {
        System.out.println("Visit block()");
        if (declList()) {
            if (token.getType() == LexarLexer.BEGIN) {
                token = lexer.nextToken();
                if (stmtList()) {
                    if (token.getType() == LexarLexer.END) {
                        token = lexer.nextToken();
                        System.out.println("Exit block()");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //declList : (decl SEMICOLON)*;
    public boolean declList() {
        System.out.println("Visit declList()");
        while (decl()) {
            if(token.getType() != LexarLexer.SEMICOLON)
                token = lexer.nextToken();
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
            } else {
                return false;
            }
        }
        System.out.println("Exit declList()");
        return true;
    }

    //decl : constDecl
    //    | varDecl
    //    | procDecl;
    public boolean decl() {
        System.out.println("Visit decl()");
        if (token.getType() == LexarLexer.CONST && constDecl()) {
            System.out.println("Exit decl()");
            return true;
        } else if (token.getType() == LexarLexer.VAR && varDecl()) {
            System.out.println("Exit decl()");
            return true;
        } else if (token.getType() == LexarLexer.PROCEDURE && procDecl()) {
            System.out.println("Exit decl()");
            return true;
        }
        return false;
    }

    //constDecl : CONST constDeclItem (COMMA constDeclItem)*;
    public boolean constDecl() {
        System.out.println("Visit constDecl()");
        if (token.getType() == LexarLexer.CONST) {
            token = lexer.nextToken();
            if (constDeclItem()) {
                while (token.getType() == LexarLexer.COMMA) {
                    token = lexer.nextToken();
                    if (!constDeclItem()) {
                        return false;
                    }
                }
                System.out.println("Exit constDecl()");
                return true;
            }
        }
        return false;
    }

    //constDeclItem : ID COLON type EQUAL constExpr;
    public boolean constDeclItem() {
        System.out.println("Visit constDeclItem()");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    if (token.getType() == LexarLexer.EQUAL) {
                        token = lexer.nextToken();
                        if (constExpr()) {
                            System.out.println("Exit constDeclItem()");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //constExpr : ID
    //    | INTEGER
    //    | CHARACTER;
    public boolean constExpr() {
        System.out.println("Visit constExpr()");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            System.out.println("Exit constExpr()");
            return true;
        } else if (token.getType() == LexarLexer.INTEGER) {
            token = lexer.nextToken();
            System.out.println("Exit constExpr()");
            return true;
        } else if (token.getType() == LexarLexer.CHARACTER) {
            token = lexer.nextToken();
            System.out.println("Exit constExpr()");
            return true;
        }
        return false;
    }

    //varDecl : VAR varDeclItem (COMMA varDeclItem)*;
    public boolean varDecl() {
        System.out.println("Visit varDecl()");
        if (token.getType() == LexarLexer.VAR) {
            token = lexer.nextToken();
            if (varDeclItem()) {
                while (token.getType() == LexarLexer.COMMA) {
                    token = lexer.nextToken();
                    if (!varDeclItem()) {
                        return false;
                    }
                }
                System.out.println("Exit varDecl()");
                return true;
            }
        }
        return false;
    }

    //varDeclItem : ID COLON type;
    public boolean varDeclItem() {
        System.out.println("VisitvarDeclItem()");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    System.out.println("Exit varDeclItem()");
                    return true;
                }
            }
        }
        return false;
    }

    //procDecl : PROCEDURE ID BRACKET_OPEN (formalDecl (COMMA formalDecl)*)? BRACKET_CLOSE (COLON type)? SEMICOLON block ID;
    public boolean procDecl() {
        System.out.println("Visit procDecl()");
        if (token.getType() == LexarLexer.PROCEDURE) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.ID) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.BRACKET_OPEN) {
                    token = lexer.nextToken();
                    if (token.getType() == LexarLexer.ID && formalDecl()) {
                        while (token.getType() == LexarLexer.COMMA) {
                            token = lexer.nextToken();
                            if(token.getType() == LexarLexer.ID && formalDecl()) {
                                return false;
                            }
                        }
                    }
                    if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                        token = lexer.nextToken();
                        if (token.getType() == LexarLexer.COLON) {
                            token = lexer.nextToken();
                            if (!type()) {
                                return false;
                            }
                            else token = lexer.nextToken();
                        }
                        if (token.getType() == LexarLexer.SEMICOLON) {
                            token = lexer.nextToken();
                            if (block()) {
                                if (token.getType() == LexarLexer.ID) {
                                    token = lexer.nextToken();
                                    System.out.println("Exit procDecl()");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //formalDecl : ID COLON type;
    public boolean formalDecl() {
        System.out.println("Visit formalDecl()");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    token = lexer.nextToken();
                    System.out.println("Exit formalDecl()");
                    return true;
                }
            }
        }
        return false;
    }

    //type : INT
    //    | CHAR
    //    | ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type;

    public boolean type() {
        System.out.println("Visit type()");
        if (token.getType() == LexarLexer.INT) {
            System.out.println("Exit type()");
            return true;
        } else if (token.getType() == LexarLexer.CHAR) {
            System.out.println("Exit type()");
            return true;
        } else if (token.getType() == LexarLexer.ARRAY) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.SQ_OPEN) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.INTEGER) {
                    token = lexer.nextToken();
                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                        token = lexer.nextToken();
                        if (token.getType() == LexarLexer.OF) {
                            token = lexer.nextToken();
                            if (type()) {
                                System.out.println("Exit type()");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //stmtList : ((decl SEMICOLON)+ | (stmt SEMICOLON)+)*;
    public boolean stmtList(){
        System.out.println("IN STMTLIST, token: " + token.getText());
        while(token.getType() == LexarLexer.ID ||
                token.getType() == LexarLexer.RETURN || token.getType() == LexarLexer.OUTPUT ||
                token.getType() == LexarLexer.IF || token.getType() == LexarLexer.WHILE ||
                token.getType() == LexarLexer.FOR || token.getType() == LexarLexer.CONST ||
                token.getType() == LexarLexer.VAR || token.getType() == LexarLexer.PROCEDURE){
            System.out.println("IN STMTLIST while loop, token: " + token.getText());
            while((token.getType() == LexarLexer.CONST || token.getType() == LexarLexer.VAR || token.getType() == LexarLexer.PROCEDURE) && decl()){
                token = lexer.nextToken();
                System.out.println("IN declCheck && decl() while loop, token: " + token.getText());
                if (token.getType() == LexarLexer.SEMICOLON) {
                    token = lexer.nextToken();
                } else {
                    break;
                }
            }
            while((token.getType() == LexarLexer.ID ||
                    token.getType() == LexarLexer.RETURN || token.getType() == LexarLexer.OUTPUT ||
                    token.getType() == LexarLexer.IF || token.getType() == LexarLexer.WHILE ||
                    token.getType() == LexarLexer.FOR) && stmt()){
                token = lexer.nextToken();
                System.out.println("IN stmCheck && stmt() while loop, token: " + token.getText());
                if (token.getType() == LexarLexer.SEMICOLON) {
                    token = lexer.nextToken();
                } else {
                    break;
                }
            }
//            token = lexer.nextToken();
        }
        System.out.println("Exiting stmtList, token: " + token.getText());
        return true;
    }

    //stmt : callStmt
    //    | assignStmt
    //    | returnStmt
    //    | outStmt
    //    | ifStmt
    //    | whileStmt
    //    | forStmt;

    public boolean stmt() {
        System.out.println("IN STMT, token: " + token.getText());
        if (token.getType() == LexarLexer.ID) {
            if(callStmt()){
                System.out.println("Exiting stmt, token: " + token.getText());
                return true;
            }
            else if((token.getType() == LexarLexer.ASSIGNMENT || token.getType() == LexarLexer.SQ_OPEN) && assignStmt(true)){
                System.out.println("Exiting stmt, token: " + token.getText());
                return true;
            }
            else return false;
        }else if (token.getType() == LexarLexer.RETURN && returnStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.OUTPUT && outStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.IF && ifStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.WHILE && whileStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.FOR && forStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        }
        System.out.println("False condition in stmt block, token: " + token.getText());
        return false;
    }

    //callStmt : ID BRACKET_OPEN (exprs)? BRACKET_CLOSE;
    public boolean callStmt() {
        System.out.println("IN CALLSTMT, token: " + token.getText());
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.BRACKET_OPEN) {
                token = lexer.nextToken();
                if (exprs()) {
                    if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                        token = lexer.nextToken();
                        System.out.println("Exiting callStmt, token: " + token.getText());
                        return true;
                    }
                } else {
                    if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                        token = lexer.nextToken();
                        System.out.println("Exiting callStmt, token: " + token.getText());
                        return true;
                    }
                }
            }
        }
        System.out.println("False condition in callStmt block, token: " + token.getText());
        return false;
    }

    //assignStmt : lvalue ASSIGNMENT (expr);
    public boolean assignStmt(boolean value) {
        System.out.println("IN ASSIGNSTMT, token: " + token.getText());
        boolean sq = token.getType() == LexarLexer.SQ_OPEN;
        if (token.getType() == LexarLexer.ID || value) {
            if (lvalue(value)) {
                System.out.println("lvalue true loop ");
                if (sq)
                    token = lexer.nextToken();
                if (expr()) {
                    System.out.println("Exiting assignStmt, token: " + token.getText());
                    return true;
                }
            }
            System.out.println("False condition in assignStmt block, token: " + token.getText());
            return false;
        }
        return false;
    }

    //lvalue : ID
    //    | ID SQ_OPEN sum SQ_CLOSE;
    public boolean lvalue(boolean value) {
        System.out.println("IN LVALUE, token: " + token.getText());
        if (token.getType() == LexarLexer.ID || value) {
            if(token.getType() != LexarLexer.SQ_OPEN)
                token = lexer.nextToken();
            if (token.getType() == LexarLexer.SQ_OPEN) {
                token = lexer.nextToken();
                if (sum()) {
                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                        token = lexer.nextToken();
                        System.out.println("Exiting lvalue, token: " + token.getText());
                        return true;
                    }
                    else {
                        System.out.println("False condition in lvalue block, token: " + token.getText());
                        return false;
                    }
                }
            } else {
                System.out.println("Exiting lvalue, token: " + token.getText());
                return true;
            }
        }
        System.out.println("False condition in lvalue block, token: " + token.getText());
        return false;
    }

    //returnStmt : RETURN (sum)?;
    public boolean returnStmt() {
        System.out.println("IN RETURNSTMT, token: " + token.getText());
        if (token.getType() == LexarLexer.RETURN) {
            token = lexer.nextToken();
            if (sum()) {
                System.out.println("Exiting returnStmt, token: " + token.getText());
                return true;
            } else {
                System.out.println("Exiting returnStmt, token: " + token.getText());
                return true;
            }
        }
        System.out.println("False condition in returnStatement block, token: " + token.getText());
        return false;
    }

    //outStmt : OUTPUT ASSIGNMENT (expr | STRING);
    public boolean outStmt() {
        System.out.println("IN OUTSTMT, token: " + token.getText());
        if (token.getType() == LexarLexer.OUTPUT) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.ASSIGNMENT) {
                token = lexer.nextToken();
                if (expr()) {
                    System.out.println("Exiting outStmt, token: " + token.getText());
                    return true;
                } else if (token.getType() == LexarLexer.STRING) {
                    token = lexer.nextToken();
                    System.out.println("Exiting outStmt, token: " + token.getText());
                    return true;
                }
            }
        }
        System.out.println("False condition in outStmt block, token: " + token.getText());
        return false;
    }

    //ifStmt : IF condition THEN stmtList (SQ_OPEN ELSE stmtList SQ_CLOSE)? END;
    public boolean ifStmt() {
        System.out.println("IN IFSTMT, token: " + token.getText());
        if (token.getType() == LexarLexer.IF) {
            token = lexer.nextToken();
            if (condition()) {
                if (token.getType() == LexarLexer.THEN) {
                    token = lexer.nextToken();
                    if (stmtList()) {
                        if (token.getType() == LexarLexer.SQ_OPEN) {
                            token = lexer.nextToken();
                            if (token.getType() == LexarLexer.ELSE) {
                                token = lexer.nextToken();
                                if (stmtList()) {
                                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                                        token = lexer.nextToken();
                                        if (token.getType() == LexarLexer.END) {
                                            token = lexer.nextToken();
                                            System.out.println("Exiting ifStmt, token: " + token.getText());
                                            return true;
                                        }
                                    }
                                }
                            }
                        } else if (token.getType() == LexarLexer.END) {
                            token = lexer.nextToken();
                            System.out.println("Exiting ifStmt, token: " + token.getText());
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("False condition in ifStmt block, token: " + token.getText());
        return false;
    }

    //whileStmt : WHILE condition DO stmtList END;
    public boolean whileStmt() {
        System.out.println("IN WHILESTMT, token: " + token.getText());
        if (token.getType() == LexarLexer.WHILE) {
            token = lexer.nextToken();
            if (condition()) {
                if (token.getType() == LexarLexer.DO) {
                    token = lexer.nextToken();
                    if (stmtList()) {
                        if (token.getType() == LexarLexer.END) {
                            token = lexer.nextToken();
                            System.out.println("Exiting whileStmt, token: " + token.getText());
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("False condition in whileStmt block, token: " + token.getText());
        return false;
    }

    //forStmt : FOR sum TO sum DO stmtList END;
    public boolean forStmt() {
        System.out.println("IN FORSTMT, token: " + token.getText());
        if (token.getType() == LexarLexer.FOR) {
            token = lexer.nextToken();
            if (sum()) {
                if (token.getType() == LexarLexer.TO) {
                    token = lexer.nextToken();
                    if (sum()) {
                        if (token.getType() == LexarLexer.DO) {
                            token = lexer.nextToken();
                            if (stmtList()) {
                                if (token.getType() == LexarLexer.END) {
                                    token = lexer.nextToken();
                                    System.out.println("Exiting forStmt, token: " + token.getText());
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("False condition in forStmt block, token: " + token.getText());
        return false;
    }

    //condition : innerStatement
    //    | innerStatement AND condition
    //    | innerStatement OR condition
    //    | NOT condition;

    public boolean condition() {
        System.out.println("IN CONDITION, token: " + token.getText());
        if (innerStatement()) {
            if (token.getType() == LexarLexer.AND) {
                token = lexer.nextToken();
                if (condition()) {
                    System.out.println("Exiting condition, token: " + token.getText());
                    return true;
                }
            } else if (token.getType() == LexarLexer.OR) {
                token = lexer.nextToken();
                if (condition()) {
                    System.out.println("Exiting condition, token: " + token.getText());
                    return true;
                }
            } else {
                System.out.println("Exiting condition, token: " + token.getText());
                return true;
            }
        } else if (token.getType() == LexarLexer.NOT) {
            token = lexer.nextToken();
            if (condition()) {
                System.out.println("Exiting condition, token: " + token.getText());
                return true;
            }
        }
        System.out.println("False condition in condition block, token: " + token.getText());
        return false;
    }

    //innerStatement :  ODD sum
    //    | sum relop sum;
    public boolean innerStatement() {
        System.out.println("IN INNERSTATEMENT, token: " + token.getText());
        if (token.getType() == LexarLexer.ODD) {
            token = lexer.nextToken();
            if (sum()) {
                System.out.println("Exiting innerStatement, token: " + token.getText());
                return true;
            }
        } else if ((token.getType() == LexarLexer.MINUS || token.getType() == LexarLexer.ID ||
                token.getType() == LexarLexer.INTEGER || token.getType() == LexarLexer.INPUT ||
                token.getType() == LexarLexer.BRACKET_OPEN) && sum()) {
            if (relop()) {
                if (sum()) {
                    System.out.println("Exiting innerStatement, token: " + token.getText());
                    return true;
                }
            }
        }
        System.out.println("False condition in innerStatement block, token: " + token.getText());
        return false;
    }

    //relop : LT
    //    | LTE
    //    | EQUAL
    //    | GTE
    //    | GT
    //    | NOTEQUAL;
    public boolean relop() {
        System.out.println("IN RELOP, token: " + token.getText());
        if (token.getType() == LexarLexer.LT) {
            token = lexer.nextToken();
            System.out.println("Exiting relop, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.LTE) {
            token = lexer.nextToken();
            System.out.println("Exiting relop, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.EQUAL) {
            token = lexer.nextToken();
            System.out.println("Exiting relop, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.GTE) {
            token = lexer.nextToken();
            System.out.println("Exiting relop, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.GT) {
            token = lexer.nextToken();
            System.out.println("Exiting relop, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.NOTEQUAL) {
            token = lexer.nextToken();
            System.out.println("Exiting relop, token: " + token.getText());
            return true;
        }
        System.out.println("False condition in relop block, token: " + token.getText());
        return false;
    }

    //exprs : expr (COMMA expr)*;
    public boolean exprs() {
        System.out.println("IN EXPRS, token: " + token.getText());
        if (expr()) {
            while (token.getType() == LexarLexer.COMMA) {
                token = lexer.nextToken();
                if (!expr()) {
                    System.out.println("False condition in exprs block, token: " + token.getText());
                    return false;
                }
            }
            System.out.println("Exiting exprs, token: " + token.getText());
            return true;
        }
        System.out.println("False condition in exprs block, token: " + token.getText());
        return false;
    }

    //expr : sum
    //    | CHARACTER;
    public boolean expr() {
        System.out.println("IN EXPR, token: " + token.getText());
        if ((token.getType() == LexarLexer.MINUS || token.getType() == LexarLexer.ID ||
                token.getType() == LexarLexer.INTEGER || token.getType() == LexarLexer.INPUT ||
                token.getType() == LexarLexer.BRACKET_OPEN) && sum()) {
            System.out.println("Exiting expr, token: " + token.getText());
            if(token.getType() == LexarLexer.BRACKET_OPEN){
                token = lexer.nextToken();
            }
            return true;
        } else if (token.getType() == LexarLexer.CHARACTER) {
            token = lexer.nextToken();
            System.out.println("Exiting expr, token: " + token.getText());
            return true;
        }
        System.out.println("False condition in expr block, token: " + token.getText());
        return false;
    }

    //sum : term ((PLUS | MINUS) term)*;
    public boolean sum() {
        System.out.println("IN SUM, token: " + token.getText());
        if (term()) {
            while (token.getType() == LexarLexer.PLUS || token.getType() == LexarLexer.MINUS) {
                token = lexer.nextToken();
                if (!term()) {
                    System.out.println("False condition in sum block, token: " + token.getText());
                    return false;
                }
            }
            System.out.println("Exiting sum, token: " + token.getText());
            return true;
        }
        System.out.println("False condition in sum block, token: " + token.getText());
        return false;
    }

    //term : factor ((MULTIPLICATION | DIVISION) factor)*;
    public boolean term() {
        System.out.println("IN TERM, token: " + token.getText());
        if (factor()) {
            while (token.getType() == LexarLexer.MULTIPLICATION || token.getType() == LexarLexer.DIVISION) {
                token = lexer.nextToken();
                if (!factor()) {
                    System.out.println("False condition in term block, token: " + token.getText());
                    return false;
                }
            }
            System.out.println("Exiting term, token: " + token.getText());
            return true;
        }
        System.out.println("False condition in term block, token: " + token.getText());
        return false;
    }

    //factor : MINUS factor
    //    | lvalue
    //    | INTEGER
    //    | INPUT
    //    | callStmt
    //    | BRACKET_OPEN expr BRACKET_CLOSE;
    public boolean factor() {
        System.out.println("IN FACTOR, token: " + token.getText());
        if (token.getType() == LexarLexer.MINUS) {
            token = lexer.nextToken();
            if (factor()) {
                System.out.println("Exiting factor, token: " + token.getText());
                return true;
            }
        } else if (token.getType() == LexarLexer.ID && lvalue(false)) {
            System.out.println("Exiting factor, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.INTEGER) {
            token = lexer.nextToken();
            System.out.println("Exiting factor, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.INPUT) {
            token = lexer.nextToken();
            System.out.println("Exiting factor, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.ID && callStmt()) {
            System.out.println("Exiting factor, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.BRACKET_OPEN) {
            token = lexer.nextToken();
            if (expr()) {
                if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                    token = lexer.nextToken();
                    System.out.println("Exiting factor, token: " + token.getText());
                    return true;
                }
            }
        }
        System.out.println("False condition in factor block, token: " + token.getText());
        return false;
    }

}
