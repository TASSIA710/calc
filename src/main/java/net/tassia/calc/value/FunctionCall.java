package net.tassia.calc.value;

public class FunctionCall implements NumericValue {

    private final String function;
    private final NumericValue[] arguments;

    public FunctionCall(String function, NumericValue...arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    public String getFunction() {
        return function;
    }

    public NumericValue[] getArguments() {
        return arguments;
    }

}
