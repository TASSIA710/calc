package net.tassia.calc.value;

public class Fraction implements NumericValue {

    private final NumericValue upper, lower;

    public Fraction(NumericValue upper, NumericValue lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public NumericValue getUpper() {
        return upper;
    }

    public NumericValue getLower() {
        return lower;
    }

}
