package net.tassia.calc.provider;

import net.tassia.calc.Variable;
import net.tassia.calc.value.NumericValue;

import java.util.*;

public class ListVariableProvider implements VariableProvider {

	private final Map<String, Variable> map;

	public ListVariableProvider(Variable...variables) {
		this(Arrays.asList(variables));
	}

	public ListVariableProvider(Collection<Variable> variables) {
		this.map = new HashMap<>();
		for (Variable var : variables) {
			map.put(var.getName(), var);
		}
	}

	public void addVariable(Variable variable) {
		map.put(variable.getName(), variable);
	}

	public void removeVariable(String name) {
		map.remove(name);
	}

	@Override
	public NumericValue provideVariable(String name) throws NoSuchElementException {
		Variable var = map.get(name);
		if (var == null) {
			throw new NoSuchElementException("Variable '" + name + "' not found.");
		}
		return var.getValue();
	}

}
