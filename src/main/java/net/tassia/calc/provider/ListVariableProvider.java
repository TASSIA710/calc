package net.tassia.calc.provider;

import net.tassia.calc.Variable;

import java.util.*;

/**
 * A ListVariableProvider is a VariableProvider that stores multiple variables.
 * @author Tassilo
 * @since Calc 1.0
 */
public class ListVariableProvider implements VariableProvider {

	private final Map<String, Variable> map;

	/**
	 * Constructs a new ListVariableProvider with the given pre-defined variables.
	 * @param variables the pre-defined variables
	 */
	public ListVariableProvider(Variable...variables) {
		this(Arrays.asList(variables));
	}

	/**
	 * Constructs a new ListVariableProvider with the given pre-defined variables.
	 * @param variables the pre-defined variables
	 */
	public ListVariableProvider(Collection<Variable> variables) {
		this.map = new HashMap<>();
		for (Variable var : variables) {
			map.put(var.getName(), var);
		}
	}

	/**
	 * Registers a new variable.
	 * @param variable the variable
	 */
	public void addVariable(Variable variable) {
		map.put(variable.getName(), variable);
	}

	/**
	 * Unregisters a variable using the given name.
	 * @param name the name
	 */
	public void removeVariable(String name) {
		map.remove(name);
	}

	@Override
	public Variable provideVariable(String name) throws NoSuchElementException {
		Variable var = map.get(name);
		if (var == null) {
			throw new NoSuchElementException("Variable '" + name + "' not found.");
		}
		return var;
	}

}
