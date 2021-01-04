package net.tassia.calculator;

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

	private MathExtensions() {
	}

}
