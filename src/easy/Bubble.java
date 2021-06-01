package easy;

import java.util.Arrays;

public class Bubble {
	public static void main(String[] args) {
		int[] arr = { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
