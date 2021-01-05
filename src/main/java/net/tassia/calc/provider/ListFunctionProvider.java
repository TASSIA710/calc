package net.tassia.calc.provider;

import net.tassia.calc.Function;

import java.util.*;

/**
 * A ListFunctionProvider is a FunctionProvider that stores multiple functions.
 * @author Tassilo
 * @since Calc 1.0
 */
public class ListFunctionProvider implements FunctionProvider {

	private final Map<String, Function> map;

	/**
	 * Constructs a new ListFunctionProvider with the given pre-defined functions.
	 * @param functions the pre-defined functions
	 */
	public ListFunctionProvider(Function...functions) {
		this(Arrays.asList(functions));
	}

	/**
	 * Constructs a new ListFunctionProvider with the given pre-defined functions.
	 * @param functions the pre-defined functions
	 */
	public ListFunctionProvider(Collection<Function> functions) {
		this.map = new HashMap<>();
		for (Function fun : functions) {
			map.put(fun.getName(), fun);
		}
	}

	/**
	 * Registers a new function.
	 * @param function the function
	 */
	public void addFunction(Function function) {
		map.put(function.getName(), function);
	}

	/**
	 * Unregisters a function using the given name.
	 * @param name the name
	 */
	public void removeFunction(String name) {
		map.remove(name);
	}

	@Override
	public Function provideFunction(String name) throws NoSuchElementException {
		Function fun = map.get(name);
		if (fun == null) {
			throw new NoSuchElementException("Function '" + name + "' not found.");
		}
		return fun;
	}

}
