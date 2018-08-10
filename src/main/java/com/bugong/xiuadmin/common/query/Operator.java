package com.bugong.xiuadmin.common.query;

public enum Operator {

    EQ("="),
    GT(">"),
    GTE(">="),
    LT("<"),
    LTE("<="),
    NEQ("<>"),
    LIKE("LIKE"),
    BLIKE("LIKE"),  // begin like, xxx%
    ELIKE("LIKE"),  // end like, %xxx
    IS("IS");

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
