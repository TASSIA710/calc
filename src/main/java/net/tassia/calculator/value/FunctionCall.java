package net.tassia.calculator.value;

public class FunctionCall implements NumericValue {

    private final String variable;
    private final NumericValue[] arguments;

    public FunctionCall(String variable, NumericValue...arguments) {
        this.variable = variable;
        this.arguments = arguments;
    }

    public String getVariable() {
        return variable;
    }

    public NumericValue[] getArguments() {
        return arguments;
    }

}
