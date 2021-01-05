package net.tassia.calc.value;

/**
 * A function call represents a call to a function.
 * @author Tassilo
 * @since Calc 1.0
 */
public class FunctionCall implements NumericValue {

    private final String function;
    private final NumericValue[] arguments;

	/**
	 * Creates a new function call with the given function name and arguments.
	 * @param function the name
	 * @param arguments the arguments
	 */
    public FunctionCall(String function, NumericValue...arguments) {
        this.function = function;
        this.arguments = arguments;
    }

	/**
	 * Returns the name of the called function.
	 * @return the name
	 */
	public String getFunction() {
        return function;
    }

	/**
	 * Returns the arguments of this function call.
	 * @return the arguments
	 */
	public NumericValue[] getArguments() {
        return arguments;
    }

}
