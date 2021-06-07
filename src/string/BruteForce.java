package string;

public class BruteForce {

	public static void main(String[] args) {
		String actual = "abckamalde";
		String pattern = "kamal";
		int index = stringMatching(actual, pattern);
		System.out.println("String found at position "+(index+1));
	}

	public static int stringMatching(String actual, String pattern) {
		int actLength = actual.length();
		int patLength = pattern.length();

		for (int i = 0; i < actLength - patLength; i++) {
			int j = 0;
			while (j < patLength && actual.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}
			if (j == patLength) {
				return i;
			}
		}
		return -1;
	}

}
