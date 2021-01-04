package net.tassia.calculator.parser;

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



	public static String getDisplayed(ParseException ex) {
		String str = ex.source;
		str += "\n";
		str += repeat(" ", ex.position) + repeat("^", ex.length);
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
