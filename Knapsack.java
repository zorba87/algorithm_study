package hblee;

public class Knapsack {
	static int[] ws = {3,4,1,2,3};
	static int[] ps = {2,3,2,3,6};
	
	static int maxw= 10;
	static int[][]dp = new int[6][11];
	
	public static void main(String[] args) {
		int sum =0;
		
		for (int i = 0; i <= ws.length; i++) {
			for (int j = 0; j <= maxw; j++) {

				dp[i][j] = Math.max(dp[i][j] + ps[i], dp[i][j]);
						
			}
		}
	}
}
