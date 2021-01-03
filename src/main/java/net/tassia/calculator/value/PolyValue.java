package net.tassia.calculator.value;

import net.tassia.calculator.Operator;

public class PolyValue implements NumericValue {

    private final Operator.Poly operator;
    private final NumericValue[] values;

    public PolyValue(Operator.Poly operator, NumericValue...values) {
        this.operator = operator;
        this.values = values;
    }

    public Operator.Poly getOperator() {
        return operator;
    }

    public NumericValue[] getValues() {
        return values;
    }

}
