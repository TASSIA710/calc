package net.tassia.calculator;

import net.tassia.calculator.parser.DefaultExpressionParser;
import net.tassia.calculator.parser.ExpressionParser;
import net.tassia.calculator.parser.ParseException;
import net.tassia.calculator.provider.FunctionProvider;
import net.tassia.calculator.provider.ListFunctionProvider;
import net.tassia.calculator.provider.ListVariableProvider;
import net.tassia.calculator.provider.VariableProvider;
import net.tassia.calculator.value.NumericValue;

public class Calculator {

	public static double calculate(String term) throws ParseException {
		ExpressionParser parser = new DefaultExpressionParser();
		NumericValue value = parser.parse(term);
		Evaluator evaluator = new DefaultEvaluator();
		VariableProvider variableProvider = new ListVariableProvider(Variable.getDefault());
		FunctionProvider functionProvider = new ListFunctionProvider(Function.getDefault());
		return evaluator.evaluate(value, variableProvider, functionProvider);
	}

}
