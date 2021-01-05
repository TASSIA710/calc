package net.tassia.calc.value;

public class ConstantValue implements NumericValue {

    private final double value;

    public ConstantValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
