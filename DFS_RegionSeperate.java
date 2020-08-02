package algo2;

public class DFS_RegionSeperate{
	
	//무,당근,고구마
	static int[] frt = new int[3];
	static int length =4;
	static boolean[][] visit= new boolean[length][length];

	static int[][]v = new int[][] {
		    		{0,0,1,1},
		     	    {1,1,1,1},
		     	  	{2,2,2,1},
		      	 	{0,0,0,2},
//		{0,0,1},
//		{1,0,1},
//		{2,2,2},
	};

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

	public static void main(String[] args) {		

	    for(int i=0; i<v.length ;i++) {
	    	for(int j=0; j< v[i].length; j++) {
	    		if(v[i][j] >= 0 && visit[i][j] == false) {
	    			
	    			int val = v[i][j];
//	    			System.out.print(val);
	    			frt[val]++;
	    			search(val,i,j);
	    		}
	    		
	    	}
	    }
	    
	    for(int s: frt) {
	    	System.out.print(s);
	    }
	}
		
	static void search(int val,int x,int y) {
		visit[x][y] = true;	
		
		for(int i=0 ;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx<length && ny<length) {
				if(v[nx][ny] == val && visit[nx][ny] ==false) {
					search(val,nx,ny);
					
				}
			}
		}

	}
}
