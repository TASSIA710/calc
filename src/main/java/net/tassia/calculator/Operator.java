package net.tassia.calculator;

public final class Operator {

    public enum Unary {
        NEGATION
    }

    public enum Binary {
        EXPONENT
    }

    public enum Poly {
        ADDITION,
        MULTIPLICATION
    }

    private Operator() {
    }

}
