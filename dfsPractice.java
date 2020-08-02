package algo;


/**
 * @author kulku
 * Find path 2-d(w,h)
 */
public class dfsPractice {
	final int w =5,h=4;

	public static void main(String[] args) {
		dfsPractice call= new dfsPractice();
	
		int res = call.dfs(0,0);
		System.out.println(res);
		
		call.dfs3();
	}
	//1.일반 재귀로 
	//2.dp with memo
	int[][] memo = new int[w+1][h+1];
	int[][] memo2= new int[w+1][h+1];

	//normal recursive
	public int dfs(int nw, int nh) {
		if(nw > w || nh > h) return 0;
		if(nw == w && nh ==h )return 1;
		
		return dfs(nw+1,nh)+ dfs(nw,nh+1);
	}
	
	//top down > memorization
	public int dfs2(int nw, int nh) {
		if(nw > w || nh > h) return 0;
		if(nw == w && nh ==h )return 1;
		
		if(memo[nw][nh] != 0) return memo[nw][nh];
		return memo[nw][nh] = dfs(nw+1,nh)+ dfs(nw,nh+1);
	}
	
	//bottom up > memorization

	public void dfs3() {
		memo2[0][0] = 1;
		
		for (int i = 0; i <= w; i++) {
			for (int j = 0; j <= h; j++) {
				if(j!=0) memo2[i][j] += memo2[i][j-1]; 
				if(i!=0) memo2[i][j] += memo2[i-1][j];
			}
		}
		System.out.println("res :"+memo2[w][h]);
	}
	
}
