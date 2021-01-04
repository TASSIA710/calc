package net.tassia.calculator;

import net.tassia.calculator.value.ConstantValue;
import net.tassia.calculator.value.NumericValue;
import org.jetbrains.annotations.NotNull;

public class Variable {

	@NotNull private final String name;
	@NotNull private final NumericValue value;

	public Variable(@NotNull String name, double value) {
		this(name, new ConstantValue(value));
	}

	public Variable(@NotNull String name, @NotNull NumericValue value) {
		this.name = name;
		this.value = value;
	}

	@NotNull
	public String getName() {
		return name;
	}

	@NotNull
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
