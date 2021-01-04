package net.tassia.calculator.provider;

import net.tassia.calculator.value.NumericValue;

import java.util.NoSuchElementException;

@FunctionalInterface
public interface VariableProvider {

	NumericValue provideVariable(String name) throws NoSuchElementException;

}
