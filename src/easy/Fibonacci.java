package easy;

public class Fibonacci {

	public static int fibIterate(int number) {
		int arr[] = new int[number + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= number; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[number];
	}

	public static int fibRecursive(int number) {
		if (number <= 1) {
			return number;
		}

		return fibRecursive(number - 1) + fibRecursive(number - 2);
	}

	public static void main(String[] args) {
		System.out.println(fibIterate(8));
		System.out.println(fibRecursive(8));
	}

}
