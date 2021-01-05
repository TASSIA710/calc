package net.tassia.calc.provider;

import net.tassia.calc.Variable;

import java.util.NoSuchElementException;

/**
 * A variable provider is responsible for providing variables by name.
 * @author Tassilo
 * @since Calc 1.0
 */
@FunctionalInterface
public interface VariableProvider {

	/**
	 * Returns the value of the variable with the matching name.
	 * @param name the matching name
	 * @return the value of the variable
	 * @throws NoSuchElementException if no such variable exists
	 */
	Variable provideVariable(String name) throws NoSuchElementException;

}
