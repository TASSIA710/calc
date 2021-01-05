package net.tassia.calc.value;

import net.tassia.calc.Operator;

public class UnaryValue implements NumericValue {

    private final Operator.Unary operator;
    private final NumericValue value;

    public UnaryValue(Operator.Unary operator, NumericValue value) {
        this.operator = operator;
        this.value = value;
    }

    public Operator.Unary getOperator() {
        return operator;
    }

    public NumericValue getValue() {
        return value;
    }

}
