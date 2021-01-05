package net.tassia.calc;

import net.tassia.calc.provider.FunctionProvider;
import net.tassia.calc.provider.VariableProvider;
import net.tassia.calc.value.*;

public class DefaultEvaluator implements Evaluator<Double> {

	@Override
	public Double evaluate(NumericValue expression, VariableProvider variableProvider, FunctionProvider functionProvider) {
		if (expression instanceof BinaryValue) {
			BinaryValue cast = (BinaryValue) expression;
			double left = evaluate(cast.getLeftHand(), variableProvider, functionProvider);
			double right = evaluate(cast.getRightHand(), variableProvider, functionProvider);
			if (cast.getOperator() == Operator.Binary.EXPONENT) {
				return Math.pow(left, right);
			}

		} else if (expression instanceof ConstantValue) {
			ConstantValue cast = (ConstantValue) expression;
			return cast.getValue();

		} else if (expression instanceof Fraction) {
			Fraction cast = (Fraction) expression;
			double upper = evaluate(cast.getUpper(), variableProvider, functionProvider);
			double lower = evaluate(cast.getLower(), variableProvider, functionProvider);
			return upper / lower;

		} else if (expression instanceof FunctionCall) {
			FunctionCall cast = (FunctionCall) expression;
			double[] args = new double[cast.getArguments().length];
			for (int i = 0; i < cast.getArguments().length; i++) {
				args[i] = evaluate(cast.getArguments()[i], variableProvider, functionProvider);
			}
			return functionProvider.provideFunction(cast.getFunction(), args);

		} else if (expression instanceof PolyValue) {
			PolyValue cast = (PolyValue) expression;
			double[] values = new double[cast.getValues().length];
			for (int i = 0; i < cast.getValues().length; i++) {
				values[i] = evaluate(cast.getValues()[i], variableProvider, functionProvider);
			}
			switch (cast.getOperator()) {
				case ADDITION:
					return MathExtensions.sum(values);
				case MULTIPLICATION:
					return MathExtensions.product(values);
			}

		} else if (expression instanceof UnaryValue) {
			UnaryValue cast = (UnaryValue) expression;
			double value = evaluate(cast.getValue(), variableProvider, functionProvider);
			if (cast.getOperator() == Operator.Unary.NEGATION) {
				return -value;
			}

		} else if (expression instanceof VariableCall) {
			VariableCall cast = (VariableCall) expression;
			NumericValue value = variableProvider.provideVariable(cast.getVariable());
			return evaluate(value, variableProvider, functionProvider);

		}
		throw new RuntimeException("Couldn't evaluate value: " + expression);
	}

}
