package net.tassia.calculator;

public class Function {

	private final String name;
	private final Body body;

	public Function(String name, Body body) {
		this.name = name;
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public double getValue(double...arguments) {
		return body.evaluateFunction(arguments);
	}

	@FunctionalInterface
	public interface Body {
		double evaluateFunction(double...arguments) throws AssertionError;
	}



	public static final Function SQRT = new Function("sqrt", (args) -> {
		assert args.length == 1;
		return Math.sqrt(args[0]);
	});

	public static final Function CBRT = new Function("cbrt", (args) -> {
		assert args.length == 1;
		return Math.cbrt(args[0]);
	});

	public static final Function MIN = new Function("min", (args) -> {
		assert args.length > 0;
		if (args.length == 2) {
			return Math.min(args[0], args[1]);
		} else {
			return MathExtensions.min(args);
		}
	});

	public static final Function MAX = new Function("max", (args) -> {
		assert args.length > 0;
		if (args.length == 2) {
			return Math.max(args[0], args[1]);
		} else {
			return MathExtensions.max(args);
		}
	});

	public static Function[] getDefault() {
		return new Function[] {
				SQRT, CBRT, MIN, MAX
		};
	}

}
