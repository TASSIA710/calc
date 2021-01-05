package net.tassia.calc;

import net.tassia.calc.provider.FunctionProvider;
import net.tassia.calc.provider.VariableProvider;
import net.tassia.calc.value.NumericValue;

@FunctionalInterface
public interface Evaluator {

	double evaluate(NumericValue expression, VariableProvider variableProvider, FunctionProvider functionProvider);

}
