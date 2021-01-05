package net.tassia.calc.provider;

import net.tassia.calc.Function;

import java.util.NoSuchElementException;

/**
 * A function provider is responsible for providing functions by name.
 * @author Tassilo
 * @since Calc 1.0
 */
@FunctionalInterface
public interface FunctionProvider {

	/**
	 * Returns the function with the matching name.
	 * @param name the matching name
	 * @return the function
	 * @throws NoSuchElementException if no such function exists
	 */
	Function provideFunction(String name) throws NoSuchElementException;

}
