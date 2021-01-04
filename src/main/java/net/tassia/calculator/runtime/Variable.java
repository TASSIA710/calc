package net.tassia.calculator.runtime;

import org.jetbrains.annotations.NotNull;

public class Variable {

	@NotNull private final String name;
	private final double value;

	public Variable(@NotNull String name, double value) {
		this.name = name;
		this.value = value;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public double getValue() {
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
