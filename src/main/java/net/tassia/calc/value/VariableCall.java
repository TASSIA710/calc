package net.tassia.calc.value;

public class VariableCall implements NumericValue {

    private final String variable;

    public VariableCall(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

}