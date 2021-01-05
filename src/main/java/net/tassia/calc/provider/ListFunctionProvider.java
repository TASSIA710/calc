package net.tassia.calc.provider;

import net.tassia.calc.Function;

import java.util.*;

public class ListFunctionProvider implements FunctionProvider {

	private final Map<String, Function> map;

	public ListFunctionProvider(Function...functions) {
		this(Arrays.asList(functions));
	}

	public ListFunctionProvider(Collection<Function> functions) {
		this.map = new HashMap<>();
		for (Function fun : functions) {
			map.put(fun.getName(), fun);
		}
	}

	public void addFunction(Function function) {
		map.put(function.getName(), function);
	}

	public void removeFunction(String name) {
		map.remove(name);
	}

	@Override
	public double provideFunction(String name, double... arguments) throws NoSuchElementException {
		Function fun = map.get(name);
		if (fun == null) {
			throw new NoSuchElementException("Function '" + name + "' not found.");
		}
		return fun.getValue(arguments);
	}

}
