package net.tassia.calc.value;

/**
 * A variable call represents a call to a variable.
 * @author Tassilo
 * @since Calc 1.0
 */
public class VariableCall implements NumericValue {

    private final String variable;

	/**
	 * Creates a new variable call with the given variable name.
	 * @param variable the name
	 */
	public VariableCall(String variable) {
        this.variable = variable;
    }

	/**
	 * Returns the name of the called variable.
	 * @return the name
	 */
	public String getVariable() {
        return variable;
    }

}
