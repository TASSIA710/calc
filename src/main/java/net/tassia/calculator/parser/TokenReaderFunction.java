package net.tassia.calculator.parser;

@FunctionalInterface
public interface TokenReaderFunction<T> {

	T read() throws ParseException;

}
