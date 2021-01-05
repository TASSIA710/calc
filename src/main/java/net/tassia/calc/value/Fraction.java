package net.tassia.calc.value;

/**
 * A fraction consists of an upper and a lower part.
 * @author Tassilo
 * @since Calc 1.0
 */
public class Fraction implements NumericValue {

    private final NumericValue upper, lower;

	/**
	 * Creates a new fraction with the given upper and lower parts.
	 * @param upper the upper part
	 * @param lower the lower part
	 */
	public Fraction(NumericValue upper, NumericValue lower) {
        this.upper = upper;
        this.lower = lower;
    }

	/**
	 * Returns the upper part of this fraction.
	 * @return the upper part
	 */
	public NumericValue getUpper() {
        return upper;
    }

	/**
	 * Returns the lower part of this fraction.
	 * @return the lower part
	 */
	public NumericValue getLower() {
        return lower;
    }

}
