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
        System.out.println("IN PROGRAM");
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
                                System.out.println("Exiting program block, token: " + token.getText());
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
        System.out.println("IN BLOCK");
        if (declList()) {
            if (token.getType() == LexarLexer.BEGIN) {
                token = lexer.nextToken();
                if (stmtList()) {
                    if (token.getType() == LexarLexer.END) {
                        token = lexer.nextToken();
                        System.out.println("Exiting block, token: " + token.getText());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //declList : (decl SEMICOLON)*;
    public boolean declList() {
        System.out.println("IN DECLLIST");
        while (decl()) {
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
            } else {
                return false;
            }
        }
        System.out.println("Exiting declList, token: " + token.getText());
        return true;
    }

    //decl : constDecl
    //    | varDecl
    //    | procDecl;
    public boolean decl() {
        System.out.println("IN DECL");
        if (token.getType() == LexarLexer.CONST && constDecl()) {
            System.out.println("Exiting decl, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.VAR && varDecl()) {
            System.out.println("Exiting decl, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.PROCEDURE && procDecl()) {
            System.out.println("Exiting decl, token: " + token.getText());
            return true;
        }
        return false;
    }

    //constDecl : CONST constDeclItem (COMMA constDeclItem)*;
    public boolean constDecl() {
        System.out.println("IN CONSTDECL");
        if (token.getType() == LexarLexer.CONST) {
            token = lexer.nextToken();
            if (constDeclItem()) {
                while (token.getType() == LexarLexer.COMMA) {
                    token = lexer.nextToken();
                    if (!constDeclItem()) {
                        return false;
                    }
                }
                System.out.println("Exiting constDecl, token: " + token.getText());
                return true;
            }
        }
        return false;
    }

    //constDeclItem : ID COLON type EQUAL constExpr;
    public boolean constDeclItem() {
        System.out.println("IN CONSTDECLITEM");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    if (token.getType() == LexarLexer.EQUAL) {
                        token = lexer.nextToken();
                        if (constExpr()) {
                            System.out.println("Exiting constDeclItem, token: " + token.getText());
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
        System.out.println("IN CONSTEXPR");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            System.out.println("Exiting constExpr, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.INTEGER) {
            token = lexer.nextToken();
            System.out.println("Exiting constExpr, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.CHARACTER) {
            token = lexer.nextToken();
            System.out.println("Exiting constExpr, token: " + token.getText());
            return true;
        }
        return false;
    }

    //varDecl : VAR varDeclItem (COMMA varDeclItem)*;
    public boolean varDecl() {
        System.out.println("IN VARDECL");
        if (token.getType() == LexarLexer.VAR) {
            token = lexer.nextToken();
            if (varDeclItem()) {
                while (token.getType() == LexarLexer.COMMA) {
                    token = lexer.nextToken();
                    if (!varDeclItem()) {
                        return false;
                    }
                }
                System.out.println("Exiting varDecl, token: " + token.getText());
                return true;
            }
        }
        return false;
    }

    //varDeclItem : ID COLON type;
    public boolean varDeclItem() {
        System.out.println("IN VARDECLITEM");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    System.out.println("Exiting varDeclItem, token: " + token.getText());
                    return true;
                }
            }
        }
        return false;
    }

    //procDecl : PROCEDURE ID BRACKET_OPEN (formalDecl (COMMA formalDecl)*)? BRACKET_CLOSE (COLON type)? SEMICOLON block ID;
    public boolean procDecl() {
        System.out.println("IN PROCDECL");
        if (token.getType() == LexarLexer.PROCEDURE) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.ID) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.BRACKET_OPEN) {
                    token = lexer.nextToken();
                    if (formalDecl()) {
                        while (token.getType() == LexarLexer.COMMA) {
                            token = lexer.nextToken();
                            if (!formalDecl()) {
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
                        }
                        if (token.getType() == LexarLexer.SEMICOLON) {
                            token = lexer.nextToken();
                            if (block()) {
                                if (token.getType() == LexarLexer.ID) {
                                    token = lexer.nextToken();
                                    System.out.println("Exiting procDecl, token: " + token.getText());
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
        System.out.println("IN FORMALDECL");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    System.out.println("Exiting formalDecl, token: " + token.getText());
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
        System.out.println("IN TYPE");
        if (token.getType() == LexarLexer.INT) {
            token = lexer.nextToken();
            System.out.println("Exiting type, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.CHAR) {
            token = lexer.nextToken();
            System.out.println("Exiting type, token: " + token.getText());
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
                                System.out.println("Exiting type, token: " + token.getText());
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
    public boolean stmtList() {
        System.out.println("IN STMTLIST");
        if (decl()) {
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
                while (decl()) {
                    if (token.getType() == LexarLexer.SEMICOLON) {
                        token = lexer.nextToken();
                    } else {
                        return false;
                    }
                }
            }
        } else if (stmt()) {
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
                while (stmt()) {
                    if (token.getType() == LexarLexer.SEMICOLON) {
                        token = lexer.nextToken();
                    } else {
                        return false;
                    }
                }
            }
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
        System.out.println("IN STMT");
        if (callStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (assignStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (returnStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (outStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (ifStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (whileStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        } else if (forStmt()) {
            System.out.println("Exiting stmt, token: " + token.getText());
            return true;
        }
        return false;
    }

    //callStmt : ID BRACKET_OPEN (exprs)? BRACKET_CLOSE;
    public boolean callStmt() {
        System.out.println("IN CALLSTMT");
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
        return false;
    }

    //assignStmt : lvalue ASSIGNMENT (expr);
    public boolean assignStmt() {
        System.out.println("IN ASSIGNSTMT");
        if (lvalue()) {
            if (token.getType() == LexarLexer.ASSIGNMENT) {
                token = lexer.nextToken();
                if (expr()) {
                    System.out.println("Exiting assignStmt, token: " + token.getText());
                    return true;
                }
            }
        }
        return false;
    }

    //lvalue : ID
    //    | ID SQ_OPEN sum SQ_CLOSE;
    public boolean lvalue() {
        System.out.println("IN LVALUE");
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.SQ_OPEN) {
                token = lexer.nextToken();
                if (sum()) {
                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                        token = lexer.nextToken();
                        System.out.println("Exiting lvalue, token: " + token.getText());
                        return true;
                    }
                }
            } else {
                System.out.println("Exiting lvalue, token: " + token.getText());
                return true;
            }
        }
        return false;
    }

    //returnStmt : RETURN (sum)?;
    public boolean returnStmt() {
        System.out.println("IN RETURNSTMT");
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
        return false;
    }

    //outStmt : OUTPUT ASSIGNMENT (expr | STRING);
    public boolean outStmt() {
        System.out.println("IN OUTSTMT");
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
        return false;
    }

    //ifStmt : IF condition THEN stmtList (SQ_OPEN ELSE stmtList SQ_CLOSE)? END;
    public boolean ifStmt() {
        System.out.println("IN IFSTMT");
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
        return false;
    }

    //whileStmt : WHILE condition DO stmtList END;
    public boolean whileStmt() {
        System.out.println("IN WHILESTMT");
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
        return false;
    }

    //forStmt : FOR sum TO sum DO stmtList END;
    public boolean forStmt() {
        System.out.println("IN FORSTMT");
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
        return false;
    }

    //condition : innerStatement
    //    | innerStatement AND condition
    //    | innerStatement OR condition
    //    | NOT condition;

    public boolean condition() {
        System.out.println("IN CONDITION");
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
        return false;
    }

    //innerStatement :  ODD sum
    //    | sum relop sum;
    public boolean innerStatement() {
        System.out.println("IN INNERSTATEMENT");
        if (token.getType() == LexarLexer.ODD) {
            token = lexer.nextToken();
            if (sum()) {
                System.out.println("Exiting innerStatement, token: " + token.getText());
                return true;
            }
        } else if (sum()) {
            if (relop()) {
                if (sum()) {
                    System.out.println("Exiting innerStatement, token: " + token.getText());
                    return true;
                }
            }
        }
        return false;
    }

    //relop : LT
    //    | LTE
    //    | EQUAL
    //    | GTE
    //    | GT
    //    | NOTEQUAL;
    public boolean relop() {
        System.out.println("IN RELOP");
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
        return false;
    }

    //exprs : expr (COMMA expr)*;
    public boolean exprs() {
        System.out.println("IN EXPRS");
        if (expr()) {
            while (token.getType() == LexarLexer.COMMA) {
                token = lexer.nextToken();
                if (!expr()) {
                    return false;
                }
            }
            System.out.println("Exiting exprs, token: " + token.getText());
            return true;
        }
        return false;
    }

    //expr : sum
    //    | CHARACTER;

    public boolean expr() {
        System.out.println("IN EXPR");
        if (sum()) {
            System.out.println("Exiting expr, token: " + token.getText());
            return true;
        } else if (token.getType() == LexarLexer.CHARACTER) {
            token = lexer.nextToken();
            System.out.println("Exiting expr, token: " + token.getText());
            return true;
        }
        return false;
    }

    //sum : term ((PLUS | MINUS) term)*;
    public boolean sum() {
        System.out.println("IN SUM");
        if (term()) {
            while (token.getType() == LexarLexer.PLUS || token.getType() == LexarLexer.MINUS) {
                token = lexer.nextToken();
                if (!term()) {
                    return false;
                }
            }
            System.out.println("Exiting sum, token: " + token.getText());
            return true;
        }
        return false;
    }

    //term : factor ((MULTIPLICATION | DIVISION) factor)*;
    public boolean term() {
        System.out.println("IN TERM");
        if (factor()) {
            while (token.getType() == LexarLexer.MULTIPLICATION || token.getType() == LexarLexer.DIVISION) {
                token = lexer.nextToken();
                if (!factor()) {
                    return false;
                }
            }
            System.out.println("Exiting term, token: " + token.getText());
            return true;
        }
        return false;
    }

    //factor : MINUS factor
    //    | lvalue
    //    | INTEGER
    //    | INPUT
    //    | callStmt
    //    | BRACKET_OPEN expr BRACKET_CLOSE;
    public boolean factor() {
        System.out.println("IN FACTOR");
        if (token.getType() == LexarLexer.MINUS) {
            token = lexer.nextToken();
            if (factor()) {
                System.out.println("Exiting factor, token: " + token.getText());
                return true;
            }
        } else if (lvalue()) {
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
        } else if (callStmt()) {
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
        return false;
    }

}
