package net.tassia.calc.value;

import net.tassia.calc.Operator;

/**
 * A poly value consists of an operator and an undefined amount of values.
 * @author Tassilo
 * @since Calc 1.0
 */
public class PolyValue implements NumericValue {

    private final Operator.Poly operator;
    private final NumericValue[] values;

	/**
	 * Creates a new poly value with the given operator and values.
	 * @param operator the operator
	 * @param values the values
	 */
	public PolyValue(Operator.Poly operator, NumericValue...values) {
        this.operator = operator;
        this.values = values;
    }

	/**
	 * Returns the operator of this poly value.
	 * @return the operator
	 */
	public Operator.Poly getOperator() {
        return operator;
    }

	/**
	 * Returns the values of this poly value.
	 * @return the values
	 */
	public NumericValue[] getValues() {
        return values;
    }

}
