package net.tassia.calc.value;

import net.tassia.calc.Operator;

/**
 * An unary value consists of an operator and a single value.
 * @author Tassilo
 * @since Core 1.0
 */
public class UnaryValue implements NumericValue {

    private final Operator.Unary operator;
    private final NumericValue value;

	/**
	 * Creates a new unary value with the given operator and value.
	 * @param operator the operator
	 * @param value the value
	 */
	public UnaryValue(Operator.Unary operator, NumericValue value) {
        this.operator = operator;
        this.value = value;
    }

	/**
	 * Returns the operator of this unary value.
	 * @return the operator
	 */
	public Operator.Unary getOperator() {
        return operator;
    }

	/**
	 * Returns the value of this unary value.
	 * @return the value
	 */
	public NumericValue getValue() {
        return value;
    }

}
