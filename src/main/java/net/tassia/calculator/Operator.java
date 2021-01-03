package net.tassia.calculator;

public final class Operator {

    public enum Unary {
        NEGATION,
        BIG_NOT
    }

    public enum Binary {
        EXPONENT,
        BIT_XOR
    }

    public enum Poly {
        ADDITION,
        MULTIPLICATION,
        BIT_AND,
        BIT_OR
    }

    private Operator() {
    }

}
