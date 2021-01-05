package net.tassia.calc.value;

import net.tassia.calc.Operator;

/**
 * A binary value consists of an operator and two numeric values.
 * @author Tassilo
 * @since Calc 1.0
 */
public class BinaryValue implements NumericValue {

    private final Operator.Binary operator;
    private final NumericValue leftHand, rightHand;

	/**
	 * Creates a new binary value with the given operator, left-hand and right-hand value.
	 * @param operator the operator
	 * @param leftHand the left-hand value
	 * @param rightHand the right-hand value
	 */
    public BinaryValue(Operator.Binary operator, NumericValue leftHand, NumericValue rightHand) {
        this.operator = operator;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

	/**
	 * Returns the operator of this binary value.
	 * @return the operator
	 */
	public Operator.Binary getOperator() {
        return operator;
    }

	/**
	 * Returns the left-hand value of this binary value.
	 * @return the left-hand value
	 */
	public NumericValue getLeftHand() {
        return leftHand;
    }

	/**
	 * Returns the right-hand value of this binary value.
	 * @return the right-hand value
	 */
	public NumericValue getRightHand() {
        return rightHand;
    }

}
