package easy;

import java.util.Arrays;

public class Selection {
	public static void main(String[] args) {
		int[] arr = { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			arr[i] = arr[index];
			arr[index] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
