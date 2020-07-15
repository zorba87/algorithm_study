package hblee;

/**
 * @author kulku
 * knapsack with DP(bottom- up)
 */
public class Knapsack {
	static int[] ws = {3,4,1,2,3};
	static int[] ps = {2,3,2,3,6};
	
	static int maxw= 10;
	static int[][]dp = new int[6][11];
	
	public static void main(String[] args) {
		int ret=0;
		
		for (int i = 0; i < ws.length; i++) {
			for (int j = 0; j <= maxw; j++) {
				if(dp[i+1][j] ==0 ) {
					dp[i+1][j] = dp[i][j];
				}
				
				if(j+ws[i] <= maxw) {
					dp[i+1][j+ws[i]] =Math.max(dp[i][j+ws[i]],dp[i][j]+ps[i]);
					ret = Math.max(dp[i+1][j+ws[i]],ret);

				}
			}
			printAll(i+1);
		}
		
		System.out.println(ret);
	}
	
	static void printAll(int i) {
		System.out.print(i+1 +": ");
		for (int j = 0; j < 11; j++) {
			System.out.print(dp[i][j]);
		}
		System.out.println();
	}
}
