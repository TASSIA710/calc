package net.tassia.calc;

import net.tassia.calc.parser.DefaultExpressionParser;
import net.tassia.calc.parser.ParseException;
import net.tassia.calc.provider.ListFunctionProvider;
import net.tassia.calc.provider.ListVariableProvider;
import net.tassia.calc.value.NumericValue;

/**
 * This class can be used to parse and calculate expressions.
 * @author Tassilo
 * @since Calc 1.0
 */
public class Calculator {

	private final ListVariableProvider variableProvider;
	private final ListFunctionProvider functionProvider;
	private final Evaluator evaluator;

	/**
	 * Creates a new calculator with no pre-defined variables or functions.
	 */
	public Calculator() {
		this(new Variable[0], new Function[0]);
	}

	/**
	 * Creates a new calculator with the given pre-defined variables.
	 * @param variables pre-defined variables
	 */
	public Calculator(Variable...variables) {
		this(variables, new Function[0]);
	}

	/**
	 * Creates a new calculator with the given pre-defined functions.
	 * @param functions pre-defined functions
	 */
	public Calculator(Function...functions) {
		this(new Variable[0], functions);
	}

	/**
	 * Creates a new calculator with the given pre-defined variables and functions.
	 * @param variables pre-defined variables
	 * @param functions pre-defined functions
	 */
	public Calculator(Variable[] variables, Function[] functions) {
		this.variableProvider = new ListVariableProvider(variables);
		this.functionProvider = new ListFunctionProvider(functions);
		this.evaluator = new DefaultEvaluator();
	}



	public void addFunction(Function function) {
		functionProvider.addFunction(function);
	}

	public void removeFunction(Function function) {
		functionProvider.removeFunction(function.getName());
	}

	public void removeFunction(String name) {
		functionProvider.removeFunction(name);
	}



	public void addVariable(Variable variable) {
		variableProvider.addVariable(variable);
	}

	public void removeVariable(Variable variable) {
		variableProvider.removeVariable(variable.getName());
	}

	public void removeVariable(String name) {
		variableProvider.removeVariable(name);
	}



	/**
	 * Evaluates the given numeric value to a primitive double.<br/>
	 * <b>Note:</b> Depending on your numeric value, this method might take a while to compute.
	 * @param value the numeric value
	 * @return the evaluated value
	 */
	public double evaluateTerm(NumericValue value) {
		return evaluator.evaluate(value, variableProvider, functionProvider);
	}



	public static Calculator newDefault() {
		return new Calculator(Variable.getDefault(), Function.getDefault());
	}

	public static double calculate(String term) throws ParseException {
		return Calculator.newDefault().evaluateTerm(new DefaultExpressionParser().parse(term));
	}

}
