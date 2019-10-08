import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(sc.nextLine());
			StringTokenizer stringTokenizer = new StringTokenizer(sc.nextLine());	
			int[] nums = new int[stringTokenizer.countTokens()];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			Arrays.sort(nums);
			int seatNum = 0;
			for (int i = 0; i < nums.length-1; i++) {
				seatNum += nums[i]+1;
			}
			
			seatNum += nums[nums.length-1]*2 + 1;
			System.out.println("#"+test_case+" "+seatNum);
		}
	}
}