package crashArray;

public class NDivideKTimesNumber {
	public static void main(String[] args) {
		int a[] = {3, 1, 2, 2, 1, 2, 3, 3};
		int k = 4;
		int occurNumber = a.length/k;
		
		for(int i =0; i< a.length; i++){
			int counter = 1;
			for(int j = i+1; j < a.length; j++){
				if(a[i] == a[j]){
					counter++;
				}
			}
			if(counter > occurNumber){
				System.out.println(a[i]);
			}
		}
		
	}
	
	// Can do it with hashmap with time complexity O(n).

}
