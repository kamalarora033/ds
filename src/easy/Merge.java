package easy;

import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {
		int[] arr = { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
		Merge merge = new Merge();
		merge.mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	void mergeSort(int[] arr) {
		if (arr.length == 1) {
			return;
		}

		int middle = arr.length / 2;
		int[] left = new int[middle];
		int[] right = new int[arr.length - middle];
		for (int i = 0; i < middle; i++) {
			left[i] = arr[i];
		}

		for (int i = 0; i < arr.length - middle; i++) {
			right[i] = arr[middle + i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}

	void merge(int[] left, int[] right, int[] arr) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}

	}

}
