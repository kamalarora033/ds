package easy;

import java.util.Arrays;

public class Quick {
	public static void main(String[] args) {
		int arr[] = { 10, 3, 6, 4, 7, 2, 8, 0, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int startIndex, int end) {
		if (startIndex < end) {
			int pIndex = partition(arr, startIndex, end);

			quickSort(arr, startIndex, pIndex - 1);
			quickSort(arr, pIndex + 1, end);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr, int startIndex, int end) {
		int pivot = arr[arr.length - 1];
		int i = startIndex - 1;
		for (int j = startIndex; j <= end - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}

}
