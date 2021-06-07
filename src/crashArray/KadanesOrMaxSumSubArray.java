package crashArray;

public class KadanesOrMaxSumSubArray {
	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int max = a[0];
		int tempMax = 0;

		for (int i = 0; i < a.length; i++) {
			tempMax = tempMax + a[i];
			
			if(tempMax < 0){
				tempMax = 0;
			} else if(tempMax > max){
				max = tempMax;
			}
		}
		System.out.println(max);
	}

}
