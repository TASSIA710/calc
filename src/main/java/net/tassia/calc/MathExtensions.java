package net.tassia.calc;

public class MathExtensions {

	public static double min(double...values) {
		double cache = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] < cache) {
				cache = values[i];
			}
		}
		return cache;
	}

	public static double max(double...values) {
		double cache = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > cache) {
				cache = values[i];
			}
		}
		return cache;
	}

	public static double sum(double...values) {
		double x = 0;
		for (double val : values) x += val;
		return x;
	}

	public static double product(double...values) {
		double x = 1;
		for (double val : values) x *= val;
		return x;
	}

	private MathExtensions() {
	}

}
