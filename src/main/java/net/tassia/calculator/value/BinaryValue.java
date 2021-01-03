package net.tassia.calculator.value;

import net.tassia.calculator.Operator;

public class BinaryValue implements NumericValue {

    private final Operator.Binary operator;
    private final NumericValue leftHand, rightHand;

    public BinaryValue(Operator.Binary operator, NumericValue leftHand, NumericValue rightHand) {
        this.operator = operator;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    public Operator.Binary getOperator() {
        return operator;
    }

    public NumericValue getLeftHand() {
        return leftHand;
    }

    public NumericValue getRightHand() {
        return rightHand;
    }

}
