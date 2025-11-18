// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		// System.out.println(plus(20, 10)); // 2 + 3
		// System.out.println(minus(7, 2)); // 7 - 2
		// System.out.println(minus(-2, 7)); // 2 - 7
		// System.out.println(times(-3, -10)); // 3 * 4
		// System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		// System.out.println(pow(5, 3)); // 5^3
		// System.out.println(pow(3, 0)); // 3^5
		// System.out.println(div(12, 3)); // 12 / 3
		// System.out.println(div(5, 5)); // 5 / 5
		// System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(10, 2)); // 25 % 7
		// System.out.println(mod(120, 6)); // 120 % 6
		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
		// System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int total = 0;

		// x1 and x1 are both positive
		if ((x1 >= 0 && x2 >= 0)) {
			for (int i = 0; i <= x1; i++) {
				total = x2++;
			}
			// x1 is negative and x2 is positive or both are negative
		} else if ((x1 < 0 && x2 > 0) || (x1 < 0 && x2 < 0)) {
			for (int i = 0; i >= x1; i--) {
				total = x2--;
			}
			// x2 is negative and x1 is positive
		} else {
			for (int i = 0; i >= x2; i--) {
				total = x1--;
			}
		}
		return total;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int total = plus(x1, -x2);
		return total;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int total = 0;

		// x1 is positive and x2 is negative
		if (x1 >= 0 && x2 < 0) {
			for (int i = 0; i != x1; i++) {
				total = plus(total, x2);
			}
			// x1 and x2 are negative
		} else if (x1 < 0 && x2 < 0) {
			for (int i = 0; i != x2; i--) {
				total = minus(total, x1);
			}
		} else {
			for (int i = 0; i != x2; i++) {
				total = plus(total, x1);
			}
		}
		return total;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int total = 1;

		for (int i = 0; i < n; i++) {
			total = times(total, x);
		}
		return total;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {

		if (x1 == 0) {
			return 0;
		}
		boolean x1Neg = (x1 <= 0) ? true : false;
		boolean x2Neg = (x2 <= 0) ? true : false;
		x1 = x1Neg ? times(x1, -1) : x1;
		x2 = x2Neg ? times(x2, -1) : x2;

		int small = (x1 < x2) ? x1 : x2;
		int large = (x1 > x2) ? x1 : x2;
		int count = 0;

		while (large >= small) {
			large = minus(large, small);
			count++;
		}

		return ((x1Neg && x2Neg) || (!(x1Neg || x2Neg))) ? count : times(count, -1);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int division = div(x1, x2);
		int multiplication = times(x2, division);
		int remainder = minus(x1, multiplication);
		return remainder;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int l = 1;
		int g = div(plus(l, x), 2);
		return 0;
	}
}