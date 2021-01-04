package net.tassia.calculator.provider;

import java.util.NoSuchElementException;

@FunctionalInterface
public interface VariableProvider {

	double provideVariable(String name) throws NoSuchElementException;

}
