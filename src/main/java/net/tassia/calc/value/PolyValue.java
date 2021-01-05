package net.tassia.calc.value;

import net.tassia.calc.Operator;

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
