package easy;

public class Fact {

	public static int factorial(int number) {
		int factorial = 1;

		for (int i = number; i >= 2; i--) {
			factorial = factorial * i;
		}
		return factorial;
	}

	public static int recursiveFactorial(int number) {
		if (number == 2) {
			return number;
		}

		return number * recursiveFactorial(number - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(recursiveFactorial(5));
	}
}
