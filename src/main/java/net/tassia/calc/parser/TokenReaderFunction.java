package net.tassia.calc.parser;

@FunctionalInterface
public interface TokenReaderFunction<T> {

	T read() throws ParseException;

}
