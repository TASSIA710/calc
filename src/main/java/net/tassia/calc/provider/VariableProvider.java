package net.tassia.calc.provider;

import net.tassia.calc.value.NumericValue;

import java.util.NoSuchElementException;

@FunctionalInterface
public interface VariableProvider {

	NumericValue provideVariable(String name) throws NoSuchElementException;

}
