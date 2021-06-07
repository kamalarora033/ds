package crashArray;

import java.util.Arrays;

public class TrappingWater {
	
	
	static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

	public static void main(String[] args) {
		System.out.println(trappingWater(arr.length));
	}

	static int trappingWater(int n) {
		int result = 0;

		int maxLeft[] = new int[n];
		int maxRight[] = new int[n];

		maxLeft[0] = arr[0];
		for (int i = 1; i < n; i++) {
			maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
		}
		maxRight[n-1] = arr[n-1];
		for(int i = n-2; i > 0; i--){
			maxRight[i] = Math.max(maxRight[i+1], arr[i]);
		}
		
		for(int i =0; i<n; i++){
			result = result + Math.min(maxLeft[i], maxRight[i]) - arr[i];
		}
		System.out.println(Arrays.toString(maxLeft));
		System.out.println(Arrays.toString(maxRight));
		return result;
	}

}
