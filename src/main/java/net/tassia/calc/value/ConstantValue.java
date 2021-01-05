package net.tassia.calc.value;

/**
 * A constant value has a fixed double associated with it.
 * @author Tassilo
 * @since Calc 1.0
 */
public class ConstantValue implements NumericValue {

    private final double value;

	/**
	 * Creates a new constant value with the given value.
	 * @param value the value
	 */
	public ConstantValue(double value) {
        this.value = value;
    }

	/**
	 * Returns the value of this constant value.
	 * @return the value
	 */
	public double getValue() {
        return value;
    }

}
