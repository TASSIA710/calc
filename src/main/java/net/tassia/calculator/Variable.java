package net.tassia.calculator;

import net.tassia.calculator.value.ConstantValue;
import net.tassia.calculator.value.NumericValue;

public class Variable {

	private final String name;
	private final NumericValue value;

	public Variable(String name, double value) {
		this(name, new ConstantValue(value));
	}

	public Variable(String name, NumericValue value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public NumericValue getValue() {
		return value;
	}



	public static final Variable E = new Variable("e", Math.E);
	public static final Variable PI = new Variable("pi", Math.PI);

	public static Variable[] getDefault() {
		return new Variable[] {
				E, PI
		};
	}

}
