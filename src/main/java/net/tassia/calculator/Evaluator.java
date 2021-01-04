package net.tassia.calculator;

import net.tassia.calculator.provider.FunctionProvider;
import net.tassia.calculator.provider.VariableProvider;
import net.tassia.calculator.value.NumericValue;

@FunctionalInterface
public interface Evaluator {

	double evaluate(NumericValue expression, VariableProvider variableProvider, FunctionProvider functionProvider);

}
