package crashArray;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int searchNumber = binarySearch(arr, 0, arr.length - 1, 10);
		System.out.println(searchNumber);
	}

	static int binarySearch(int arr[], int l, int r, int number) {
		if (l <= r) {
			int mid = (l + r) / 2;

			if (arr[mid] == number) {
				return mid;
			}
			if (arr[mid] < number) {
				return binarySearch(arr, mid + 1, r, number);
			}
			return binarySearch(arr, l, mid - 1, number);
		}
		return -1;
	}

}
