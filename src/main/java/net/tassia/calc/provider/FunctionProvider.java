package net.tassia.calc.provider;

import java.util.NoSuchElementException;

@FunctionalInterface
public interface FunctionProvider {

	double provideFunction(String name, double...arguments) throws NoSuchElementException;

}
