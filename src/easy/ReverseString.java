package easy;

public class ReverseString {

	public static String recurString(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		return recurString(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
//		String recurString = recurString("kamal");
//		System.out.println(recurString);
		int i =0;
		int sum = 0;
		while(i < 100) {
			sum = sum + i;
			sum = i+sum;
			i+=1;
		}
		System.out.println(sum);
	}
}
