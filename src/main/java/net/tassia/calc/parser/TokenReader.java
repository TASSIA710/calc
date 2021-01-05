package net.tassia.calc.parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Signals that a method is responsible for reading a grammar token.
 * @author Tassilo
 * @since Calculator 1.0
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface TokenReader {

	/**
	 * Returns the name of the token the method reads.
	 * @return the token name
	 */
	String value();

}
