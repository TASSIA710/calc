package net.tassia.calc.parser;

/**
 * This exception is thrown when something goes wrong while parsing a string of text.
 * @author Tassilo
 * @since Calc 1.0
 */
public class ParseException extends Exception {

	private final String source;
	private final int position, length;

	public ParseException(String source, int position, int length, String message) {
		this(source, position, length, message, null);
	}

	public ParseException(String source, int position, int length, String message, Throwable cause) {
		super(message, cause);
		this.source = source;
		this.position = position;
		this.length = length;
	}

	public String getSource() {
		return source;
	}

	public int getPosition() {
		return position;
	}

	public int getLength() {
		return length;
	}



	/**
	 * Builds a displayable string for the exception. The string consists of two lines.
	 * @param ex the exception to format
	 * @return a displayable string
	 */
	public static String getDisplayed(ParseException ex) {
		String str = ex.getSource();
		str += "\n";
		str += repeat(" ", ex.getPosition()) + repeat("^", ex.getLength());
		return str;
	}

	/**
	 * Target JVM for Calculator is 1.8, so we cannot use {@link String#repeat(int)}.
	 * @param str the string to repeat
	 * @param amount the amount of times to repeat
	 * @return the generated string
	 */
	private static String repeat(String str, int amount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < amount; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

}
