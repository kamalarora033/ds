package crashArray;

import java.util.Arrays;

public class ThreeSum {
	public static void main(String[] args) {
		int arr[] = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;
		Arrays.sort(arr);
		printTreeplet(arr, sum);
	}

	public static void printTreeplet(int[] arr, int sum) {

		for (int i = 0; i < arr.length - 2; i++) {
			int l = i + 1;
			int r = arr.length - 1;
			while (l < r) {
				if (arr[i] + arr[l] + arr[r] == sum) {
					System.out.println("{" + arr[i] + "," + arr[l] + "," + arr[r] + "}");
					break;
				} else if (arr[i] + arr[l] + arr[r] < sum) {
					l++;
				} else {
					r--;
				}
			}
		}
	}

}
