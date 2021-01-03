package net.tassia.calculator;

import net.tassia.calculator.value.NumericValue;

public class Function {

    private final String name;
    private final NumericValue body;

    public Function(String name, NumericValue body) {
        this.name = name;
        this.body = body;
    }

    public String getFunctionName() {
        return name;
    }

    public NumericValue getFunctionBody() {
        return body;
    }

}
